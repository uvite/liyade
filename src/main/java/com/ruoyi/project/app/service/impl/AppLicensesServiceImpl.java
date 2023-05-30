package com.ruoyi.project.app.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.project.app.controller.request.BodyLicenses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.app.mapper.AppLicensesMapper;
import com.ruoyi.project.app.domain.AppLicenses;
import com.ruoyi.project.app.service.IAppLicensesService;

/**
 * 授权管理Service业务层处理
 *
 * @author ruoyi
 * @date 2023-05-21
 */
@Service
public class AppLicensesServiceImpl implements IAppLicensesService {
    @Autowired
    private AppLicensesMapper appLicensesMapper;

    /**
     * 查询授权管理
     *
     * @param id 授权管理主键
     * @return 授权管理
     */
    @Override
    public AppLicenses selectAppLicensesById(Long id) {
        return appLicensesMapper.selectAppLicensesById(id);
    }

    /**
     * 查询授权管理列表
     *
     * @param appLicenses 授权管理
     * @return 授权管理
     */
    @Override
    public List<AppLicenses> selectAppLicensesList(AppLicenses appLicenses) {
        return appLicensesMapper.selectAppLicensesList(appLicenses);
    }

    /**
     * 查询授权管理
     *
     * @param licenseId 授权管理主键
     * @return 授权管理
     */
    @Override
    public List<AppLicenses> selectAppLicensesByLicenseId(String licenseId) {
        return appLicensesMapper.selectAppLicensesByLicenseId(licenseId);
    }

    @Override
    public List<AppLicenses> selectAppLicensesListByDeviceIds(List<String> deviceIds) {

        String[] array = deviceIds.toArray(new String[deviceIds.size()]);
        return appLicensesMapper.selectAppLicensesListByDeviceIds(array);

    }


    /**
     * 新增授权管理
     *
     * @param appLicenses 授权管理
     * @return 结果
     */
    @Override
    public int insertAppLicenses(AppLicenses appLicenses) {
        appLicenses.setCreateTime(DateUtils.getNowDate());
        return appLicensesMapper.insertAppLicenses(appLicenses);
    }

    @Override
    public int insertBatchAppLicenses(BodyLicenses appLicenses) {

        int ret = 0;

        for (int i = 0; i < appLicenses.getDeviceId().size(); i++) {

            AppLicenses licenses = new AppLicenses();
            BeanUtils.copyBeanProp(licenses, appLicenses);
            licenses.setDeviceId(appLicenses.getDeviceId().get(i));
            licenses.setUsed("0");
            ret += this.insertAppLicenses(licenses);

        }
        return ret;

    }

    /**
     * 修改授权管理
     *
     * @param appLicenses 授权管理
     * @return 结果
     */
    @Override
    public int updateAppLicenses(AppLicenses appLicenses) {
        appLicenses.setUpdateTime(DateUtils.getNowDate());
        return appLicensesMapper.updateAppLicenses(appLicenses);
    }

    /**
     * 批量删除授权管理
     *
     * @param ids 需要删除的授权管理主键
     * @return 结果
     */
    @Override
    public int deleteAppLicensesByIds(Long[] ids) {
        return appLicensesMapper.deleteAppLicensesByIds(ids);
    }

    /**
     * 删除授权管理信息
     *
     * @param id 授权管理主键
     * @return 结果
     */
    @Override
    public int deleteAppLicensesById(Long id) {
        return appLicensesMapper.deleteAppLicensesById(id);
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
    public int updateBatchAppLicenseStatus(BodyLicenses appLicenses) {

        int ret = 0;

        for (int i = 0; i < appLicenses.getDeviceId().size(); i++) {

            AppLicenses licenses = new AppLicenses();
            BeanUtils.copyBeanProp(licenses, appLicenses);
            licenses.setDeviceId(appLicenses.getDeviceId().get(i));
            ret += this.updateAppLicenseStatus(licenses);

        }
        return ret;
    }
}
