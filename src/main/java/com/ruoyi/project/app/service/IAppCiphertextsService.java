package com.ruoyi.project.app.service;

import java.util.List;
import com.ruoyi.project.app.domain.AppCiphertexts;
import com.ruoyi.project.app.domain.AppLicenses;

/**
 * 密文管理Service接口
 * 
 * @author ruoyi
 * @date 2023-05-20
 */
public interface IAppCiphertextsService 
{
    /**
     * 查询密文管理
     * 
     * @param id 密文管理主键
     * @return 密文管理
     */
    public AppCiphertexts selectAppCiphertextsById(Long id);


    public AppCiphertexts selectAppCiphertextsByDeviceId(String deviceId);

    /**
     * 查询密文管理列表
     * 
     * @param appCiphertexts 密文管理
     * @return 密文管理集合
     */
    public List<AppCiphertexts> selectAppCiphertextsList(AppCiphertexts appCiphertexts);

    /**
     * 新增密文管理
     * 
     * @param appCiphertexts 密文管理
     * @return 结果
     */
    public int insertAppCiphertexts(AppCiphertexts appCiphertexts);

    /**
     * 修改密文管理
     * 
     * @param appCiphertexts 密文管理
     * @return 结果
     */
    public int updateAppCiphertexts(AppCiphertexts appCiphertexts);

    /**
     * 批量删除密文管理
     * 
     * @param ids 需要删除的密文管理主键集合
     * @return 结果
     */
    public int deleteAppCiphertextsByIds(Long[] ids);

    /**
     * 删除密文管理信息
     * 
     * @param id 密文管理主键
     * @return 结果
     */
    public int deleteAppCiphertextsById(Long id);


    /**
     * 修改状态
     * appSupplier
     * @return 结果
     */
    public int updateAppCiphertextsStatus(AppCiphertexts appCiphertexts);
}
