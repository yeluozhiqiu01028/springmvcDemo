package cn.oracle.dao;

import cn.oracle.pojo.RoleCustom;

import java.util.List;

/**
 * 角色接口
 */
public interface RoleMapper {



    /**
     * 获取所有角色
     * @return
     */
    List<RoleCustom> getAllRole();

    /**
     * 删除所有角色
     * @param id
     * @return
     */
    int deleteRoleById(Integer id);
}
