package org.openblend.jcon2023.test.grpc;

import java.time.Duration;

import io.quarkus.grpc.GrpcClient;
import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openblend.jcon2023.grpc.Greeter;
import org.openblend.jcon2023.grpc.HelloReply;
import org.openblend.jcon2023.grpc.HelloRequest;

/**
 * @author Ales Justin
 */
@QuarkusTest
public class GRPCTest {

    @GrpcClient("hello")
    @Inject
    Greeter greeter;

    @Test
    public void testInvoke() {
        HelloRequest request = HelloRequest.newBuilder()
            .setName("Ales")
            .build();
        Uni<HelloReply> reply = greeter.sayHello(request);
        Assertions.assertEquals(
            "Hello Ales",
            reply.await().atMost(Duration.ofSeconds(5)).getMessage()
        );
    }
}
