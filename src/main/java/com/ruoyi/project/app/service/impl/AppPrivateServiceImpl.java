package com.ruoyi.project.app.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.app.mapper.AppPrivateMapper;
import com.ruoyi.project.app.domain.AppPrivate;
import com.ruoyi.project.app.service.IAppPrivateService;

/**
 * 秘钥Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-14
 */
@Service
public class AppPrivateServiceImpl implements IAppPrivateService 
{
    @Autowired
    private AppPrivateMapper appPrivateMapper;

    /**
     * 查询秘钥
     * 
     * @param privateId 秘钥主键
     * @return 秘钥
     */
    @Override
    public AppPrivate selectAppPrivateByPrivateId(Long privateId)
    {
        return appPrivateMapper.selectAppPrivateByPrivateId(privateId);
    }

    /**
     * 查询秘钥列表
     * 
     * @param appPrivate 秘钥
     * @return 秘钥
     */
    @Override
    public List<AppPrivate> selectAppPrivateList(AppPrivate appPrivate)
    {
        return appPrivateMapper.selectAppPrivateList(appPrivate);
    }

    /**
     * 新增秘钥
     * 
     * @param appPrivate 秘钥
     * @return 结果
     */
    @Override
    public int insertAppPrivate(AppPrivate appPrivate)
    {
        appPrivate.setCreateTime(DateUtils.getNowDate());
        return appPrivateMapper.insertAppPrivate(appPrivate);
    }

    /**
     * 修改秘钥
     * 
     * @param appPrivate 秘钥
     * @return 结果
     */
    @Override
    public int updateAppPrivate(AppPrivate appPrivate)
    {
        appPrivate.setUpdateTime(DateUtils.getNowDate());
        return appPrivateMapper.updateAppPrivate(appPrivate);
    }

    /**
     * 批量删除秘钥
     * 
     * @param privateIds 需要删除的秘钥主键
     * @return 结果
     */
    @Override
    public int deleteAppPrivateByPrivateIds(Long[] privateIds)
    {
        return appPrivateMapper.deleteAppPrivateByPrivateIds(privateIds);
    }

    /**
     * 删除秘钥信息
     * 
     * @param privateId 秘钥主键
     * @return 结果
     */
    @Override
    public int deleteAppPrivateByPrivateId(Long privateId)
    {
        return appPrivateMapper.deleteAppPrivateByPrivateId(privateId);
    }
}
