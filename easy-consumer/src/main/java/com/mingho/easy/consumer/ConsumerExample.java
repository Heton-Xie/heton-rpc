package com.mingho.easy.consumer;

import com.mingho.hetonrpc.RpcApplication;
import com.mingho.hetonrpc.config.RpcConfig;

/**
 * 服务消费者示例
 */
public class ConsumerExample {
    public static void main(String[] args) {
        // 获取配置，有配置则按配置走，无配置则使用全局默认配置
        RpcConfig rpcConfig = RpcApplication.getRpcConfig();
        System.out.println(rpcConfig);
    }
}
