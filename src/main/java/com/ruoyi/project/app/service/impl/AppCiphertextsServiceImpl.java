package com.ruoyi.project.app.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.app.controller.request.BodyCiphertexts;
import com.ruoyi.project.app.domain.AppLicenses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.app.mapper.AppCiphertextsMapper;
import com.ruoyi.project.app.domain.AppCiphertexts;
import com.ruoyi.project.app.service.IAppCiphertextsService;

/**
 * 密文管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-20
 */
@Service
public class AppCiphertextsServiceImpl implements IAppCiphertextsService 
{
    @Autowired
    private AppCiphertextsMapper appCiphertextsMapper;

    /**
     * 查询密文管理
     * 
     * @param id 密文管理主键
     * @return 密文管理
     */
    @Override
    public AppCiphertexts selectAppCiphertextsById(Long id)
    {
        return appCiphertextsMapper.selectAppCiphertextsById(id);
    }

    
    /**
     * 查询密文管理
     * 
     * @param deviceId 密文管理主键
     * @return 密文管理
     */
    @Override
    public AppCiphertexts selectAppCiphertextsByDeviceId(String deviceId)
    {
        return appCiphertextsMapper.selectAppCiphertextsByDeviceId(deviceId);
    }

    /**
     * 查询密文管理列表
     * 
     * @param appCiphertexts 密文管理
     * @return 密文管理
     */
    @Override
    public List<AppCiphertexts> selectAppCiphertextsList(AppCiphertexts appCiphertexts)
    {
        return appCiphertextsMapper.selectAppCiphertextsList(appCiphertexts);
    }

    /**
     * 新增密文管理
     * 
     * @param appCiphertexts 密文管理
     * @return 结果
     */
    @Override
    public int insertAppCiphertexts(AppCiphertexts appCiphertexts)
    {
        appCiphertexts.setCreateTime(DateUtils.getNowDate());
        return appCiphertextsMapper.insertAppCiphertexts(appCiphertexts);
    }

    /**
     * 修改密文管理
     * 
     * @param appCiphertexts 密文管理
     * @return 结果
     */
    @Override
    public int updateAppCiphertexts(AppCiphertexts appCiphertexts)
    {
        appCiphertexts.setUpdateTime(DateUtils.getNowDate());
        return appCiphertextsMapper.updateAppCiphertexts(appCiphertexts);
    }

    /**
     * 批量删除密文管理
     * 
     * @param ids 需要删除的密文管理主键
     * @return 结果
     */
    @Override
    public int deleteAppCiphertextsByIds(Long[] ids)
    {
        return appCiphertextsMapper.deleteAppCiphertextsByIds(ids);
    }

    /**
     * 删除密文管理信息
     * 
     * @param id 密文管理主键
     * @return 结果
     */
    @Override
    public int deleteAppCiphertextsById(Long id)
    {
        return appCiphertextsMapper.deleteAppCiphertextsById(id);
    }

    /**
     * 修改状态
     *
     * @param appCiphertexts 信息
     * @return 结果
     */
    @Override
    public int updateAppCiphertextsStatus(BodyCiphertexts appCiphertexts)
    {
        return appCiphertextsMapper.updateAppCiphertextsStatus(appCiphertexts);
    }
}

