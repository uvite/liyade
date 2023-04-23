package com.ruoyi.project.app.mapper;

import java.util.List;
import com.ruoyi.project.app.domain.AppProduct;
import com.ruoyi.project.app.domain.AppSupplier;

/**
 * 产品管理Mapper接口
 * 
 * @author ruoyi
 * @date 2023-04-13
 */
public interface AppProductMapper 
{
    /**
     * 统计产品数量
     *
     * @return total
     */
    public   int selectAppProductCount();

    /**
     * 查询产品管理
     *
     * @return 产品管理
     */
    public   List<AppProduct> selectAppProductAll();

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
     * 删除产品管理
     * 
     * @param productId 产品管理主键
     * @return 结果
     */
    public int deleteAppProductByProductId(Long productId);

    /**
     * 批量删除产品管理
     * 
     * @param productIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAppProductByProductIds(Long[] productIds);

    /**
     * 逻辑删除产品管理
     *
     * @param productId 产品管理主键
     * @return 结果
     */
    public int logicDeleteById(Long productId);

    /**
     * 逻辑批量删除产品管理
     *
     * @param productIds 需要删除的数据主键集合
     * @return 结果
     */
    public int logicDeleteBatch(Long[] productIds);
}
