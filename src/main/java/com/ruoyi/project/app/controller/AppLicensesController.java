package com.ruoyi.project.app.controller;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.common.utils.http.HttpUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.framework.web.domain.R;

import com.ruoyi.project.app.domain.AppSupplier;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
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
import com.ruoyi.project.app.domain.AppLicenses;
import com.ruoyi.project.app.service.IAppLicensesService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 授权管理Controller
 *
 * @author ruoyi
 * @date 2023-05-20
 */
@Api("授权管理")
@RestController
@RequestMapping("/app/licenses")
public class AppLicensesController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(HttpUtils.class);

    @Autowired
    private IAppLicensesService appLicensesService;

    /**
     * 查询授权管理列表
     */

    @PreAuthorize("@ss.hasPermi('app:licenses:list')")
    @GetMapping("/list")
    public TableDataInfo list(AppLicenses appLicenses) {
        startPage();
        List<AppLicenses> list = appLicensesService.selectAppLicensesList(appLicenses);
        return getDataTable(list);
    }


    /**
     * 获取授权管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('app:licenses:query')")
    @GetMapping(value = "/getByLicenseId/{licenseId}")
    public AjaxResult getInfo(@PathVariable("licenseId") String licenseId) {
        return success(appLicensesService.selectAppLicensesByLicenseId(licenseId));
    }

    /**
     * 获取授权管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('app:licenses:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(appLicensesService.selectAppLicensesById(id));
    }

    /**
     * 新增授权管理
     */
    @ApiOperation("授权文件创建")
    @PreAuthorize("@ss.hasPermi('app:licenses:add')")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "deviceId", value = "设备Id", dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "limitStart", value = "开始日期", dataType = "Date", dataTypeClass = Date.class),
            @ApiImplicitParam(name = "limitEnd", value = "截至日期", dataType = "Date", dataTypeClass = Date.class),
            @ApiImplicitParam(name = "projectName", value = "项目名称", dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "projectUsername", value = "联系人姓名", dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "projectMobile", value = "联系人电话", dataType = "String", dataTypeClass = String.class),
    })
    @Log(title = "授权管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@ApiIgnore @RequestBody AppLicenses appLicenses) {

        String uuid = IdUtils.simpleUUID();
        String licPath = "data/lic/" + uuid + ".lic";

        SimpleDateFormat format2 = new SimpleDateFormat("yyyy年MM月dd日");
        String limitEnd= format2.format(appLicenses.getLimitEnd()) ;
        try {


            // 设置命令参数
            List<String> cmds = new ArrayList<>();
            cmds.add("clt_license");
            cmds.add("--deviceId");
            cmds.add(appLicenses.getDeviceId());
            cmds.add("--password");
            cmds.add("123456");
            cmds.add("--date1");
            cmds.add(limitEnd);
            cmds.add("--mode");
            cmds.add("0");
            cmds.add("--output");
            cmds.add(licPath);

            ProcessBuilder processBuilder = new ProcessBuilder().command(cmds);

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

        appLicenses.setFileName(licPath);
        appLicenses.setLicenseId(uuid);
        System.out.println(appLicenses);


        return toAjax(appLicensesService.insertAppLicenses(appLicenses));
    }

    /**
     * 修改授权管理
     */
    @PreAuthorize("@ss.hasPermi('app:licenses:edit')")
    @Log(title = "授权管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AppLicenses appLicenses) {
        return toAjax(appLicensesService.updateAppLicenses(appLicenses));
    }


    /**
     * 查询授权管理列表
     */
    @ApiOperation("授权信息获取")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "deviceId", value = "设备Id", dataType = "String", dataTypeClass = String.class),
    })
    @PreAuthorize("@ss.hasPermi('app:licenses:list')")
    @GetMapping("/list/{deviceId}")
    public AjaxResult list(@PathVariable("deviceId") String deviceId) {

        List<AppLicenses> list = appLicensesService.selectAppLicensesListByDeviceId(deviceId);
        return success(list);
    }


    /**
     * 状态修改
     */
    @ApiOperation("授权状态更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "licenseId", value = "license Id", dataType = "Long", dataTypeClass = Long.class),
            @ApiImplicitParam(name = "used", value = "是否使用", dataType = "String", dataTypeClass = String.class),
    })
    @PreAuthorize("@ss.hasPermi('app:licenses:edit')")
    @Log(title = "授权管理", businessType = BusinessType.UPDATE)
    @PutMapping("/changeStatus")
    public AjaxResult changeStatus(@ApiIgnore @RequestBody AppLicenses appLicenses) {

        return toAjax(appLicensesService.updateAppLicenseStatus(appLicenses));
    }


    /**
     * 文件下载
     *
     * @param licenseId 文件名称
     * @return
     */

    @ApiOperation("授权文件获取")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "licenseId", value = "授权Id", dataType = "Long", dataTypeClass = Long.class),
    })
    @PostMapping("/file/download/{licenseId}")
    public void download(@PathVariable("licenseId") String licenseId, HttpServletResponse response) throws Exception {

        AppLicenses appLicenses = appLicensesService.selectAppLicensesByLicenseId(licenseId);
        if (appLicenses.getEnabled().equals("0")) {
            throw new Exception("没有审核不允许下载！");
        }

        String filePath = appLicenses.getFileName();

        if (StringUtils.isEmpty(filePath)) {
            throw new Exception("没有找到文件！");
        }
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        FileUtils.writeBytes(filePath, response.getOutputStream());
    }

}
