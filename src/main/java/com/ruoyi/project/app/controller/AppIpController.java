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
import com.ruoyi.project.app.domain.AppIp;
import com.ruoyi.project.app.service.IAppIpService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * ip白名单Controller
 * 
 * @author ruoyi
 * @date 2023-04-21
 */
@RestController
@RequestMapping("/app/ip")
public class AppIpController extends BaseController
{
    @Autowired
    private IAppIpService appIpService;

    /**
     * 查询ip白名单列表
     */
    @PreAuthorize("@ss.hasPermi('app:ip:list')")
    @GetMapping("/list")
    public TableDataInfo list(AppIp appIp)
    {
        startPage();
        List<AppIp> list = appIpService.selectAppIpList(appIp);
        return getDataTable(list);
    }

    /**
     * 导出ip白名单列表
     */
    @PreAuthorize("@ss.hasPermi('app:ip:export')")
    @Log(title = "ip白名单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AppIp appIp)
    {
        List<AppIp> list = appIpService.selectAppIpList(appIp);
        ExcelUtil<AppIp> util = new ExcelUtil<AppIp>(AppIp.class);
        util.exportExcel(response, list, "ip白名单数据");
    }

    /**
     * 获取ip白名单详细信息
     */
    @PreAuthorize("@ss.hasPermi('app:ip:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(appIpService.selectAppIpById(id));
    }

    /**
     * 新增ip白名单
     */
    @PreAuthorize("@ss.hasPermi('app:ip:add')")
    @Log(title = "ip白名单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AppIp appIp)
    {
        return toAjax(appIpService.insertAppIp(appIp));
    }

    /**
     * 修改ip白名单
     */
    @PreAuthorize("@ss.hasPermi('app:ip:edit')")
    @Log(title = "ip白名单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AppIp appIp)
    {
        return toAjax(appIpService.updateAppIp(appIp));
    }

    /**
     * 删除ip白名单
     */
    @PreAuthorize("@ss.hasPermi('app:ip:remove')")
    @Log(title = "ip白名单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(appIpService.deleteAppIpByIds(ids));
    }
}
