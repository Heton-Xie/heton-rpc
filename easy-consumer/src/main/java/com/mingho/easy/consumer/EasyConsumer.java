package com.mingho.easy.consumer;

import com.mingho.easy.common.model.User;
import com.mingho.easy.common.service.UserService;
import com.mingho.hetonrpc.proxy.ServiceProxyFactory;

/**
 * 服务消费者
 */
public class EasyConsumer {
    public static void main(String[] args) {

        // 动态代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("Heton");

        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
    }
}
