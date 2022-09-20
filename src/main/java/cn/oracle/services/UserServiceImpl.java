package cn.oracle.services;

import cn.oracle.dao.UserMapper;
import cn.oracle.pojo.UserCustom;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 用户业务实现层
 */
@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserMapper userMapper;

    /**
     * 获取所有用户
     * @return
     */
    @Override
    public List<UserCustom> getAllUser() {
        return userMapper.getAllUser();
    }

    /**
     * 添加用户
     * @param custom  传一个封装好的用户对象
     * @return
     */
    @Override
    public int addUser(UserCustom custom) {
        return userMapper.addUser(custom);
    }

    /**
     * 登录
     * @param map
     * @return
     */
    @Override
    public UserCustom login(Map map) {
        return userMapper.login(map);
    }

    @Override
    public int getMaxId() {
        return userMapper.getMaxId();
    }
}
