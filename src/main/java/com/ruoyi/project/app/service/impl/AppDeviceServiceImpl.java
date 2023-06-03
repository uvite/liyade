package com.ruoyi.project.app.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.app.mapper.AppDeviceMapper;
import com.ruoyi.project.app.domain.AppDevice;
import com.ruoyi.project.app.service.IAppDeviceService;

/**
 * 参数配置Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-13
 */
@Service
public class AppDeviceServiceImpl implements IAppDeviceService 
{
    @Autowired
    private AppDeviceMapper appDeviceMapper;

    /**
     * 查询参数配置
     * 
     * @param deviceId 参数配置主键
     * @return 参数配置
     */
    @Override
    public AppDevice selectAppDeviceByDeviceId(Long deviceId)
    {
        return appDeviceMapper.selectAppDeviceByDeviceId(deviceId);
    }

    @Override
    public AppDevice selectAppDeviceByDeviceCode(String deviceCode) {
        return appDeviceMapper.selectAppDeviceByDeviceCode(deviceCode);
    }

    @Override
    public AppDevice checkDeviceCode(String deviceCode) {
        AppDevice appDevice = appDeviceMapper.selectAppDeviceByDeviceCode(deviceCode);
        if(appDevice==null){
            AppDevice device = new AppDevice();
            device.setDeviceCode(deviceCode);
            appDeviceMapper.insertAppDevice(device);
        }
        return appDevice;
    }

    /**
     * 查询参数配置列表
     * 
     * @param appDevice 参数配置
     * @return 参数配置
     */
    @Override
    public List<AppDevice> selectAppDeviceList(AppDevice appDevice)
    {
        return appDeviceMapper.selectAppDeviceList(appDevice);
    }

    /**
     * 新增参数配置
     * 
     * @param appDevice 参数配置
     * @return 结果
     */
    @Override
    public int insertAppDevice(AppDevice appDevice)
    {
        appDevice.setCreateTime(DateUtils.getNowDate());
        return appDeviceMapper.insertAppDevice(appDevice);
    }

    /**
     * 修改参数配置
     * 
     * @param appDevice 参数配置
     * @return 结果
     */
    @Override
    public int updateAppDevice(AppDevice appDevice)
    {
        appDevice.setUpdateTime(DateUtils.getNowDate());
        return appDeviceMapper.updateAppDevice(appDevice);
    }

    /**
     * 批量删除参数配置
     * 
     * @param deviceIds 需要删除的参数配置主键
     * @return 结果
     */
    @Override
    public int deleteAppDeviceByDeviceIds(Long[] deviceIds)
    {
        return appDeviceMapper.deleteAppDeviceByDeviceIds(deviceIds);
    }

    /**
     * 删除参数配置信息
     * 
     * @param deviceId 参数配置主键
     * @return 结果
     */
    @Override
    public int deleteAppDeviceByDeviceId(Long deviceId)
    {
        return appDeviceMapper.deleteAppDeviceByDeviceId(deviceId);
    }

    @Override
    public int logicDeleteById(Long deviceId) {
        return appDeviceMapper.logicDeleteById(deviceId);
    }

    @Override
    public int logicDeleteBatch(Long[] deviceIds) {
        return appDeviceMapper.logicDeleteBatch(deviceIds);

    }

    @Override
    public int inStockCount() {
        return appDeviceMapper.selectInStockCount();

    }

    @Override
    public int AuthorizationCount() {
        return appDeviceMapper.selectDeviceStatusCount();

    }
}
