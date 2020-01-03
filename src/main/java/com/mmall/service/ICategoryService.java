package com.mmall.service;

import com.mmall.common.ServerResponse;

/**
 * Created by dengweiqiang on 2020/1/3
 */
public interface ICategoryService {
    /**
     * 添加品类
     * @param categoryName
     * @param parentId
     * @return
     */
    ServerResponse addCategory(String categoryName, Integer parentId);

    /**
     * 更新品类名字
     * @param categoryId
     * @param categoryName
     * @return
     */
    ServerResponse updateCategoryName(Integer categoryId, String categoryName);

    /**
     * 遍历当前节点下面的子节点
     * @param categoryId
     * @return
     */
    ServerResponse getChildrenParallelCategory(Integer categoryId);

    /**
     * 根据当前节点遍历当前及其字节节点
     * @param categoryId
     * @return
     */
    ServerResponse selectCategoryAndChildrenById(Integer categoryId);
}
