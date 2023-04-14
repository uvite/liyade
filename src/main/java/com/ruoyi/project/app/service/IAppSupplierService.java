package com.ruoyi.project.app.service;

import java.util.List;
import com.ruoyi.project.app.domain.AppSupplier;

/**
 * 供应商管理Service接口
 * 
 * @author ruoyi
 * @date 2023-04-13
 */
public interface IAppSupplierService 
{

    /**
     * 全部供应商管理
     *
     *
     * @return 供应商管理
     */
    public List<AppSupplier> selectAppSupplierAll();

    /**
     * 查询供应商管理
     * 
     * @param supplierId 供应商管理主键
     * @return 供应商管理
     */
    public AppSupplier selectAppSupplierBySupplierId(Long supplierId);

    /**
     * 查询供应商管理列表
     * 
     * @param appSupplier 供应商管理
     * @return 供应商管理集合
     */
    public List<AppSupplier> selectAppSupplierList(AppSupplier appSupplier);

    /**
     * 新增供应商管理
     * 
     * @param appSupplier 供应商管理
     * @return 结果
     */
    public int insertAppSupplier(AppSupplier appSupplier);

    /**
     * 修改供应商管理
     * 
     * @param appSupplier 供应商管理
     * @return 结果
     */
    public int updateAppSupplier(AppSupplier appSupplier);

    /**
     * 批量删除供应商管理
     * 
     * @param supplierIds 需要删除的供应商管理主键集合
     * @return 结果
     */
    public int deleteAppSupplierBySupplierIds(Long[] supplierIds);

    /**
     * 删除供应商管理信息
     * 
     * @param supplierId 供应商管理主键
     * @return 结果
     */
    public int deleteAppSupplierBySupplierId(Long supplierId);
}
