package com.ruoyi.project.app.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.common.utils.http.HttpUtils;
import com.ruoyi.common.utils.uuid.IdUtils;

import com.ruoyi.project.app.controller.request.BodyLicenses;
import com.ruoyi.project.app.controller.utils.License;
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
            @ApiImplicitParam(name = "deviceId", value = "设备Id", dataType = "String", allowMultiple = true, required = true),
            @ApiImplicitParam(name = "limitStart", value = "开始日期", dataType = "Date", dataTypeClass = Date.class),
            @ApiImplicitParam(name = "limitEnd", value = "截至日期", dataType = "Date", dataTypeClass = Date.class),
            @ApiImplicitParam(name = "projectName", value = "项目名称", dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "projectUsername", value = "联系人姓名", dataType = "String", dataTypeClass = String.class),
            @ApiImplicitParam(name = "projectMobile", value = "联系人电话", dataType = "String", dataTypeClass = String.class),
    })
    @Log(title = "授权管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@ApiIgnore @RequestBody BodyLicenses appLicenses) {

       appLicenses= License.createLicense(appLicenses);

        return toAjax(appLicensesService.insertBatchAppLicenses(appLicenses));
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
        List<String> deviceIds = new ArrayList<String>();
        deviceIds.add(deviceId);
        List<AppLicenses> list = appLicensesService.selectAppLicensesListByDeviceIds(deviceIds);
        //如果没有记录，生成为期三个月的授权
        if (list.size() == 0) {
            BodyLicenses appLicenses = License.createThreeMonthLicense(deviceIds);
            appLicensesService.insertBatchAppLicenses(appLicenses);
            list = appLicensesService.selectAppLicensesListByDeviceIds(deviceIds);
        }
        return success(list);
    }

    /**
     * 批量查询授权管理列表
     */
    @ApiOperation("批量授权信息获取")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "deviceId", value = "设备Id", dataType = "String", allowMultiple = true, required = true),
    })
    @PreAuthorize("@ss.hasPermi('app:licenses:list')")
    @PostMapping("/list/device_id")
    public AjaxResult listDevices(@ApiIgnore @RequestBody BodyLicenses appLicenses) {

        List<String> deviceIds = appLicenses.getDeviceId();
        List<AppLicenses> list = appLicensesService.selectAppLicensesListByDeviceIds(deviceIds);
        List<String> existIds = list.stream().map(AppLicenses::getDeviceId).collect(Collectors.toList());
        List<String> notExistIds = deviceIds.stream().filter(item -> !existIds.contains(item)).collect(Collectors.toList());

        if (notExistIds.size() >= 0) {

            BodyLicenses bodyLicenses = License.createThreeMonthLicense(notExistIds);
            appLicensesService.insertBatchAppLicenses(bodyLicenses);
            list = appLicensesService.selectAppLicensesListByDeviceIds(deviceIds);

        }
        return success(list);
    }


    /**
     * 状态修改
     */
    @ApiOperation("授权状态更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "licenseId", value = "license Id", dataType = "String",required = true, dataTypeClass = String.class),
            @ApiImplicitParam(name = "deviceId", value = "设备Id", dataType = "String", allowMultiple = true, required = true),
            @ApiImplicitParam(name = "used", value = "是否使用", dataType = "String", dataTypeClass = String.class,required = true),
    })
    @PreAuthorize("@ss.hasPermi('app:licenses:edit')")
    @Log(title = "授权管理", businessType = BusinessType.UPDATE)
    @PutMapping("/changeStatus")
    public AjaxResult changeStatus(@ApiIgnore @RequestBody BodyLicenses appLicenses) {

        return toAjax(appLicensesService.updateBatchAppLicenseStatus(appLicenses));
    }
    /**
     * 审核
     */

    @PreAuthorize("@ss.hasPermi('app:licenses:edit')")
    @Log(title = "授权管理", businessType = BusinessType.UPDATE)
    @PutMapping("/changeEnabled")
    public AjaxResult changeEnabled(@ApiIgnore @RequestBody AppLicenses appLicenses) {

        return toAjax(appLicensesService.updateAppLicenseEnabled(appLicenses));
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
        List<AppLicenses> list = appLicensesService.selectAppLicensesByLicenseId(licenseId);

        if (list.size()==0) {
            throw new Exception("没有找到文件！");
        }
        String filePath = list.get(0).getFileName();
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        FileUtils.writeBytes(filePath, response.getOutputStream());
    }

}
