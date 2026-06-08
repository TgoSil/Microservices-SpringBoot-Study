package com.tiago.billing_service.grpc;

import billing.BillingRequest;
import billing.BillingResponse;
import billing.BillingServiceGrpc.BillingServiceImplBase;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class BillingGrpcService extends BillingServiceImplBase{
    
    private static final Logger log = LoggerFactory.getLogger(
        BillingGrpcService.class);
    
    @Override
    public void createBillingAccount(BillingRequest billingRequest,
        StreamObserver<BillingResponse> responseObserver) {
            log.info("Create billing account request received {}", billingRequest.toString());

            // Regras de negócio que não serão feitas pois o meu foco é estudar a arquitetura

            BillingResponse billingResponse = BillingResponse.newBuilder()
                .setAccountId("111")
                .setStatus("ATIVO")
                .build();
            
            responseObserver.onNext(billingResponse);
            responseObserver.onCompleted();

        }
}
