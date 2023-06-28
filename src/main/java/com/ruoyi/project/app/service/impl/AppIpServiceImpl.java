package com.ruoyi.project.app.service.impl;

import java.util.List;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.app.controller.utils.Constants;
import com.ruoyi.project.app.domain.AppSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.app.mapper.AppIpMapper;
import com.ruoyi.project.app.domain.AppIp;
import com.ruoyi.project.app.service.IAppIpService;

/**
 * ip白名单Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-21
 */
@Service
public class AppIpServiceImpl implements IAppIpService 
{
    @Autowired
    private AppIpMapper appIpMapper;

    /**
     * 查询ip白名单
     * 
     * @param id ip白名单主键
     * @return ip白名单
     */
    @Override
    public AppIp selectAppIpById(Long id)
    {
        return appIpMapper.selectAppIpById(id);
    }

    /**
     * 查询ip白名单列表
     * 
     * @param appIp ip白名单
     * @return ip白名单
     */
    @Override
    public List<AppIp> selectAppIpList(AppIp appIp)
    {
        return appIpMapper.selectAppIpList(appIp);
    }

    /**
     * 新增ip白名单
     * 
     * @param appIp ip白名单
     * @return 结果
     */
    @Override
    public int insertAppIp(AppIp appIp)
    {
        return appIpMapper.insertAppIp(appIp);
    }

    /**
     * 修改ip白名单
     * 
     * @param appIp ip白名单
     * @return 结果
     */
    @Override
    public int updateAppIp(AppIp appIp)
    {
        return appIpMapper.updateAppIp(appIp);
    }

    /**
     * 批量删除ip白名单
     * 
     * @param ids 需要删除的ip白名单主键
     * @return 结果
     */
    @Override
    public int deleteAppIpByIds(Long[] ids)
    {
        return appIpMapper.deleteAppIpByIds(ids);
    }

    /**
     * 删除ip白名单信息
     * 
     * @param id ip白名单主键
     * @return 结果
     */
    @Override
    public int deleteAppIpById(Long id)
    {
        return appIpMapper.deleteAppIpById(id);
    }

    @Override
    public boolean checkIpUnique(AppIp appIp) {
        Long ipId = StringUtils.isNull(appIp.getId()) ? -1L : appIp.getId();
        AppIp info = appIpMapper.checkIpUnique(appIp.getIp());
        if (StringUtils.isNotNull(info) && info.getId().longValue() != ipId.longValue())
        {
            return Constants.NOT_UNIQUE;
        }
        return Constants.UNIQUE;
    }

    @Override
    public AppIp selectAppIpByIp(String ip) {
        return appIpMapper.selectAppIpByIp(ip);
    }
}
