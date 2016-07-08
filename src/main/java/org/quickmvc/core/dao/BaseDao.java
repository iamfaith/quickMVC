package org.quickmvc.core.dao;

/**
 * 所有dao都是继承自BaseDao接口
 * 可通过Mabtis Generator Maven插件生成Dao
 * Created by faith on 16/5/27.
 */
public interface BaseDao<Model, Primary> {
    /**
     * 插入对象
     *
     * @param model 对象
     */
    int insertModel(Model model);


    /**
     * 更新对象
     *
     * @param model 对象
     */
    int updateModel(Model model);


    /**
     * 删除对象
     *
     * @param id
     * @return
     */
    int deleteModel(Primary id);


    /**
     * 通过主键,查询对象
     *
     * @param pk
     * @return
     */
    Model selectByPrimaryKey(Primary pk);
}
