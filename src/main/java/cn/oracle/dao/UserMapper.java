package cn.oracle.dao;

import cn.oracle.pojo.UserCustom;

import java.util.List;
import java.util.Map;

/**
 * 用户接口
 */
public interface UserMapper {
    /**
     * 获取所有用户（浏览界面）
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
