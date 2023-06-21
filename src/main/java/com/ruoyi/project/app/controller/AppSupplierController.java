package com.ruoyi.project.app.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.project.system.domain.SysRole;
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
import com.ruoyi.project.app.domain.AppSupplier;
import com.ruoyi.project.app.service.IAppSupplierService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 供应商管理Controller
 *
 * @author ruoyi
 * @date 2023-04-13
 */
@RestController
@RequestMapping("/app/supplier")
public class AppSupplierController extends BaseController {
    @Autowired
    private IAppSupplierService appSupplierService;

    /**
     * 查询供应商管理列表
     */
    @PreAuthorize("@ss.hasPermi('app:supplier:list')")
    @GetMapping("/list")
    public TableDataInfo list(AppSupplier appSupplier) {
        startPage();
        List<AppSupplier> list = appSupplierService.selectAppSupplierList(appSupplier);
        return getDataTable(list);
    }

    /**
     * 导出供应商管理列表
     */
    @PreAuthorize("@ss.hasPermi('app:supplier:export')")
    @Log(title = "供应商管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AppSupplier appSupplier) {
        List<AppSupplier> list = appSupplierService.selectAppSupplierList(appSupplier);
        ExcelUtil<AppSupplier> util = new ExcelUtil<AppSupplier>(AppSupplier.class);
        util.exportExcel(response, list, "供应商管理数据");
    }

    /**
     * 获取供应商管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('app:supplier:query')")
    @GetMapping(value = "/{supplierId}")
    public AjaxResult getInfo(@PathVariable("supplierId") Long supplierId) {
        return success(appSupplierService.selectAppSupplierBySupplierId(supplierId));
    }

    /**
     * 新增供应商管理
     */
    @PreAuthorize("@ss.hasPermi('app:supplier:add')")
    @Log(title = "供应商管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AppSupplier appSupplier) {
        if (!appSupplierService.checkSupplierNameUnique(appSupplier)) {
            return error("新增供应商'" + appSupplier.getSupplierName() + "'失败，供应商已存在");
        }
        return toAjax(appSupplierService.insertAppSupplier(appSupplier));
    }

    /**
     * 修改供应商管理
     */
    @PreAuthorize("@ss.hasPermi('app:supplier:edit')")
    @Log(title = "供应商管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AppSupplier appSupplier) {
        if (!appSupplierService.checkSupplierNameUnique(appSupplier)) {
            return error("修改供应商'" + appSupplier.getSupplierName() + "'失败，供应商已存在");
        }
        return toAjax(appSupplierService.updateAppSupplier(appSupplier));
    }

    /**
     * 删除供应商管理
     */
    @PreAuthorize("@ss.hasPermi('app:supplier:remove')")
    @Log(title = "供应商管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{supplierIds}")
    public AjaxResult remove(@PathVariable Long[] supplierIds) {
        return toAjax(appSupplierService.deleteAppSupplierBySupplierIds(supplierIds));
    }

    /**
     * 状态修改
     */
    @PreAuthorize("@ss.hasPermi('app:supplier:edit')")
    @Log(title = "供应商管理", businessType = BusinessType.UPDATE)
    @PutMapping("/changeStatus")
    public AjaxResult changeStatus(@RequestBody AppSupplier appSupplier) {

        return toAjax(appSupplierService.updateSupplierStatus(appSupplier));
    }
}
