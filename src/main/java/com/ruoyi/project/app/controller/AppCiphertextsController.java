package com.ruoyi.project.app.controller;

import java.io.*;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.http.HttpUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.project.app.controller.request.BodyCiphertexts;
import com.ruoyi.project.app.controller.utils.CipherText;
import com.ruoyi.project.app.domain.AppLicenses;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.app.domain.AppCiphertexts;
import com.ruoyi.project.app.service.IAppCiphertextsService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import springfox.documentation.annotations.ApiIgnore;


/**
 * 密文管理Controller
 *
 * @author ruoyi
 * @date 2023-05-20
 */
@Api("密文管理")
@RestController
@RequestMapping("/app/ciphertexts")
public class AppCiphertextsController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(HttpUtils.class);

    @Autowired
    private IAppCiphertextsService appCiphertextsService;

    /**
     * 查询密文管理列表
     */
    @PreAuthorize("@ss.hasPermi('app:ciphertexts:list')")
    @GetMapping("/list")
    public TableDataInfo list(AppCiphertexts appCiphertexts) {
        startPage();
        List<AppCiphertexts> list = appCiphertextsService.selectAppCiphertextsList(appCiphertexts);
        return getDataTable(list);
    }

    /**
     * 导出密文管理列表
     */
    @PreAuthorize("@ss.hasPermi('app:ciphertexts:export')")
    @Log(title = "密文管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AppCiphertexts appCiphertexts) {
        List<AppCiphertexts> list = appCiphertextsService.selectAppCiphertextsList(appCiphertexts);
        ExcelUtil<AppCiphertexts> util = new ExcelUtil<AppCiphertexts>(AppCiphertexts.class);
        util.exportExcel(response, list, "密文管理数据");
    }

    /**
     * 获取密文管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('app:ciphertexts:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(appCiphertextsService.selectAppCiphertextsById(id));
    }

    /**
     * 新增密文管理
     */
    @PreAuthorize("@ss.hasPermi('app:ciphertexts:add')")
    @Log(title = "密文管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AppCiphertexts appCiphertexts) {
        return toAjax(appCiphertextsService.insertAppCiphertexts(appCiphertexts));
    }

    /**
     * 修改密文管理
     */
    @PreAuthorize("@ss.hasPermi('app:ciphertexts:edit')")
    @Log(title = "密文管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AppCiphertexts appCiphertexts) {
        return toAjax(appCiphertextsService.updateAppCiphertexts(appCiphertexts));
    }

    /**
     * 删除密文管理
     */
    @PreAuthorize("@ss.hasPermi('app:ciphertexts:remove')")
    @Log(title = "密文管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(appCiphertextsService.deleteAppCiphertextsByIds(ids));
    }


    /**
     * 请求密文
     */
    @ApiOperation("请求密文")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "deviceId", value = "device id", dataType = "String", required = true, dataTypeClass = String.class),
            @ApiImplicitParam(name = "productType", value = "产品型号", dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "provider", value = "供应商", dataType = "String", dataTypeClass = String.class)

    })
    @PreAuthorize("@ss.hasPermi('app:ciphertexts:add')")
    @Log(title = "密文管理", businessType = BusinessType.INSERT)
    @PostMapping("/gor")
    public AjaxResult gor(@ApiIgnore @RequestBody AppCiphertexts appCiphertexts) throws NoSuchAlgorithmException, IOException {
        //查询是否存在
        AppCiphertexts appCiphertext = appCiphertextsService.selectAppCiphertextsByDeviceId(appCiphertexts.getDeviceId());
        AjaxResult ajax = AjaxResult.success();
        ajax.put("deviceId", appCiphertexts.getDeviceId());
        System.out.println(appCiphertext);
        if (appCiphertext == null) {
            appCiphertexts = CipherText.createCiphertext(appCiphertexts);
            System.out.println(appCiphertext);
            appCiphertextsService.insertAppCiphertexts(appCiphertexts);
            int[] intArray = CipherText.getCiphertext(appCiphertexts.getCiphertextPath());

            ajax.put("ciphertext", Arrays.toString(intArray));
        } else {
            int[] intArray = CipherText.getCiphertext(appCiphertext.getCiphertextPath());


            ajax.put("ciphertext", Arrays.toString(intArray));
        }


        return ajax;


    }


    /**
     * 状态修改
     */
    @ApiOperation("密文状态更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "deviceId", value = "device Id", dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "status", value = "是否烧写", dataType = "String", dataTypeClass = String.class),
    })
    @PreAuthorize("@ss.hasPermi('app:ciphertexts:edit')")
    @Log(title = "密文状态", businessType = BusinessType.UPDATE)
    @PutMapping("/changeStatus")
    public AjaxResult changeStatus(@ApiIgnore @RequestBody AppCiphertexts appCiphertexts) {

        return toAjax(appCiphertextsService.updateAppCiphertextsStatus(appCiphertexts));
    }


    /**
     * 请求密文
     */
    @ApiOperation("密文验证")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "deviceId", value = "device id", dataType = "String", dataTypeClass = String.class,required = true),
            @ApiImplicitParam(name = "productType", value = "产品型号", dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "ciphertext", value = "密文", dataType = "Integer", allowMultiple = true, required = true),

    })
    @Log(title = "密文管理", businessType = BusinessType.INSERT)
    @PostMapping("/verify")
    public AjaxResult verify(@ApiIgnore @RequestBody BodyCiphertexts appCiphertexts) throws
            NoSuchAlgorithmException, IOException {
        //查询是否存在
        AppCiphertexts ciphertext = appCiphertextsService.selectAppCiphertextsByDeviceId(appCiphertexts.getDeviceId());


        if (ciphertext != null) {


            int[] intArray = CipherText.getCiphertext(ciphertext.getCiphertextPath());


            System.out.println("error"+appCiphertexts.getCiphertext().toString());
            System.out.println("error"+ (Arrays.toString(intArray)));
            if (Arrays.toString(intArray).equals(appCiphertexts.getCiphertext().toString())) {
                return success(ciphertext);
            } else {
                return error("校验失败");
            }
        } else {
            return error("校验失败");
        }

    }
}
