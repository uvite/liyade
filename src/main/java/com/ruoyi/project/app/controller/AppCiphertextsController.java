package com.ruoyi.project.app.controller;

import java.io.*;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.http.HttpUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
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
public class AppCiphertextsController extends BaseController
{

    private static final Logger log = LoggerFactory.getLogger(HttpUtils.class);

    @Autowired
    private IAppCiphertextsService appCiphertextsService;

    /**
     * 查询密文管理列表
     */
    @PreAuthorize("@ss.hasPermi('app:ciphertexts:list')")
    @GetMapping("/list")
    public TableDataInfo list(AppCiphertexts appCiphertexts)
    {
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
    public void export(HttpServletResponse response, AppCiphertexts appCiphertexts)
    {
        List<AppCiphertexts> list = appCiphertextsService.selectAppCiphertextsList(appCiphertexts);
        ExcelUtil<AppCiphertexts> util = new ExcelUtil<AppCiphertexts>(AppCiphertexts.class);
        util.exportExcel(response, list, "密文管理数据");
    }

    /**
     * 获取密文管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('app:ciphertexts:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(appCiphertextsService.selectAppCiphertextsById(id));
    }

    /**
     * 新增密文管理
     */
    @PreAuthorize("@ss.hasPermi('app:ciphertexts:add')")
    @Log(title = "密文管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AppCiphertexts appCiphertexts)
    {
        return toAjax(appCiphertextsService.insertAppCiphertexts(appCiphertexts));
    }

    /**
     * 修改密文管理
     */
    @PreAuthorize("@ss.hasPermi('app:ciphertexts:edit')")
    @Log(title = "密文管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AppCiphertexts appCiphertexts)
    {
        return toAjax(appCiphertextsService.updateAppCiphertexts(appCiphertexts));
    }

    /**
     * 删除密文管理
     */
    @PreAuthorize("@ss.hasPermi('app:ciphertexts:remove')")
    @Log(title = "密文管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(appCiphertextsService.deleteAppCiphertextsByIds(ids));
    }


    /**
     * 请求密文
     */
    @ApiOperation("请求密文")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "deviceId", value = "device id", dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "productType", value = "产品型号", dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "provider", value = "供应商", dataType = "String", dataTypeClass = String.class)

    }) 
    @PreAuthorize("@ss.hasPermi('app:ciphertexts:add')")
    @Log(title = "密文管理", businessType = BusinessType.INSERT)
    @PostMapping("/gor")
    public AjaxResult gor(@ApiIgnore @RequestBody AppCiphertexts appCiphertexts) throws NoSuchAlgorithmException, IOException {
        //查询是否存在
        AppCiphertexts appCiphertext =appCiphertextsService.selectAppCiphertextsByDeviceId(appCiphertexts.getDeviceId());
        if(appCiphertext!=null){
            return success(appCiphertext);
        }else{
            //生成json文件
            String uuid = IdUtils.simpleUUID();
            String jsonPath = "data/temp/temp.json";
            String cpPath =  "data/cp/"+uuid + ".cp";

            JSONObject json = new JSONObject();
            try {
                json.put("deviceId", appCiphertexts.getDeviceId());
              //  json.put("args", arguments);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            try (PrintWriter out = new PrintWriter(new FileWriter(jsonPath))) {
                out.write(json.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                // 设置命令参数
                List<String> cmds = new ArrayList<>();
                cmds.add("clt_cipherText");
                cmds.add("--input");
                cmds.add(jsonPath);
                cmds.add("--output");
                cmds.add(cpPath);
                cmds.add("--mode");
                cmds.add("0");
                cmds.add("--deviceId");
                cmds.add(appCiphertexts.getDeviceId());
                ProcessBuilder processBuilder = new ProcessBuilder().command(cmds);
                // 设置工作目录这样他就会去D:\javaTool目录下找jar
             //   processBuilder.directory(new File("D:\\javaTool"));
                // 是否合并标准错误和标准输出
                processBuilder.redirectErrorStream(true);
                log.info("完整命令：{}", String.join(StringUtils.SPACE, processBuilder.command()));
                // 执行
                Process process = processBuilder.start();
                // 输出结果信息
                BufferedReader br1;
                br1 = new BufferedReader(new InputStreamReader(process.getInputStream(), "gbk"));
                String line1 = null;
                while ((line1 = br1.readLine()) != null) {
                    System.out.println(line1);
                }
                // 关闭Process
                if (process.isAlive()) {
                    process.destroy();
                }

            } catch (Exception e) {
                String msg = "启动任务失败:" + e.getMessage();
                log.error(msg, e);
            }


            MessageDigest md = MessageDigest.getInstance("MD5");
            try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(cpPath))) {
                byte[] buffer = new byte[1024];
                int read = 0;
                while ((read = bis.read(buffer)) != -1) {
                    md.update(buffer, 0, read);
                }
            }
            byte[] digest = md.digest();
            String md5 = String.format("%032x", new BigInteger(1, digest));

            appCiphertexts.setMd5(md5);


            appCiphertexts.setCiphertextPath(cpPath);
            appCiphertextsService.insertAppCiphertexts(appCiphertexts);

            return success(appCiphertexts);
        }

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
            @ApiImplicitParam(name = "deviceId", value = "device id", dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "productType", value = "产品型号", dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "ciphertext", value = "密文", dataType = "String", dataTypeClass = String.class)

    })
    @Log(title = "密文管理", businessType = BusinessType.INSERT)
    @PostMapping("/verify")
    public AjaxResult verify(@ApiIgnore @RequestBody AppCiphertexts appCiphertexts) throws NoSuchAlgorithmException, IOException {
        //查询是否存在
        AppCiphertexts appCiphertext =appCiphertextsService.selectAppCiphertextsByDeviceId(appCiphertexts.getDeviceId());
        if(appCiphertext!=null){
            if(appCiphertext.getCiphertext().equals(appCiphertexts.getCiphertext())) {
                return success(appCiphertext);
            }else{
                return error("校验失败");
            }
        }else{
            return error("校验失败");
        }

    }
}
