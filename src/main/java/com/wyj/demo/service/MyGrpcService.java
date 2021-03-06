package com.wyj.demo.service;

import com.example.grpc.TestRequest;
import com.example.grpc.TestResponse;
import com.example.grpc.TestServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class MyGrpcService {

    @GrpcClient(value = "local-my-service111")
    private TestServiceGrpc.TestServiceBlockingStub testServiceBlockingStub;

    public void test2() {
        TestResponse response = testServiceBlockingStub.queryTest(
                TestRequest.newBuilder().setName("wyj").build()
        );
        System.out.println(response.getAddress());
        System.out.println(response.toString());
    }
}
