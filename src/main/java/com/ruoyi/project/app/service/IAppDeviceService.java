package com.ruoyi.project.app.service;

import java.util.List;

import com.ruoyi.project.app.controller.request.BodyCiphertexts;
import com.ruoyi.project.app.domain.AppDevice;
import com.ruoyi.project.app.domain.AppProduct;

/**
 * 参数配置Service接口
 * 
 * @author ruoyi
 * @date 2023-04-13
 */
public interface IAppDeviceService 
{
    /**
     * 查询参数配置
     *
     * @param id 参数配置主键
     * @return 参数配置
     */
    public AppDevice selectAppDeviceById(Long id);

    public AppDevice selectAppDeviceByDeviceId(String deviceId);

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
     * 更新授权状态
     * @param appDevice
     * @return
     */
    public int updateAppDeviceUsed(AppDevice appDevice);

    /**
     * 批量删除参数配置
     *
     * @param ids 需要删除的参数配置主键集合
     * @return 结果
     */
    public int deleteAppDeviceByIds(Long[] ids);

    /**
     * 删除参数配置信息
     *
     * @param id 参数配置主键
     * @return 结果
     */
    public int deleteAppDeviceById(Long id);

    public AppDevice checkDeviceId(BodyCiphertexts bodyCiphertexts,AppProduct appProduct);




    /**
     * 逻辑删除
     *
     * @param deviceId
     * @return
     */
    int logicDeleteById(Long deviceId);

    /**
     * 批量逻辑删除
     *
     * @param deviceIds
     * @return
     */
    int logicDeleteBatch(Long[] deviceIds);

    /**
     * 入库数量
     * @return
     */
    public int inStockCount();

    /**
     * 授权数量
     * @return
     */
    public int AuthorizationCount();


}
