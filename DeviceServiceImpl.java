package com.example.grpc;

import io.grpc.stub.StreamObserver;

public class DeviceServiceImpl extends DeviceServiceGrpc.DeviceServiceImplBase {
    @Override
    public void sendDeviceData(DeviceRequest request, StreamObserver<DeviceResponse> responseObserver) {
        String responseMessage = "Data received from device: " + request.getDeviceId();
        
        DeviceResponse response = DeviceResponse.newBuilder()
                .setStatus(responseMessage)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}