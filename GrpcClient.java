package com.example.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        DeviceServiceGrpc.DeviceServiceBlockingStub stub = DeviceServiceGrpc.newBlockingStub(channel);
        
        DeviceRequest request = DeviceRequest.newBuilder()
                .setDeviceId("12345")
                .setPayload("Temperature: 22C")
                .build();
        
        DeviceResponse response = stub.sendDeviceData(request);
        
        System.out.println("Response from Server: " + response.getStatus());
        
        channel.shutdown();
    }
}