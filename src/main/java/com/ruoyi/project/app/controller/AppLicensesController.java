package com.ruoyi.project.app.controller;

import java.util.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.common.utils.sign.Md5Utils;
import com.ruoyi.project.app.controller.request.BodyLicenses;
import com.ruoyi.project.app.controller.request.LicensesCreate;
import com.ruoyi.project.app.controller.request.LicensesGet;
import com.ruoyi.project.app.controller.request.LicensesUpdate;
import com.ruoyi.project.app.controller.utils.CipherText;
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
@RequestMapping("/app/license")
public class AppLicensesController extends BaseController {
    @Autowired
    private IAppLicensesService appLicensesService;

    @Autowired
    private IAppDevicesStatusService appDevicesStatusService;

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
     * 导出授权管理列表
     */
    @PreAuthorize("@ss.hasPermi('app:licenses:export')")
    @Log(title = "授权管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AppLicenses appLicenses) {
        List<AppLicenses> list = appLicensesService.selectAppLicensesList(appLicenses);
        ExcelUtil<AppLicenses> util = new ExcelUtil<AppLicenses>(AppLicenses.class);
        util.exportExcel(response, list, "授权管理数据");
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
    @Log(title = "授权管理", businessType = BusinessType.INSERT)
    @PostMapping("/gen")
    public AjaxResult add(@RequestBody LicensesCreate appLicenses) {

        System.out.println(appLicenses.getProject().getName());
        System.out.println(appLicenses.getProject());
        if (appLicenses.getDeviceId().size() == 0
        ||StringUtils.isEmpty(appLicenses.getProject().getName())
        || StringUtils.isEmpty(appLicenses.getProject().getSn())
        ||StringUtils.isEmpty(appLicenses.getProject().getContact().getName())
        ||StringUtils.isEmpty(appLicenses.getProject().getContact().getMobile())
        ) {
            return error("缺少授权创建所需必要信息",4005);
        }

        //判断是否重复提交
        String data = String.format("%s+%s", appLicenses.getDeviceId().toString(), appLicenses.getLimitEnd());
        String md5 = Md5Utils.hash(data);

        AppLicenses licensesMd5 = appLicensesService.selectAppLicensesByMd5(md5);
        if (licensesMd5 != null) {
            return error("授权文件审核中",4004);
        }
        Map<String, String> newLicense = License.createLicense(appLicenses);
        if (StringUtils.isEmpty(newLicense.get("fileName"))) {
            return error("授权文件创建失败，请联系管理员",4006);
        }
        AppLicenses licenses = new AppLicenses();
        BeanUtils.copyBeanProp(licenses, appLicenses);
        List<AppDevicesStatus> list = new ArrayList<AppDevicesStatus>();
        for (int i = 0; i < appLicenses.getDeviceId().size(); i++) {
            AppDevicesStatus appDevicesStatus = new AppDevicesStatus();
            appDevicesStatus.setDeviceId(appLicenses.getDeviceId().get(i));
            appDevicesStatus.setUsed("0");
            appDevicesStatus.setEnabled("0");
            list.add(appDevicesStatus);
        }
        licenses.setLicenseId(newLicense.get("licenseId"));
        licenses.setFileName(newLicense.get("fileName"));
        licenses.setMd5(md5);
        licenses.setProjectName(appLicenses.getProject().getName());
        licenses.setProjectSn(appLicenses.getProject().getSn());
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
    public AjaxResult edit(@RequestBody AppLicenses appLicenses) {
        return toAjax(appLicensesService.updateAppLicenses(appLicenses));
    }

    /**
     * 删除授权管理
     */
    @PreAuthorize("@ss.hasPermi('app:licenses:remove')")
    @Log(title = "授权管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(appLicensesService.deleteAppLicensesByIds(ids));
    }


    /**
     * 批量查询授权管理列表
     */
    @ApiOperation("批量授权信息获取")
    @PreAuthorize("@ss.hasPermi('app:licenses:list')")
    @PostMapping("/list/deviceId")
    public AjaxResult listDevices(@RequestBody LicensesGet appLicenses) {

        System.out.println("appLicenses");
        System.out.println(appLicenses);

        List<String> deviceIds = appLicenses.getDeviceId();

        if (deviceIds.size() == 0) {
            return error("设备ID不能为空");
        }

        List<AppDevicesStatus> list = appDevicesStatusService.selectAppDevicesStatusListByDeviceIds(deviceIds);
        List<String> existIds = list.stream().map(AppDevicesStatus::getDeviceId).collect(Collectors.toList());
        List<String> notExistIds = deviceIds.stream().filter(item -> !existIds.contains(item)).collect(Collectors.toList());

        System.out.println("notExistIds");
        System.out.println(notExistIds);
//        //如果不存在设备的授权文件则创建一个三个月的
//        if (notExistIds.size() >= 0) {
//            AppLicenses bodyLicenses = License.createThreeMonthLicense(notExistIds);
//            appLicensesService.insertAppLicenses(bodyLicenses);
//        }
        List<AppLicenses> listLicense = appLicensesService.selectAppLicensesListByDeviceIds(deviceIds);
        if(listLicense.size()==0){
            return error("未找到设备对应授权",4007);
        }

        return success(listLicense);
    }


    /**
     * 状态修改
     */
    @ApiOperation("授权状态更新")
    @PreAuthorize("@ss.hasPermi('app:licenses:edit')")
    @Log(title = "授权管理", businessType = BusinessType.UPDATE)
    @PutMapping("/status")
    public AjaxResult changeStatus(@RequestBody LicensesUpdate appLicenses) {
        int rows = appLicensesService.updateBatchAppLicenseStatus(appLicenses);
        return rows > 0 ? AjaxResult.success() : AjaxResult.error("状态更新失败，请重试",4008);
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
     * @param license_id 文件名称
     * @return
     */
    @ApiOperation("授权文件获取")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "licenseId", value = "授权Id", dataType = "String", dataTypeClass = String.class),
    })
    @PostMapping("/download/{license_id}")
    public AjaxResult download(@PathVariable("license_id") String license_id, HttpServletResponse response) throws Exception {
        AppLicenses appLicenses = appLicensesService.selectAppLicensesByLicenseId(license_id);

        if (appLicenses == null) {
            return error("未找到设备对应授权",4007);
        }
        int[] intArray = License.getLicense(appLicenses.getFileName());
        System.out.println(appLicenses.getFileName());
        System.out.println(intArray);
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("license", intArray);
        return success(res);

    }
}
