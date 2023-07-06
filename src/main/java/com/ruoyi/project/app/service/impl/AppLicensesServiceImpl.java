package com.ruoyi.project.app.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.project.app.controller.request.BodyLicenses;
import com.ruoyi.project.app.controller.request.LicensesUpdate;
import com.ruoyi.project.app.controller.utils.License;
import com.ruoyi.project.app.domain.AppDevice;
import com.ruoyi.project.app.mapper.AppDeviceMapper;
import com.ruoyi.project.app.mapper.AppDevicesStatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.project.app.domain.AppDevicesStatus;
import com.ruoyi.project.app.mapper.AppLicensesMapper;
import com.ruoyi.project.app.domain.AppLicenses;
import com.ruoyi.project.app.service.IAppLicensesService;

/**
 * 授权管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-31
 */
@Service
public class AppLicensesServiceImpl implements IAppLicensesService 
{
    @Autowired
    private AppLicensesMapper appLicensesMapper;

    @Autowired
    private AppDevicesStatusMapper appDevicesStatusMapper;
    @Autowired
    private AppDeviceMapper appDeviceMapper;
    /**
     * 查询授权管理
     * 
     * @param id 授权管理主键
     * @return 授权管理
     */
    @Override
    public AppLicenses selectAppLicensesById(Long id)
    {
        return appLicensesMapper.selectAppLicensesById(id);
    }

    /**
     * 是否重复提交数据 md5校验
     */
    @Override
    public AppLicenses selectAppLicensesByMd5(String md5)
    {
        return appLicensesMapper.getAppLicensesByLicenseMd5(md5);
    }

    /**
     * 查询授权管理列表
     * 
     * @param appLicenses 授权管理
     * @return 授权管理
     */
    @Override
    public List<AppLicenses> selectAppLicensesList(AppLicenses appLicenses)
    {
        return appLicensesMapper.selectAppLicensesList(appLicenses);
    }

    /**
     * 新增授权管理
     * 
     * @param appLicenses 授权管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertAppLicenses(AppLicenses appLicenses)
    {
        appLicenses.setCreateTime(DateUtils.getNowDate());
        int rows = appLicensesMapper.insertAppLicenses(appLicenses);
        insertAppDevicesStatus(appLicenses);
        return rows;
    }

    /**
     * 修改授权管理
     * 
     * @param appLicenses 授权管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateAppLicenses(AppLicenses appLicenses)
    {
        appLicenses.setUpdateTime(DateUtils.getNowDate());
        appLicensesMapper.deleteAppDevicesStatusByLicenseId(appLicenses.getId());
        insertAppDevicesStatus(appLicenses);
        return appLicensesMapper.updateAppLicenses(appLicenses);
    }

    /**
     * 批量删除授权管理
     * 
     * @param ids 需要删除的授权管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteAppLicensesByIds(Long[] ids)
    {
        appLicensesMapper.deleteAppDevicesStatusByIds(ids);
        return appLicensesMapper.deleteAppLicensesByIds(ids);
    }

    /**
     * 删除授权管理信息
     * 
     * @param id 授权管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteAppLicensesById(Long id)
    {
        appLicensesMapper.deleteAppDevicesStatusById(id);
        return appLicensesMapper.deleteAppLicensesById(id);
    }

    @Override
    public List<AppLicenses> selectAppLicensesListByDeviceIds(List<String> deviceIds) {

        String[] array = deviceIds.toArray(new String[deviceIds.size()]);
        return appLicensesMapper.selectAppLicensesListByDeviceIds(array);
    }



    /**
     * 新增授权管理信息
     * 
     * @param appLicenses 授权管理对象
     */
    public void insertAppDevicesStatus(AppLicenses appLicenses)
    {
        List<AppDevicesStatus> appDevicesStatusList = appLicenses.getAppDevicesStatusList();
        Long id = appLicenses.getId();
        if (StringUtils.isNotNull(appDevicesStatusList))
        {
            List<AppDevicesStatus> list = new ArrayList<AppDevicesStatus>();
            for (AppDevicesStatus appDevicesStatus : appDevicesStatusList)
            {
                appDevicesStatus.setLicenseId(id);
                list.add(appDevicesStatus);

                System.out.println(appDevicesStatus.toString());
            }
            if (list.size() > 0)
            {
                appLicensesMapper.batchAppDevicesStatus(list);
            }
        }
    }

    /**
     * 查询授权管理
     *
     * @param licenseId 授权管理主键
     * @return 授权管理
     */
    @Override
    public  AppLicenses  selectAppLicensesByLicenseId(String licenseId) {
        return appLicensesMapper.selectAppLicensesByLicenseId(licenseId);
    }
    /**
     * 审核
     *
     * @param appLicenses 信息
     * @return 结果
     */
    @Override
    public int updateAppLicenseEnabled(AppLicenses appLicenses) {
        return appLicensesMapper.updateAppLicensesEnabled(appLicenses);
    }

    /**
     * 修改状态
     *
     * @param appLicenses 信息
     * @return 结果
     */
    @Override
    public int updateAppLicenseStatus(AppLicenses appLicenses) {
        return appLicensesMapper.updateAppLicensesStatus(appLicenses);
    }
    @Override
    public int updateBatchAppLicenseStatus(LicensesUpdate appLicenses) {


        AppLicenses licenses = appLicensesMapper.getAppLicensesByLicenseId(appLicenses.getLicenseId());
        int ret=0;
        if(licenses!=null){

            for (int i = 0; i < appLicenses.getDeviceId().size(); i++) {
                AppDevicesStatus appDevicesStatus=new AppDevicesStatus();
                appDevicesStatus.setLicenseId(licenses.getId());
                appDevicesStatus.setDeviceId(appLicenses.getDeviceId().get(i));
                appDevicesStatus.setUsed(appLicenses.getUsed().get(i));
                ret+=appDevicesStatusMapper.updateAppDevicesStatusUsed(appDevicesStatus);

                AppDevice appDevice=new AppDevice();
                appDevice.setDeviceId(appLicenses.getDeviceId().get(i));
                appDevice.setUsed(appLicenses.getUsed().get(i));

                appDeviceMapper.updateAppDeviceUsed(appDevice);
            }
        }


        return  ret;
    }
}
