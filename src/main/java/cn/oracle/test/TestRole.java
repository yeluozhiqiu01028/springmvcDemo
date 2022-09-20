package cn.oracle.test;

import cn.oracle.dao.RoleMapper;
import cn.oracle.dao.SysUserRoleMapper;
import cn.oracle.dao.UserMapper;
import cn.oracle.pojo.RoleCustom;
import cn.oracle.pojo.SysUserRole;
import cn.oracle.pojo.User;
import cn.oracle.pojo.UserCustom;
import cn.oracle.services.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestRole {

    @Test
    public void TestRoleServices(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        SysUserRoleMapper contextBean = (SysUserRoleMapper)context.getBean("sysUserRoleMapper");
        SysUserRole sysUserRole = new SysUserRole();
        Long num=4l;
        sysUserRole.setRoleId(num);
        sysUserRole.setUserId(19);

        int i = contextBean.addUserRole(sysUserRole);
        System.out.println(i);
    }
}


