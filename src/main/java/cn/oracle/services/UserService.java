package cn.oracle.services;

import cn.oracle.pojo.UserCustom;

import java.util.List;
import java.util.Map;

/**
 * 用户业务层
 */
public interface UserService {
    /**
     * 获取所有的用户
     * @return
     */
    List<UserCustom> getAllUser();

    /**
     * 添加用户
     * @param custom  传一个封装好的用户对象
     * @return
     */
    int addUser(UserCustom custom);

    /**
     * 登录
     * @param map
     * @return
     */
    UserCustom login(Map map);

    /**
     * 最新添加的用户 自增主键
     * @return
     */
    int getMaxId();
}
