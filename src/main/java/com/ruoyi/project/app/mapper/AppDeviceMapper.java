package com.ruoyi.project.app.mapper;

import java.util.List;
import com.ruoyi.project.app.domain.AppDevice;

/**
 * 参数配置Mapper接口
 * 
 * @author ruoyi
 * @date 2023-04-13
 */
public interface AppDeviceMapper 
{
    /**
     * 查询参数配置
     * 
     * @param deviceId 参数配置主键
     * @return 参数配置
     */
    public AppDevice selectAppDeviceByDeviceId(Long deviceId);

    /**
     * 查询参数配置列表
     * 
     * @param appDevice 参数配置
     * @return 参数配置集合
     */
    public List<AppDevice> selectAppDeviceList(AppDevice appDevice);

    /**
     * 新增参数配置
     * 
     * @param appDevice 参数配置
     * @return 结果
     */
    public int insertAppDevice(AppDevice appDevice);

    /**
     * 修改参数配置
     * 
     * @param appDevice 参数配置
     * @return 结果
     */
    public int updateAppDevice(AppDevice appDevice);

    /**
     * 删除参数配置
     * 
     * @param deviceId 参数配置主键
     * @return 结果
     */
    public int deleteAppDeviceByDeviceId(Long deviceId);

    /**
     * 批量删除参数配置
     * 
     * @param deviceIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAppDeviceByDeviceIds(Long[] deviceIds);

    /**
     * 逻辑删除管理
     *
     * @param deviceId 管理主键
     * @return 结果
     */
    public int logicDeleteById(Long deviceId);

    /**
     * 逻辑批量删除管理
     *
     * @param deviceIds 需要删除的数据主键集合
     * @return 结果
     */
    public int logicDeleteBatch(Long[] deviceIds);

    /**
     * 已入库设备数量
     * @return
     */
    public int selectInStockCount();
    /**
     * 已授权设备数量
     * @return
     */
    public int selectDeviceStatusCount();

}
