package com.ruoyi.project.app.service;

import java.util.List;
import com.ruoyi.project.app.domain.AppIp;
import com.ruoyi.project.app.domain.AppSupplier;

/**
 * ip白名单Service接口
 * 
 * @author ruoyi
 * @date 2023-04-21
 */
public interface IAppIpService 
{
    /**
     * 查询ip白名单
     * 
     * @param id ip白名单主键
     * @return ip白名单
     */
    public AppIp selectAppIpById(Long id);

    /**
     * 查询ip白名单列表
     * 
     * @param appIp ip白名单
     * @return ip白名单集合
     */
    public List<AppIp> selectAppIpList(AppIp appIp);

    /**
     * 新增ip白名单
     * 
     * @param appIp ip白名单
     * @return 结果
     */
    public int insertAppIp(AppIp appIp);

    /**
     * 修改ip白名单
     * 
     * @param appIp ip白名单
     * @return 结果
     */
    public int updateAppIp(AppIp appIp);

    /**
     * 批量删除ip白名单
     * 
     * @param ids 需要删除的ip白名单主键集合
     * @return 结果
     */
    public int deleteAppIpByIds(Long[] ids);

    /**
     * 删除ip白名单信息
     * 
     * @param id ip白名单主键
     * @return 结果
     */
    public int deleteAppIpById(Long id);
    /**
     * 校验ip是否唯一
     *
     * @param appIp 供应商信息
     * @return 结果
     */
    public boolean checkIpUnique(AppIp appIp);

    /**
     * 根据ip获取白名单信息
     *
     * @param ip 参数键名
     * @return 参数键值
     */
    public AppIp selectAppIpByIp(String ip);

}
