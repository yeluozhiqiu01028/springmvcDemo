package cn.oracle.dao;

import cn.oracle.pojo.SysUserRole;

public interface SysUserRoleMapper {
    /**
     * 添加（和添加用户绑定）
     * @param custom
     * @return
     */
    int addUserRole(SysUserRole custom);


}
