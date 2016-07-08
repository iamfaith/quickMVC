package test.quickmvc.service;

import org.junit.Test;
import org.quickmvc.application.model.User;
import org.quickmvc.application.service.UserSevice;
import org.quickmvc.application.service.impl.TranscationUser;
import org.springframework.beans.factory.annotation.Autowired;
import test.quickmvc.base.TestBase;

import javax.annotation.Resource;

/**
 * Created by faith on 16/5/27.
 */
public class TestService extends TestBase {

    @Resource
    UserSevice userService;

    @Resource(name = "accountServiceProxy")
    UserSevice userProxy;

    @Test
    public void testSelectById() {
        User user = userService.selectById((long) 1);
        System.out.print(user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setUsername("xianzx");
        user.setId((long) 1);
        int ret = userService.update(user);
        System.out.println(ret);
    }

    @Test
    public void testTransaction() {
        TranscationUser user = (TranscationUser) userService;
        user.testUpdateUser();
        ;
    }

    //    使用TransactionFactoryProxyBean 进行事务管理配置
    @Test
    public void testProxyBeanTransaction() {
        userProxy.testTransaction();
    }

    //基于AspectJ xml的方式进行事务管理
    @Test
    public void testAspectJXMLTran() {
        userService.testTransaction();
    }

    //基于注解的方式
    @Test
    public void testAnnoTran() {
        userService.testTransaction();
    }

}
