package com.ruoyi.project.app.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.project.app.domain.AppDevicesStatus;
import com.ruoyi.project.app.service.IAppDevicesStatusService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 授权管理Controller
 * 
 * @author ruoyi
 * @date 2023-05-31
 */
@RestController
@RequestMapping("/app/status")
public class AppDevicesStatusController extends BaseController
{
    @Autowired
    private IAppDevicesStatusService appDevicesStatusService;

    /**
     * 查询授权管理列表
     */
    @PreAuthorize("@ss.hasPermi('app:status:list')")
    @GetMapping("/list")
    public TableDataInfo list(AppDevicesStatus appDevicesStatus)
    {
        startPage();
        List<AppDevicesStatus> list = appDevicesStatusService.selectAppDevicesStatusList(appDevicesStatus);
        return getDataTable(list);
    }

    /**
     * 导出授权管理列表
     */
    @PreAuthorize("@ss.hasPermi('app:status:export')")
    @Log(title = "授权管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AppDevicesStatus appDevicesStatus)
    {
        List<AppDevicesStatus> list = appDevicesStatusService.selectAppDevicesStatusList(appDevicesStatus);
        ExcelUtil<AppDevicesStatus> util = new ExcelUtil<AppDevicesStatus>(AppDevicesStatus.class);
        util.exportExcel(response, list, "授权管理数据");
    }

    /**
     * 获取授权管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('app:status:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(appDevicesStatusService.selectAppDevicesStatusById(id));
    }

    /**
     * 新增授权管理
     */
    @PreAuthorize("@ss.hasPermi('app:status:add')")
    @Log(title = "授权管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AppDevicesStatus appDevicesStatus)
    {
        return toAjax(appDevicesStatusService.insertAppDevicesStatus(appDevicesStatus));
    }

    /**
     * 修改授权管理
     */
    @PreAuthorize("@ss.hasPermi('app:status:edit')")
    @Log(title = "授权管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AppDevicesStatus appDevicesStatus)
    {
        return toAjax(appDevicesStatusService.updateAppDevicesStatus(appDevicesStatus));
    }

    /**
     * 删除授权管理
     */
    @PreAuthorize("@ss.hasPermi('app:status:remove')")
    @Log(title = "授权管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(appDevicesStatusService.deleteAppDevicesStatusByIds(ids));
    }


    @PreAuthorize("@ss.hasPermi('app:licenses:edit')")
    @Log(title = "授权管理", businessType = BusinessType.UPDATE)
    @PutMapping("/changeEnabled")
    public AjaxResult changeEnabled(  @RequestBody AppDevicesStatus appDevicesStatus) {

        return toAjax(appDevicesStatusService.updateAppLicenseEnabled(appDevicesStatus));
    }


    /**
     * 批量审核授权管理
     */
    @PreAuthorize("@ss.hasPermi('app:status:batchedit')")
    @Log(title = "审核授权管理", businessType = BusinessType.DELETE)
	@PostMapping("/batchcheck/{ids}")
    public AjaxResult batchCheck(@PathVariable Long[] ids)
    {
        return toAjax(appDevicesStatusService.checkAppDevicesStatusByIds(ids));
    }
}
