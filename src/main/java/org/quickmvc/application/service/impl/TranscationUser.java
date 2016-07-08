package org.quickmvc.application.service.impl;

import org.quickmvc.application.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;

/**
 * Created by faith on 16/6/6.
 */
public class TranscationUser extends UserSeviceImpl {

    @Resource
    private TransactionTemplate transactionTemplate;

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public void testUpdateUser() {
        try {
            this.transactionTemplate.execute(new TransactionCallbackWithoutResult() {
                @Override
                protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                    User xianzx = new User();
                    xianzx.setId((long) 1);
                    xianzx.setUsername("xianzixiang");
                    TranscationUser.super.userDao.updateModel(xianzx);
//                    int i = 1 / 0;

                }
            });
        }catch(Exception e) {
            e.printStackTrace();
        }
    }


}
