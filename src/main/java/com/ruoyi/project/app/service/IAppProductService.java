package com.ruoyi.project.app.service;

import java.util.List;

import com.ruoyi.project.app.domain.Product;
import com.ruoyi.project.app.domain.AppProduct;
import com.ruoyi.project.system.domain.SysUser;

/**
 * 产品管理Service接口
 * 
 * @author ruoyi
 * @date 2023-04-13
 */
public interface IAppProductService
{

    /**
     * 统计产品数量
     *
     *
     * @return 产品管理
     */
    public int selectAppProductCount();
    /**
     * 全部产品管理
     *
     *
     * @return 产品管理
     */
    public List<AppProduct> selectAppProductAll();

    /**
     * 查询产品管理
     * 
     * @param productId 产品管理主键
     * @return 产品管理
     */
    public AppProduct selectAppProductByProductId(Long productId);

    /**
     * 根据产品编码查询产品
     * @param productCode
     * @return
     */
    public AppProduct selectAppProductByProductCode(String productCode);

    /**
     * 查询产品管理列表
     * 
     * @param appProduct 产品管理
     * @return 产品管理集合
     */
    public List<AppProduct> selectAppProductList(AppProduct appProduct);

    /**
     * 查询产品管理列表Api
     *
     * @param appProduct 产品管理
     * @return 产品管理集合
     */
    public List<Product> getAppProductList(AppProduct appProduct);

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

    /**
     * 修改产品状态
     * appProduct
     * @return 结果
     */
    public int updateProductStatus(AppProduct appProduct);

    /**
     * 校验产品编号是否唯一
     *
     * @param appProduct 产品信息
     * @return 结果
     */
    public boolean checkProductUnique(AppProduct appProduct);
    /**
     * 逻辑删除
     *
     * @param productId
     * @return
     */
    int logicDeleteById(Long productId);

    /**
     * 批量逻辑删除
     *
     * @param productIds
     * @return
     */
    int logicDeleteBatch(Long[] productIds);
}
