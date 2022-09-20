package cn.oracle.services;

import cn.oracle.pojo.SysUserRole;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserRoleServicesImpl implements SysUserRoleServices{
    @Resource
    private SysUserRoleServices sysUserRoleServices;

    /**
     * 添加第三张表
     * @param custom
     * @return
     */
    @Override
    public int addUserRole(SysUserRole custom) {
        return sysUserRoleServices.addUserRole(custom);
    }
}
