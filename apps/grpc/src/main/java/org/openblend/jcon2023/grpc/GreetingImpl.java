package org.openblend.jcon2023.grpc;

import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;

/**
 * @author Ales Justin
 */
@GrpcService
public class GreetingImpl implements Greeter {
    @Override
    public Uni<HelloReply> sayHello(HelloRequest request) {
        HelloReply reply = HelloReply.newBuilder()
            .setMessage("Hello " + request.getName())
            .build();
        return Uni.createFrom().item(reply);
    }
}
