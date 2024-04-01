package com.mingho.easy.provider;

import com.mingho.easy.common.service.UserService;
import com.mingho.hetonrpc.RpcApplication;
import com.mingho.hetonrpc.config.RegistryConfig;
import com.mingho.hetonrpc.config.RpcConfig;
import com.mingho.hetonrpc.model.ServiceMetaInfo;
import com.mingho.hetonrpc.registry.LocalRegistry;
import com.mingho.hetonrpc.registry.Registry;
import com.mingho.hetonrpc.registry.RegistryFactory;
import com.mingho.hetonrpc.server.HttpServer;
import com.mingho.hetonrpc.server.VertxHttpServer;
import com.sun.net.httpserver.HttpsServer;

/**
 * 服务提供者示例
 */
public class ProviderExample {
    public static void main(String[] args) {

        // RPC 框架初始化
        RpcApplication.init();

        // 注册服务
        String serviceName = UserService.class.getName();
        LocalRegistry.register(serviceName, UserServiceImpl.class);

        // 注册服务到注册中心
        RpcConfig rpcConfig = RpcApplication.getRpcConfig();
        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
        ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
        serviceMetaInfo.setServiceName(serviceName);
        serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
        serviceMetaInfo.setServicePort(rpcConfig.getServerPort());
        try {
            registry.register(serviceMetaInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}
