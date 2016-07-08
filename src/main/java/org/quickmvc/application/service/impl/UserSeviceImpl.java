package org.quickmvc.application.service.impl;

import org.quickmvc.application.dao.UserDao;
import org.quickmvc.application.model.User;
import org.quickmvc.application.service.UserSevice;
import org.quickmvc.core.dao.BaseDao;
import org.quickmvc.core.service.ServiceBaseImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by faith on 16/5/27.
 *
 * @Transactional 注解的属性
 * propagation 事务的隔离行为
 * norobackfor 发生哪些异常不回滚
 */
//@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
@Service
public class UserSeviceImpl extends ServiceBaseImpl<User, Long> implements UserSevice {


    @Resource
    protected UserDao userDao;

    public BaseDao<User, Long> getDao() {
        return userDao;
    }


    public void testTransaction() {
        User xianzx = new User();
        xianzx.setId((long) 1);
        xianzx.setUsername("xianzx");
        userDao.updateModel(xianzx);
//        int i = 1 / 0;
    }
}
