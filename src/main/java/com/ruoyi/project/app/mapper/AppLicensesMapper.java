package com.ruoyi.project.app.mapper;

import java.util.List;
import com.ruoyi.project.app.domain.AppLicenses;

/**
 * 授权管理Mapper接口
 *
 * @author ruoyi
 * @date 2023-05-21
 */
public interface AppLicensesMapper
{
    /**
     * 查询授权管理
     *
     * @param id 授权管理主键
     * @return 授权管理
     */
    public AppLicenses selectAppLicensesById(Long id);

    public List<AppLicenses> selectAppLicensesByLicenseId(String LicenseId);

    public List<AppLicenses>  selectAppLicensesListByDeviceIds(String[] DeviceId);


    /**
     * 查询授权管理列表
     *
     * @param appLicenses 授权管理
     * @return 授权管理集合
     */
    public List<AppLicenses> selectAppLicensesList(AppLicenses appLicenses);

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

    public int updateAppLicensesStatus(AppLicenses appLicenses);

    //审核
    public int updateAppLicensesEnabled(AppLicenses appLicenses);

    /**
     * 删除授权管理
     *
     * @param id 授权管理主键
     * @return 结果
     */
    public int deleteAppLicensesById(Long id);

    /**
     * 批量删除授权管理
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAppLicensesByIds(Long[] ids);
}
