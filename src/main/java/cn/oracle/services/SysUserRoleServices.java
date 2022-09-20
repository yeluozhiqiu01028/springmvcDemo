package cn.oracle.services;

import cn.oracle.pojo.SysUserRole;

public interface SysUserRoleServices {
    /**
     * 添加（和添加用户绑定）
     * @param custom
     * @return
     */
    int addUserRole(SysUserRole custom);

}
