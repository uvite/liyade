package com.ruoyi.project.app.service;

import java.util.List;
import com.ruoyi.project.app.domain.AppPrivate;

/**
 * 秘钥Service接口
 * 
 * @author ruoyi
 * @date 2023-04-14
 */
public interface IAppPrivateService 
{
    /**
     * 查询秘钥
     * 
     * @param privateId 秘钥主键
     * @return 秘钥
     */
    public AppPrivate selectAppPrivateByPrivateId(Long privateId);

    /**
     * 查询秘钥列表
     * 
     * @param appPrivate 秘钥
     * @return 秘钥集合
     */
    public List<AppPrivate> selectAppPrivateList(AppPrivate appPrivate);

    /**
     * 新增秘钥
     * 
     * @param appPrivate 秘钥
     * @return 结果
     */
    public int insertAppPrivate(AppPrivate appPrivate);

    /**
     * 修改秘钥
     * 
     * @param appPrivate 秘钥
     * @return 结果
     */
    public int updateAppPrivate(AppPrivate appPrivate);

    /**
     * 批量删除秘钥
     * 
     * @param privateIds 需要删除的秘钥主键集合
     * @return 结果
     */
    public int deleteAppPrivateByPrivateIds(Long[] privateIds);

    /**
     * 删除秘钥信息
     * 
     * @param privateId 秘钥主键
     * @return 结果
     */
    public int deleteAppPrivateByPrivateId(Long privateId);
}
