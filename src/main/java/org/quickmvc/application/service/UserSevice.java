package org.quickmvc.application.service;

import org.quickmvc.application.model.User;
import org.quickmvc.core.service.ServiceBase;

/**
 * Created by faith on 16/5/28.
 */
public interface UserSevice extends ServiceBase<User, Long> {

    /**
     * 下面增加一些特殊方法:暂时不增加
     */
    public void testTransaction();
}
