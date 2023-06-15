package com.ruoyi.project.app.mapper;

import java.util.List;
import com.ruoyi.project.app.domain.AppLicenses;
import com.ruoyi.project.app.domain.AppDevicesStatus;

/**
 * 授权管理Mapper接口
 * 
 * @author ruoyi
 * @date 2023-05-31
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

    /**
     * 查询授权管理
     * @param md5
     * @return 授权管理
     */
    public AppLicenses getAppLicensesByLicenseMd5(String md5);

    /**
     * 查询授权管理
     *
     * @param license_id 授权管理主键
     * @return 授权管理
     */
    public AppLicenses getAppLicensesByLicenseId(String license_id);

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

    /**
     * 批量删除授权管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAppDevicesStatusByIds(Long[] ids);
    
    /**
     * 批量新增授权管理
     * 
     * @param appDevicesStatusList 授权管理列表
     * @return 结果
     */
    public int batchAppDevicesStatus(List<AppDevicesStatus> appDevicesStatusList);
    

    /**
     * 通过授权管理主键删除授权管理信息
     * 
     * @param id 授权管理ID
     * @return 结果
     */
    public int deleteAppDevicesStatusById(Long id);


    /**
     * 查询授权管理列表
     *
     * @param deviceIds 授权管理
     * @return 授权管理集合
     */
    public List<AppLicenses> selectAppLicensesListByDeviceIds(String[] deviceIds);

    public  AppLicenses  selectAppLicensesByLicenseId(String LicenseId);

    public int updateAppLicensesStatus(AppLicenses appLicenses);

    //审核
    public int updateAppLicensesEnabled(AppLicenses appLicenses);

    /**
     * 批量删除授权管理
     *
     * @param id 需要删除的数据
     * @return 结果
     */
    public int deleteAppDevicesStatusByLicenseId(Long id);


}
