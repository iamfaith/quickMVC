package org.quickmvc.core.service;

import java.util.List;

/**
 * Created by faith on 16/5/27.
 */
public interface ServiceBase<Model, Primary> {
    /**
     * 插入对象
     *
     * @param model 对象
     */
    int insert(Model model);

    /**
     * 更新对象
     *
     * @param model 对象
     */
    int update(Model model);

    /**
     * 通过主键, 删除对象
     *
     * @param id 主键
     */
    int delete(Primary id);

    /**
     * 通过主键, 查询对象
     *
     * @param id 主键
     * @return model 对象
     */
    Model selectById(Primary id);


//    /**
//     * 查询单个对象
//     *
//     * @return 对象
//     */
//    Model selectOne();
//
//
//    /**
//     * 查询多个对象
//     *
//     * @return 对象集合
//     */
//    List<Model> selectList();

}
