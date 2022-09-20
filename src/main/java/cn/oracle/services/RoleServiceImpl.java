package cn.oracle.services;

import cn.oracle.dao.RoleMapper;
import cn.oracle.pojo.RoleCustom;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{
    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<RoleCustom> getAllRole() {
        List<RoleCustom> allRole = roleMapper.getAllRole();
        return allRole;
    }

    @Override
    public int deleteRoleById(Integer id) {
        int i = roleMapper.deleteRoleById(id);
        return i;
    }
}
