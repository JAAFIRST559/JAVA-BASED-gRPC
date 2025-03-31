# Java-Based gRPC Service for Device Data Processing

## Overview
This project is a Java-based gRPC service designed to receive and process data from IoT or other device-based sources. The service includes:

- A **gRPC Server** that listens for incoming device data requests.
- A **gRPC Client** that sends test data to the server.
- Protocol Buffers (`.proto` file) to define the communication structure.

This setup allows efficient, low-latency communication between devices and servers using the gRPC framework.

---

## Features
- Uses **gRPC** for fast and efficient communication.
- Supports **Protocol Buffers** (`.proto`) for structured data exchange.
- Implements a **simple device data request-response model**.
- Includes **Maven build support** for easy dependency management.

---

## Prerequisites
Ensure you have the following installed:

1. **Java Development Kit (JDK) 8+** ([Download](https://adoptopenjdk.net/))
2. **Apache Maven** ([Download](https://maven.apache.org/download.cgi))
3. **Git** ([Download](https://git-scm.com/downloads))
4. **gRPC and Protocol Buffers Compiler (`protoc`)**

For Ubuntu/Linux, install `protoc` using:
```sh
sudo apt install protobuf-compiler
```
For Windows, download from [Protocol Buffers Releases](https://github.com/protocolbuffers/protobuf/releases).

---

## Installation and Setup

### 1. Clone the Repository
```sh
git clone https://github.com/YOUR_USERNAME/grpc-device-data-service.git
cd grpc-device-data-service
```

### 2. Build the Project
Run the following command to install dependencies and generate gRPC classes:
```sh
mvn clean install
```

---

## Running the gRPC Server
Start the server using:
```sh
mvn exec:java -Dexec.mainClass="com.example.grpc.GrpcServer"
```
Expected output:
```
gRPC Server started on port 50051
```

---

## Running the gRPC Client
Run the client to send a request to the server:
```sh
mvn exec:java -Dexec.mainClass="com.example.grpc.GrpcClient"
```
Expected output:
```
Response from Server: Data received from device: 12345
```

---

## gRPC API Definition
The gRPC communication is defined in `device.proto`:
```proto
syntax = "proto3";

package com.example.grpc;

service DeviceService {
    rpc SendDeviceData (DeviceRequest) returns (DeviceResponse);
}

message DeviceRequest {
    string device_id = 1;
    string payload = 2;
}

message DeviceResponse {
    string status = 1;
}
```

---

## Project Structure
```
grpc-device-data-service/
│── src/
│   ├── main/
│   │   ├── java/com/example/grpc/
│   │   │   ├── DeviceServiceImpl.java   # gRPC service implementation
│   │   │   ├── GrpcServer.java          # Server startup
│   │   │   ├── GrpcClient.java          # Client implementation
│   │   ├── proto/device.proto           # Protocol Buffers definition
│── pom.xml                              # Maven configuration
│── README.md                            # Project documentation
```

---

## Troubleshooting
### **1. Port Already in Use Error**
If the server fails to start, ensure port `50051` is free or change it in `GrpcServer.java`.

### **2. Maven Build Fails**
Ensure all dependencies are installed and update them using:
```sh
mvn clean install
```

### **3. gRPC Classes Not Found**
Run the following to regenerate gRPC Java classes:
```sh
mvn clean compile
```

---

## Contributing
Feel free to submit issues and pull requests.

---

## License
This project is open-source under the [MIT License](LICENSE).

---

## Author
Developed by **Jasmine Ilakkia Neviskennedy** 🚀.
