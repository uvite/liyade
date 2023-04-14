package com.ruoyi.project.app.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.app.domain.AppProduct;
import com.ruoyi.project.app.service.IAppSupplierService;
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
import com.ruoyi.project.app.domain.AppDevice;
import com.ruoyi.project.app.service.IAppDeviceService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 参数配置Controller
 * 
 * @author ruoyi
 * @date 2023-04-13
 */
@RestController
@RequestMapping("/app/device")
public class AppDeviceController extends BaseController
{
    @Autowired
    private IAppDeviceService appDeviceService;
    @Autowired
    private IAppSupplierService supplierService;

    /**
     * 查询参数配置列表
     */
    @PreAuthorize("@ss.hasPermi('app:device:list')")
    @GetMapping("/list")
    public TableDataInfo list(AppDevice appDevice)
    {
        startPage();
        List<AppDevice> list = appDeviceService.selectAppDeviceList(appDevice);
        return getDataTable(list);
    }

    /**
     * 导出参数配置列表
     */
    @PreAuthorize("@ss.hasPermi('app:device:export')")
    @Log(title = "参数配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AppDevice appDevice)
    {
        List<AppDevice> list = appDeviceService.selectAppDeviceList(appDevice);
        ExcelUtil<AppDevice> util = new ExcelUtil<AppDevice>(AppDevice.class);
        util.exportExcel(response, list, "参数配置数据");
    }

    /**
     * 获取参数配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('app:device:query')")
    @GetMapping(value = {"/", "/{deviceId}"})
    public AjaxResult getInfo(@PathVariable(value = "deviceId", required = false) Long deviceId) {

        AjaxResult ajax = AjaxResult.success();
        ajax.put("suppliers", supplierService.selectAppSupplierAll());
        if (StringUtils.isNotNull(deviceId)) {
            AppDevice appDevice = appDeviceService.selectAppDeviceByDeviceId(deviceId);
            ajax.put(AjaxResult.DATA_TAG, appDevice);
            ajax.put("suppliers", supplierService.selectAppSupplierAll());
        }
        return ajax;
    }

    /**
     * 新增参数配置
     */
    @PreAuthorize("@ss.hasPermi('app:device:add')")
    @Log(title = "参数配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AppDevice appDevice)
    {
        return toAjax(appDeviceService.insertAppDevice(appDevice));
    }

    /**
     * 修改参数配置
     */
    @PreAuthorize("@ss.hasPermi('app:device:edit')")
    @Log(title = "参数配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AppDevice appDevice)
    {
        return toAjax(appDeviceService.updateAppDevice(appDevice));
    }

    /**
     * 删除参数配置
     */
    @PreAuthorize("@ss.hasPermi('app:device:remove')")
    @Log(title = "参数配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{deviceIds}")
    public AjaxResult remove(@PathVariable Long[] deviceIds)
    {
        return toAjax(appDeviceService.deleteAppDeviceByDeviceIds(deviceIds));
    }
}
