package com.mingho.easy.consumer;

import com.mingho.easy.common.model.User;
import com.mingho.easy.common.service.UserService;
import com.mingho.hetonrpc.RpcApplication;
import com.mingho.hetonrpc.config.RpcConfig;
import com.mingho.hetonrpc.proxy.ServiceProxyFactory;

/**
 * 服务消费者示例
 */
public class ConsumerExample {
    public static void main(String[] args) {
        // 获取代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("heton");
        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }

        long number = userService.getNumber();
        System.out.println(number);
    }
}
