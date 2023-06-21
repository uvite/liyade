package com.ruoyi.project.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.app.domain.Product;
import com.ruoyi.project.app.service.IAppSupplierService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
import com.ruoyi.project.app.domain.AppProduct;
import com.ruoyi.project.app.service.IAppProductService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 产品管理Controller
 * 
 * @author ruoyi
 * @date 2023-04-13
 */
@RestController
@RequestMapping("/app/product")
public class AppProductController extends BaseController
{
    @Autowired
    private IAppProductService appProductService;
    @Autowired
    private IAppSupplierService supplierService;

    /**
     * 查询产品管理列表
     */
    @PreAuthorize("@ss.hasPermi('app:product:list')")
    @GetMapping("/list")
    public TableDataInfo list(AppProduct appProduct)
    {
        startPage();
        List<AppProduct> list = appProductService.selectAppProductList(appProduct);
        return getDataTable(list);
    }

    /**
     * 查询产品管理列表
     */
    @PreAuthorize("@ss.hasPermi('app:product:list')")
    @GetMapping("/getlist")
    public AjaxResult getlist(AppProduct appProduct)
    {

        List<Product> list = appProductService.getAppProductList(appProduct);

        Map<String, List> res = new HashMap<String, List>();
        res.put("products", list);
        return success(res);
    }

    /**
     * 导出产品管理列表
     */
    @PreAuthorize("@ss.hasPermi('app:product:export')")
    @Log(title = "产品管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AppProduct appProduct)
    {
        List<AppProduct> list = appProductService.selectAppProductList(appProduct);
        ExcelUtil<AppProduct> util = new ExcelUtil<AppProduct>(AppProduct.class);
        util.exportExcel(response, list, "产品管理数据");
    }

    /**
     * 获取产品管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('app:product:query')")
    @GetMapping(value = {"/", "/{productId}"})
    public AjaxResult getInfo(@PathVariable(value = "productId", required = false) Long productId) {

        AjaxResult ajax = AjaxResult.success();
        ajax.put("suppliers", supplierService.selectAppSupplierAll());
        if (StringUtils.isNotNull(productId)) {
            AppProduct appProduct = appProductService.selectAppProductByProductId(productId);
            ajax.put(AjaxResult.DATA_TAG, appProduct);
            ajax.put("suppliers", supplierService.selectAppSupplierAll());
        }
        return ajax;
    }

    /**
     * 新增产品管理
     */
    @PreAuthorize("@ss.hasPermi('app:product:add')")
    @Log(title = "产品管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody AppProduct appProduct)
    {
        if (!appProductService.checkProductUnique(appProduct))
        {
            return error("新增产品失败，产品名称或产品编号已存在");
        }
        return toAjax(appProductService.insertAppProduct(appProduct));
    }

    /**
     * 修改产品管理
     */
    @PreAuthorize("@ss.hasPermi('app:product:edit')")
    @Log(title = "产品管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AppProduct appProduct)
    {
        return toAjax(appProductService.updateAppProduct(appProduct));
    }

    /**
     * 删除产品管理
     */
    @PreAuthorize("@ss.hasPermi('app:product:remove')")
    @Log(title = "产品管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{productIds}")
    public AjaxResult remove(@PathVariable Long[] productIds)
    {
        return toAjax(appProductService.logicDeleteBatch(productIds));
    }
    /**
     * 状态修改
     */
    @PreAuthorize("@ss.hasPermi('app:product:edit')")
    @Log(title = "产品管理", businessType = BusinessType.UPDATE)
    @PutMapping("/changeStatus")
    public AjaxResult changeStatus(@RequestBody AppProduct appProduct)
    {

        return toAjax(appProductService.updateProductStatus(appProduct));
    }
}
