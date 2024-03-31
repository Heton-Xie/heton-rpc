package com.mingho.easy.provider;

import com.mingho.easy.common.model.User;
import com.mingho.easy.common.service.UserService;

/**
 * 用户服务实现类
 */
public class UserServiceImpl implements UserService {
    @Override
    public User getUser(User user) {
        System.out.println("调用服务...");
        System.out.printf("用户名： " + user.getName());
        return user;
    }
}
