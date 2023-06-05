package com.ruoyi.project.app.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.project.app.controller.request.BodyLicenses;
import com.ruoyi.project.app.controller.utils.License;
import com.ruoyi.project.app.domain.AppDevicesStatus;
import com.ruoyi.project.app.service.IAppDevicesStatusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
 * @date 2023-05-31
 */
@Api("授权管理")
@RestController
@RequestMapping("/app/licenses")
public class AppLicensesController extends BaseController
{
    @Autowired
    private IAppLicensesService appLicensesService;

    @Autowired
    private IAppDevicesStatusService appDevicesStatusService;

    /**
     * 查询授权管理列表
     */
    @PreAuthorize("@ss.hasPermi('app:licenses:list')")
    @GetMapping("/list")
    public TableDataInfo list(AppLicenses appLicenses)
    {
        startPage();
        List<AppLicenses> list = appLicensesService.selectAppLicensesList(appLicenses);
        return getDataTable(list);
    }

    /**
     * 导出授权管理列表
     */
    @PreAuthorize("@ss.hasPermi('app:licenses:export')")
    @Log(title = "授权管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AppLicenses appLicenses)
    {
        List<AppLicenses> list = appLicensesService.selectAppLicensesList(appLicenses);
        ExcelUtil<AppLicenses> util = new ExcelUtil<AppLicenses>(AppLicenses.class);
        util.exportExcel(response, list, "授权管理数据");
    }

    /**
     * 获取授权管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('app:licenses:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
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
        AppLicenses licenses = new AppLicenses();
        BeanUtils.copyBeanProp(licenses, appLicenses);
        List<AppDevicesStatus> list = new ArrayList<AppDevicesStatus>();
        for (int i = 0; i < appLicenses.getDeviceId().size(); i++) {
            AppDevicesStatus appDevicesStatus=new AppDevicesStatus();
            appDevicesStatus.setDeviceId(appLicenses.getDeviceId().get(i));
            appDevicesStatus.setUsed("0");
            appDevicesStatus.setEnabled("0");
            list.add(appDevicesStatus);
        }
        licenses.setProjectName(appLicenses.getProject().getName());
        licenses.setProjectAddress(appLicenses.getProject().getAddress());
        licenses.setProjectUsername(appLicenses.getProject().getContact().getName());
        licenses.setProjectMobile(appLicenses.getProject().getContact().getMobile());
        licenses.setAppDevicesStatusList(list);
        return toAjax(appLicensesService.insertAppLicenses(licenses));
    }

    /**
     * 修改授权管理
     */
    @PreAuthorize("@ss.hasPermi('app:licenses:edit')")
    @Log(title = "授权管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AppLicenses appLicenses)
    {
        return toAjax(appLicensesService.updateAppLicenses(appLicenses));
    }

    /**
     * 删除授权管理
     */
    @PreAuthorize("@ss.hasPermi('app:licenses:remove')")
    @Log(title = "授权管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(appLicensesService.deleteAppLicensesByIds(ids));
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
        List<AppDevicesStatus> list = appDevicesStatusService.selectAppDevicesStatusListByDeviceIds(deviceIds);

        //如果没有记录，生成为期三个月的授权
        if (list.size() == 0) {
            AppLicenses bodyLicenses = License.createThreeMonthLicense(deviceIds);
            appLicensesService.insertAppLicenses(bodyLicenses);
        }
        List<AppLicenses> listLicense = appLicensesService.selectAppLicensesListByDeviceIds(deviceIds);

        return success(listLicense);

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


        List<AppDevicesStatus> list = appDevicesStatusService.selectAppDevicesStatusListByDeviceIds(deviceIds);
        List<String> existIds = list.stream().map(AppDevicesStatus::getDeviceId).collect(Collectors.toList());
        List<String> notExistIds = deviceIds.stream().filter(item -> !existIds.contains(item)).collect(Collectors.toList());
        //如果不存在设备的授权文件则创建一个三个月的
        if (notExistIds.size() >= 0) {
            AppLicenses bodyLicenses = License.createThreeMonthLicense(notExistIds);
            appLicensesService.insertAppLicenses(bodyLicenses);
        }
        List<AppLicenses> listLicense = appLicensesService.selectAppLicensesListByDeviceIds(deviceIds);

        return success(listLicense);
    }



    /**
     * 状态修改
     */
    @ApiOperation("授权状态更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "licenseId", value = "license Id", dataType = "String",required = true, dataTypeClass = String.class),
            @ApiImplicitParam(name = "deviceId", value = "设备Id", dataType = "String", allowMultiple = true, required = true),
            @ApiImplicitParam(name = "used", value = "是否使用", dataType = "String",allowMultiple = true, dataTypeClass = String.class,required = true),
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
