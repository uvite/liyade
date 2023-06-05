package com.ruoyi.project.app.mapper;

import java.util.List;
import com.ruoyi.project.app.domain.AppSupplier;

/**
 * 供应商管理Mapper接口
 * 
 * @author ruoyi
 * @date 2023-04-13
 */
public interface AppSupplierMapper 
{
    /**
     * 统计供应商
     *
     * @return 供应商
     */
    public int selectAppSupplierCount();

    /**
     * 查询供应商管理
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
     * 查询供应商管理
     *
     * @param supplierShortName 供应商管理主键
     * @return 供应商管理
     */
    public AppSupplier selectAppSupplierBySupplierShortName(String supplierShortName);

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
     * 删除供应商管理
     * 
     * @param supplierId 供应商管理主键
     * @return 结果
     */
    public int deleteAppSupplierBySupplierId(Long supplierId);

    /**
     * 批量删除供应商管理
     * 
     * @param supplierIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAppSupplierBySupplierIds(Long[] supplierIds);
}
