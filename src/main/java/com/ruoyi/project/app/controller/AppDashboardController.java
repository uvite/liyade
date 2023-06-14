package com.ruoyi.project.app.controller;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.app.domain.AppDevice;
import com.ruoyi.project.app.service.IAppDeviceService;
import com.ruoyi.project.app.service.IAppProductService;
import com.ruoyi.project.app.service.IAppSupplierService;
import com.ruoyi.project.monitor.domain.SysOperLog;
import com.ruoyi.project.monitor.service.ISysOperLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 设备管理Controller
 *
 * @author ruoyi
 * @date 2023-04-13
 */
@RestController
@RequestMapping("/app/dashboard")
public class AppDashboardController extends BaseController {
    @Autowired
    private IAppDeviceService deviceService;
    @Autowired
    private IAppSupplierService supplierService;
    @Autowired
    private IAppProductService productService;
    @Autowired
    private ISysOperLogService operLogService;
    /**
     * 统计报表
     */

    @GetMapping("/analysis")
    public AjaxResult getAnalysis()  {

        AjaxResult ajax = AjaxResult.success();
        ajax.put("products", productService.selectAppProductCount());
        ajax.put("suppliers", supplierService.selectAppSupplierCount());
        ajax.put("deviceInStock", deviceService.inStockCount());
        ajax.put("deviceAuthorization", deviceService.AuthorizationCount());

        return ajax;
    }

    /**
     * 操作日志
     * @return
     */
    @GetMapping("/logs")
    public TableDataInfo list(SysOperLog operLog)
    {
        startPage();
        List<SysOperLog> list = operLogService.selectOperLogList(operLog);
        return getDataTable(list);
    }



}
