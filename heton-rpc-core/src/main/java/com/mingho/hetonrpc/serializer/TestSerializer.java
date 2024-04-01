package com.mingho.hetonrpc.serializer;

import com.mingho.easy.common.model.User;
import com.mingho.hetonrpc.model.RpcRequest;
import com.mingho.hetonrpc.model.RpcResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class TestSerializer {
    public static void main(String[] args) {
        User user = new User();
        user.setName("Heton");
        RpcRequest rpcRequest = RpcRequest.builder()
                .serviceName("com.mingho.easy.common.service.UserService")
                .methodName("getUser")
                .parameterTypes(new Class[]{User.class})
                .args(new User[]{user})
                .build();
        JsonSerializer jsonSerializer = new JsonSerializer();
        byte[] serialized = null;
        try {
            serialized = jsonSerializer.serialize(rpcRequest);
        } catch (IOException e) {
            log.error("序列化 error");
        }
        System.out.println(serialized);
        RpcRequest deserialized = null;
        try {
            deserialized = jsonSerializer.deserialize(serialized, RpcRequest.class);
        } catch (IOException e) {
            log.error("反序列化 error");
            e.printStackTrace();
        }
        System.out.println(deserialized);
    }
}
