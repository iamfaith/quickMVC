package org.quickmvc.core.service;

import org.quickmvc.core.dao.BaseDao;

import java.util.List;

/**
 * Created by faith on 16/5/27.
 */
public abstract class ServiceBaseImpl<Model, Primary> implements ServiceBase<Model, Primary> {


    /**
     * 定义成抽象方法,由子类实现,完成dao的注入
     *
     * @return GenericDao实现类
     */
    public abstract BaseDao<Model, Primary> getDao();

    /**
     * 插入对象
     *
     * @param model 对象
     */
    public int insert(Model model) {
        return getDao().insertModel(model);
    }

    /**
     * 更新对象
     *
     * @param model 对象
     */
    public int update(Model model) {
        return getDao().updateModel(model);
    }

    /**
     * 通过主键, 删除对象
     *
     * @param id 主键
     */
    public int delete(Primary id) {
        return getDao().deleteModel(id);
    }

    /**
     * 通过主键, 查询对象
     *
     * @param id 主键
     * @return
     */
    public Model selectById(Primary id) {
        return getDao().selectByPrimaryKey(id);
    }



//    public Model selectOne() {
//        return null;
//    }
//
//
//    public List<Model> selectList() {
//        return null;
//    }
}
