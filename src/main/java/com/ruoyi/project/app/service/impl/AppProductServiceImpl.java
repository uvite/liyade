package com.ruoyi.project.app.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.app.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.app.mapper.AppProductMapper;
import com.ruoyi.project.app.domain.AppProduct;
import com.ruoyi.project.app.service.IAppProductService;

/**
 * 产品管理Service业务层处理
 *
 * @author ruoyi
 * @date 2023-04-13
 */
@Service
public class AppProductServiceImpl implements IAppProductService {
    @Autowired
    private AppProductMapper appProductMapper;


    @Override
    public List<AppProduct> selectAppProductAll() {
        return appProductMapper.selectAppProductAll();
    }

    @Override
    public int selectAppProductCount() {
        return appProductMapper.selectAppProductCount();
    }


    /**
     * 查询产品管理
     *
     * @param productId 产品管理主键
     * @return 产品管理
     */
    @Override
    public AppProduct selectAppProductByProductId(Long productId) {
        return appProductMapper.selectAppProductByProductId(productId);
    }
    /**
     * 查询产品管理
     *
     * @param productCode 产品code
     * @return 产品管理
     */
    @Override
    public AppProduct selectAppProductByProductCode(String productCode) {
        return appProductMapper.selectAppProductByProductCode(productCode);

    }

    /**
     * 查询产品管理列表
     *
     * @param appProduct 产品管理
     * @return 产品管理
     */
    @Override
    public List<AppProduct> selectAppProductList(AppProduct appProduct) {
        return appProductMapper.selectAppProductList(appProduct);
    }

    /**
     * 查询产品管理列表Api
     *
     * @param appProduct 产品管理
     * @return 产品管理
     */
    @Override
    public List<Product> getAppProductList(AppProduct appProduct) {
        return appProductMapper.getAppProductList(appProduct);
    }

    /**
     * 新增产品管理
     *
     * @param appProduct 产品管理
     * @return 结果
     */
    @Override
    public int insertAppProduct(AppProduct appProduct) {
        appProduct.setCreateTime(DateUtils.getNowDate());
        return appProductMapper.insertAppProduct(appProduct);
    }

    /**
     * 修改产品管理
     *
     * @param appProduct 产品管理
     * @return 结果
     */
    @Override
    public int updateAppProduct(AppProduct appProduct) {
        appProduct.setUpdateTime(DateUtils.getNowDate());
        return appProductMapper.updateAppProduct(appProduct);
    }

    /**
     * 批量删除产品管理
     *
     * @param productIds 需要删除的产品管理主键
     * @return 结果
     */
    @Override
    public int deleteAppProductByProductIds(Long[] productIds) {
        return appProductMapper.deleteAppProductByProductIds(productIds);
    }

    /**
     * 删除产品管理信息
     *
     * @param productId 产品管理主键
     * @return 结果
     */
    @Override
    public int deleteAppProductByProductId(Long productId) {
        return appProductMapper.deleteAppProductByProductId(productId);
    }

    /**
     * 修改供应商状态
     *
     * @param appProduct 供应商信息
     * @return 结果
     */
    @Override
    public int updateProductStatus(AppProduct appProduct) {
        return appProductMapper.updateAppProduct(appProduct);
    }

    @Override
    public int logicDeleteById(Long productId) {
        return appProductMapper.logicDeleteById(productId);
    }

    @Override
    public int logicDeleteBatch(Long[] productIds) {
        return appProductMapper.logicDeleteBatch(productIds);

    }
}
