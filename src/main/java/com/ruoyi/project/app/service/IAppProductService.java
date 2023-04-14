package com.ruoyi.project.app.service;

import java.util.List;
import com.ruoyi.project.app.domain.AppProduct;

/**
 * 产品管理Service接口
 * 
 * @author ruoyi
 * @date 2023-04-13
 */
public interface IAppProductService 
{
    /**
     * 查询产品管理
     * 
     * @param productId 产品管理主键
     * @return 产品管理
     */
    public AppProduct selectAppProductByProductId(Long productId);

    /**
     * 查询产品管理列表
     * 
     * @param appProduct 产品管理
     * @return 产品管理集合
     */
    public List<AppProduct> selectAppProductList(AppProduct appProduct);

    /**
     * 新增产品管理
     * 
     * @param appProduct 产品管理
     * @return 结果
     */
    public int insertAppProduct(AppProduct appProduct);

    /**
     * 修改产品管理
     * 
     * @param appProduct 产品管理
     * @return 结果
     */
    public int updateAppProduct(AppProduct appProduct);

    /**
     * 批量删除产品管理
     * 
     * @param productIds 需要删除的产品管理主键集合
     * @return 结果
     */
    public int deleteAppProductByProductIds(Long[] productIds);

    /**
     * 删除产品管理信息
     * 
     * @param productId 产品管理主键
     * @return 结果
     */
    public int deleteAppProductByProductId(Long productId);
}
