import com.alibaba.fastjson.JSON;
import com.ilearn.platform.bean.UserInfo;
import com.ilearn.platform.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Creator zhuweijun
 * Date 2017/9/5 0005.
 */
@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestMyBatis
{
    private static Logger logger = Logger.getLogger(TestMyBatis.class);

    @Resource
    private UserService userService = null;

    @Test
    public void test1() {
        UserInfo user = userService.getUserById(1);
        System.out.println(user.getUserName());
        // logger.info("值："+user.getUserName());
        logger.info(JSON.toJSONString(user));
    }
}
