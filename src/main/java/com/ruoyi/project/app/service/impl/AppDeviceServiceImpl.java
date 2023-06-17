package com.ruoyi.project.app.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.app.controller.request.BodyCiphertexts;
import com.ruoyi.project.app.domain.AppProduct;
import com.ruoyi.project.app.domain.AppSupplier;
import com.ruoyi.project.app.mapper.AppProductMapper;
import com.ruoyi.project.app.mapper.AppSupplierMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.app.mapper.AppDeviceMapper;
import com.ruoyi.project.app.domain.AppDevice;
import com.ruoyi.project.app.service.IAppDeviceService;

/**
 * 参数配置Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-13
 */
@Service
public class AppDeviceServiceImpl implements IAppDeviceService 
{
    @Autowired
    private AppDeviceMapper appDeviceMapper;
    @Autowired
    private AppSupplierMapper appSupplierMapper;
    @Autowired
    private AppProductMapper appProductMapper;

    /**
     * 查询参数配置
     * 
     * @param deviceId 参数配置主键
     * @return 参数配置
     */
    @Override
    public AppDevice selectAppDeviceByDeviceId(String deviceId)
    {
        return appDeviceMapper.selectAppDeviceByDeviceId(deviceId);
    }

    @Override
    public AppDevice selectAppDeviceById(Long id) {
        return appDeviceMapper.selectAppDeviceById(id);
    }

    /**
     * 查询参数配置列表
     * 
     * @param appDevice 参数配置
     * @return 参数配置
     */
    @Override
    public List<AppDevice> selectAppDeviceList(AppDevice appDevice)
    {
        return appDeviceMapper.selectAppDeviceList(appDevice);
    }

    /**
     * 新增参数配置
     * 
     * @param appDevice 参数配置
     * @return 结果
     */
    @Override
    public int insertAppDevice(AppDevice appDevice)
    {
        appDevice.setCreateTime(DateUtils.getNowDate());
        return appDeviceMapper.insertAppDevice(appDevice);
    }

    /**
     * 修改参数配置
     * 
     * @param appDevice 参数配置
     * @return 结果
     */
    @Override
    public int updateAppDevice(AppDevice appDevice)
    {
        appDevice.setUpdateTime(DateUtils.getNowDate());
        return appDeviceMapper.updateAppDevice(appDevice);
    }

    @Override
    public int updateAppDeviceUsed(AppDevice appDevice) {
         return appDeviceMapper.updateAppDeviceUsed(appDevice);
    }

    @Override
    public int deleteAppDeviceByIds(Long[] ids) {
        return appDeviceMapper.deleteAppDeviceByIds(ids);
    }

    @Override
    public int deleteAppDeviceById(Long id) {
        return appDeviceMapper.deleteAppDeviceById(id);

    }

    @Override
    public AppDevice checkDeviceId(BodyCiphertexts bodyCiphertexts,AppProduct appProduct) {
        String deviceId=bodyCiphertexts.getDeviceId();
        AppDevice appDevice = appDeviceMapper.selectAppDeviceByDeviceId(deviceId);
        if(appDevice==null){
            AppDevice device = new AppDevice();
            device.setDeviceId(deviceId);
            device.setSupplierId(appProduct.getSupplierId());
            device.setProductId(appProduct.getProductId());
            device.setCreateBy(bodyCiphertexts.getCreateBy());
            device.setCreateTime(DateUtils.getNowDate());
            appDeviceMapper.insertAppDevice(device);
        }else{
            if(appDevice.getIsDeleted()!=0){
                appDevice.setIsDeleted(0);
                appDeviceMapper.updateAppDevice(appDevice);
            }
        }
        return appDevice;
    }



    @Override
    public int logicDeleteById(Long deviceId) {
        return appDeviceMapper.logicDeleteById(deviceId);
    }

    @Override
    public int logicDeleteBatch(Long[] deviceIds) {
        return appDeviceMapper.logicDeleteBatch(deviceIds);

    }

    @Override
    public int inStockCount() {
        return appDeviceMapper.selectInStockCount();

    }

    @Override
    public int AuthorizationCount() {
        return appDeviceMapper.selectDeviceStatusCount();

    }
}
