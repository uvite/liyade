package com.ruoyi.project.app.service;

import java.util.List;
import com.ruoyi.project.app.domain.AppLicenses;
import com.ruoyi.project.app.domain.AppSupplier;

/**
 * 授权管理Service接口
 * 
 * @author ruoyi
 * @date 2023-05-20
 */
public interface IAppLicensesService 
{
    /**
     * 查询授权管理
     * 
     * @param licenseId 授权管理主键
     * @return 授权管理
     */
    public AppLicenses selectAppLicensesByLicenseId(Long licenseId);

    /**
     * 查询授权管理列表
     * 
     * @param appLicenses 授权管理
     * @return 授权管理集合
     */
    public List<AppLicenses> selectAppLicensesList(AppLicenses appLicenses);

    /**
     * 查询授权管理列表
     *
     * @param licenseId 授权管理
     * @return 授权管理集合
     */
    public List<AppLicenses> selectAppLicensesListByDeviceId(String licenseId);

    /**
     * 新增授权管理
     * 
     * @param appLicenses 授权管理
     * @return 结果
     */
    public int insertAppLicenses(AppLicenses appLicenses);

    /**
     * 修改授权管理
     * 
     * @param appLicenses 授权管理
     * @return 结果
     */
    public int updateAppLicenses(AppLicenses appLicenses);

    /**
     * 批量删除授权管理
     * 
     * @param licenseIds 需要删除的授权管理主键集合
     * @return 结果
     */
    public int deleteAppLicensesByLicenseIds(Long[] licenseIds);

    /**
     * 删除授权管理信息
     * 
     * @param licenseId 授权管理主键
     * @return 结果
     */
    public int deleteAppLicensesByLicenseId(Long licenseId);



    /**
     * 修改供应商状态
     * appSupplier
     * @return 结果
     */
    public int updateAppLicenseStatus(AppLicenses appLicenses);
}
