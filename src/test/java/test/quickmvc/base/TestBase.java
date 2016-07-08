package test.quickmvc.base;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


/**
 * Created by faith on 16/5/26.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/springmvc-*.xml"})
public class TestBase {

    private Log log = LogFactory.getLog("FILE");
    private ApplicationContext ac = null;

    @Before
    public void init() {

//        ac = new ClassPathXmlApplicationContext("classpath:spring/springmvc-*.xml");

        log.debug("junit test init");
    }


    @Resource
    DruidDataSource dataSource;
    @Test
    public void logTest() {


        System.out.println("hello world" + dataSource);
        log.debug("junit test !!!");
    }
}
