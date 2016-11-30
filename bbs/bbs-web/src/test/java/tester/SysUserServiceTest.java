package tester;

import com.jzfq.pms.common.common.PageVo;
import com.jzfq.pms.domain.SysUser;
import com.jzfq.pms.service.ISysUserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * Created by zhishuo on 9/27/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml","classpath:spring-mvc.xml"})
@TransactionConfiguration
public class SysUserServiceTest {

    @Autowired
    private ISysUserService sysUserService;

    @Test
    public void getAllUserTest() throws Exception{
        SysUser user = new SysUser();
        PageVo vo = new PageVo();
//        List<SysUser> list =  sysUserService.findUserList(vo);
//        Assert.assertTrue(!list.equals(null));
    }
}
