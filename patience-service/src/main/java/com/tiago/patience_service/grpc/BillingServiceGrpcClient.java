package com.tiago.patience_service.grpc;

import billing.BillingRequest;
import billing.BillingResponse;
import billing.BillingServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BillingServiceGrpcClient {
    private final BillingServiceGrpc.BillingServiceBlockingStub blockingStub;

    private static final Logger log = LoggerFactory.getLogger(BillingServiceGrpcClient.class);

    public BillingServiceGrpcClient(
        @Value("${billing.service.address:billing-service}") String serverAddress,
        @Value("${billing.service.grpc.port:9001}") int serverPort)
    {
        
        log.info("Conenctando em BillingService at {}:{}", serverAddress, serverPort);

        ManagedChannel channel = ManagedChannelBuilder.forAddress(serverAddress, serverPort).usePlaintext().build();
        this.blockingStub = BillingServiceGrpc.newBlockingStub(channel);
    }    

    public BillingResponse createBillingAccount(String patientId, String name, String email) {
        BillingRequest request = BillingRequest.newBuilder()
        .setPatientId(patientId)
        .setName(name)
        .setEmail(email)
        .build();

        BillingResponse response = blockingStub.createBillingAccount(request);
        log.info("Mensagem recebida do billing service por gRPC: {}", response);
        return response;
    }

}
;