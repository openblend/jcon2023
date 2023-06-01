package org.openblend.jcon23.hlambda;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Ales Justin
 */
@Path("/")
public class PriceResource {
    private static final Logger log = LoggerFactory.getLogger(PriceResource.class);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PriceDto calculate(PriceDto dto) {
        log.info("HTTP / REST Lambda ... " + dto);
        return new PriceDto(dto.getPrice() * 1.22);
    }
}
