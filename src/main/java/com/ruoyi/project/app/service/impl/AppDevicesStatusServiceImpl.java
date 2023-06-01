package com.ruoyi.project.app.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.app.mapper.AppDevicesStatusMapper;
import com.ruoyi.project.app.domain.AppDevicesStatus;
import com.ruoyi.project.app.service.IAppDevicesStatusService;

/**
 * 授权管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-31
 */
@Service
public class AppDevicesStatusServiceImpl implements IAppDevicesStatusService 
{
    @Autowired
    private AppDevicesStatusMapper appDevicesStatusMapper;

    /**
     * 查询授权管理
     * 
     * @param id 授权管理主键
     * @return 授权管理
     */
    @Override
    public AppDevicesStatus selectAppDevicesStatusById(Long id)
    {
        return appDevicesStatusMapper.selectAppDevicesStatusById(id);
    }

    /**
     * 查询授权管理列表
     * 
     * @param appDevicesStatus 授权管理
     * @return 授权管理
     */
    @Override
    public List<AppDevicesStatus> selectAppDevicesStatusList(AppDevicesStatus appDevicesStatus)
    {
        return appDevicesStatusMapper.selectAppDevicesStatusList(appDevicesStatus);
    }

    /**
     * 新增授权管理
     * 
     * @param appDevicesStatus 授权管理
     * @return 结果
     */
    @Override
    public int insertAppDevicesStatus(AppDevicesStatus appDevicesStatus)
    {
        return appDevicesStatusMapper.insertAppDevicesStatus(appDevicesStatus);
    }

    /**
     * 修改授权管理
     * 
     * @param appDevicesStatus 授权管理
     * @return 结果
     */
    @Override
    public int updateAppDevicesStatus(AppDevicesStatus appDevicesStatus)
    {
        return appDevicesStatusMapper.updateAppDevicesStatus(appDevicesStatus);
    }

    /**
     * 批量删除授权管理
     * 
     * @param ids 需要删除的授权管理主键
     * @return 结果
     */
    @Override
    public int deleteAppDevicesStatusByIds(Long[] ids)
    {
        return appDevicesStatusMapper.deleteAppDevicesStatusByIds(ids);
    }

    /**
     * 删除授权管理信息
     * 
     * @param id 授权管理主键
     * @return 结果
     */
    @Override
    public int deleteAppDevicesStatusById(Long id)
    {
        return appDevicesStatusMapper.deleteAppDevicesStatusById(id);
    }

    /**
     * 批量审核授权管理
     *
     * @param ids 需要删除的授权管理主键
     * @return 结果
     */
    @Override
    public int checkAppDevicesStatusByIds(Long[] ids)
    {
        return appDevicesStatusMapper.checkAppDevicesStatusByIds(ids);
    }

    @Override
    public int updateAppLicenseEnabled(AppDevicesStatus appDevicesStatus) {
        return appDevicesStatusMapper.updateAppDevicesStatus(appDevicesStatus);
    }

    @Override
    public List<AppDevicesStatus> selectAppDevicesStatusListByDeviceIds(List<String> deviceIds) {
        String[] array = deviceIds.toArray(new String[deviceIds.size()]);
        return appDevicesStatusMapper.selectAppDevicesStatusListByDeviceIds(array);
    }
}
