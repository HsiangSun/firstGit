import cn.hsiangsun.domain.SysRole;
import cn.hsiangsun.domain.SysUser;
import cn.hsiangsun.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class test01 {

    @Autowired
    private UserMapper mapper;


    @Test
    public void testMapper(){
        List<SysRole> roleList = mapper.findRoleByUid(1);
        for (SysRole role : roleList) {
            System.out.println(role);
        }
    }

    @Test
    public void testMny(){
        List<SysUser> userList = mapper.findAllUser();
        for (SysUser user : userList) {
            System.out.println(user);
        }
    }

}
