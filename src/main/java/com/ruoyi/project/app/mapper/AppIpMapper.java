package com.ruoyi.project.app.mapper;

import java.util.List;
import com.ruoyi.project.app.domain.AppIp;

/**
 * ip白名单Mapper接口
 * 
 * @author ruoyi
 * @date 2023-04-21
 */
public interface AppIpMapper 
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
     * 删除ip白名单
     * 
     * @param id ip白名单主键
     * @return 结果
     */
    public int deleteAppIpById(Long id);

    /**
     * 批量删除ip白名单
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAppIpByIds(Long[] ids);

    /**
     * 查询ip白名单
     *
     * @param ip ip白名单主键
     * @return bool
     */
    public AppIp selectAppIpByIp(String ip);
}
