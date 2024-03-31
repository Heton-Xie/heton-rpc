package com.mingho.easy.common.service;

import com.mingho.easy.common.model.User;

/**
 * 用户服务
 */
public interface UserService {

    /**
     * 获取用户
     */
    User getUser(User user);

    /**
     * 用于测试 mock 接口返回值
     */
    default short getNumber() {
        return 1;
    }
}
