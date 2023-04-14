package com.ruoyi.project.app.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.app.mapper.AppSupplierMapper;
import com.ruoyi.project.app.domain.AppSupplier;
import com.ruoyi.project.app.service.IAppSupplierService;

/**
 * 供应商管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-13
 */
@Service
public class AppSupplierServiceImpl implements IAppSupplierService 
{
    @Autowired
    private AppSupplierMapper appSupplierMapper;

    @Override
    public List<AppSupplier> selectAppSupplierAll() {
        return appSupplierMapper.selectAppSupplierAll();
    }

    /**
     * 查询供应商管理
     * 
     * @param supplierId 供应商管理主键
     * @return 供应商管理
     */
    @Override
    public AppSupplier selectAppSupplierBySupplierId(Long supplierId)
    {
        return appSupplierMapper.selectAppSupplierBySupplierId(supplierId);
    }

    /**
     * 查询供应商管理列表
     * 
     * @param appSupplier 供应商管理
     * @return 供应商管理
     */
    @Override
    public List<AppSupplier> selectAppSupplierList(AppSupplier appSupplier)
    {
        return appSupplierMapper.selectAppSupplierList(appSupplier);
    }

    /**
     * 新增供应商管理
     * 
     * @param appSupplier 供应商管理
     * @return 结果
     */
    @Override
    public int insertAppSupplier(AppSupplier appSupplier)
    {

        appSupplier.setSupplierSign(IdUtils.fastSimpleUUID());
        appSupplier.setCreateTime(DateUtils.getNowDate());
        return appSupplierMapper.insertAppSupplier(appSupplier);
    }

    /**
     * 修改供应商管理
     * 
     * @param appSupplier 供应商管理
     * @return 结果
     */
    @Override
    public int updateAppSupplier(AppSupplier appSupplier)
    {
        appSupplier.setUpdateTime(DateUtils.getNowDate());
        return appSupplierMapper.updateAppSupplier(appSupplier);
    }

    /**
     * 批量删除供应商管理
     * 
     * @param supplierIds 需要删除的供应商管理主键
     * @return 结果
     */
    @Override
    public int deleteAppSupplierBySupplierIds(Long[] supplierIds)
    {
        return appSupplierMapper.deleteAppSupplierBySupplierIds(supplierIds);
    }

    /**
     * 删除供应商管理信息
     * 
     * @param supplierId 供应商管理主键
     * @return 结果
     */
    @Override
    public int deleteAppSupplierBySupplierId(Long supplierId)
    {
        return appSupplierMapper.deleteAppSupplierBySupplierId(supplierId);
    }
}
