package org.openblend.jcon2023.frontend;

import java.util.concurrent.CompletionStage;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Ales Justin
 */
@Path("/prices")
public class PriceResource {
    private static final Logger log = LoggerFactory.getLogger(PriceResource.class);

    @Inject
    @Channel("prices")
    Emitter<Double> priceEmitter;

    @POST
    public CompletionStage<Void> sendPrice(@QueryParam("price") double price) {
        log.info("Received a price of ... {}", price);
        return priceEmitter.send(price);
    }

    @GET
    @Path("/poke")
    public String poke(@QueryParam("name") String name) {
        return "Hello " + name;
    }
}