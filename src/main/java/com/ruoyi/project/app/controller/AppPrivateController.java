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
import com.ruoyi.project.app.domain.AppPrivate;
import com.ruoyi.project.app.service.IAppPrivateService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 秘钥Controller
 * 
 * @author ruoyi
 * @date 2023-04-14
 */
@RestController
@RequestMapping("/app/private")
public class AppPrivateController extends BaseController
{
    @Autowired
    private IAppPrivateService appPrivateService;

    /**
     * 查询秘钥列表
     */
    @PreAuthorize("@ss.hasPermi('app:private:list')")
    @GetMapping("/list")
    public TableDataInfo list(AppPrivate appPrivate)
    {
        startPage();
        List<AppPrivate> list = appPrivateService.selectAppPrivateList(appPrivate);
        return getDataTable(list);
    }

    /**
     * 导出秘钥列表
     */
    @PreAuthorize("@ss.hasPermi('app:private:export')")
    @Log(title = "秘钥", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AppPrivate appPrivate)
    {
        List<AppPrivate> list = appPrivateService.selectAppPrivateList(appPrivate);
        ExcelUtil<AppPrivate> util = new ExcelUtil<AppPrivate>(AppPrivate.class);
        util.exportExcel(response, list, "秘钥数据");
    }

    /**
     * 获取秘钥详细信息
     */
    @PreAuthorize("@ss.hasPermi('app:private:query')")
    @GetMapping(value = "/{privateId}")
    public AjaxResult getInfo(@PathVariable("privateId") Long privateId)
    {
        return success(appPrivateService.selectAppPrivateByPrivateId(privateId));
    }

    /**
     * 新增秘钥
     */
    @PreAuthorize("@ss.hasPermi('app:private:add')")
    @Log(title = "秘钥", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AppPrivate appPrivate)
    {
        return toAjax(appPrivateService.insertAppPrivate(appPrivate));
    }

    /**
     * 修改秘钥
     */
    @PreAuthorize("@ss.hasPermi('app:private:edit')")
    @Log(title = "秘钥", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AppPrivate appPrivate)
    {
        return toAjax(appPrivateService.updateAppPrivate(appPrivate));
    }

    /**
     * 删除秘钥
     */
    @PreAuthorize("@ss.hasPermi('app:private:remove')")
    @Log(title = "秘钥", businessType = BusinessType.DELETE)
	@DeleteMapping("/{privateIds}")
    public AjaxResult remove(@PathVariable Long[] privateIds)
    {
        return toAjax(appPrivateService.deleteAppPrivateByPrivateIds(privateIds));
    }
}
