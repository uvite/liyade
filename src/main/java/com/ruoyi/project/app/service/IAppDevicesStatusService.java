package com.ruoyi.project.app.service;

import java.util.List;
import com.ruoyi.project.app.domain.AppDevicesStatus;
import com.ruoyi.project.app.domain.AppLicenses;

/**
 * 授权管理Service接口
 * 
 * @author ruoyi
 * @date 2023-05-31
 */
public interface IAppDevicesStatusService 
{
    /**
     * 查询授权管理
     * 
     * @param id 授权管理主键
     * @return 授权管理
     */
    public AppDevicesStatus selectAppDevicesStatusById(Long id);

    /**
     * 查询授权管理列表
     * 
     * @param appDevicesStatus 授权管理
     * @return 授权管理集合
     */
    public List<AppDevicesStatus> selectAppDevicesStatusList(AppDevicesStatus appDevicesStatus);

    /**
     * 新增授权管理
     * 
     * @param appDevicesStatus 授权管理
     * @return 结果
     */
    public int insertAppDevicesStatus(AppDevicesStatus appDevicesStatus);

    /**
     * 修改授权管理
     * 
     * @param appDevicesStatus 授权管理
     * @return 结果
     */
    public int updateAppDevicesStatus(AppDevicesStatus appDevicesStatus);

    /**
     * 批量删除授权管理
     * 
     * @param ids 需要删除的授权管理主键集合
     * @return 结果
     */
    public int deleteAppDevicesStatusByIds(Long[] ids);

    /**
     * 删除授权管理信息
     * 
     * @param id 授权管理主键
     * @return 结果
     */
    public int deleteAppDevicesStatusById(Long id);

    /**
     * 查询授权管理列表
     *
     * @param deviceIds 授权管理
     * @return 授权管理集合
     */
    public List<AppDevicesStatus> selectAppDevicesStatusListByDeviceIds(List<String>  deviceIds);

    /**
     * 审核授权管理信息
     *
     * @param ids 授权管理主键
     * @return 结果
     */
    public int checkAppDevicesStatusByIds(Long[] ids);


    /**
     * 修改授权管理
     *
     * @param appDevicesStatus 授权管理
     * @return 结果
     */
    public int updateAppLicenseEnabled(AppDevicesStatus appDevicesStatus);

}
