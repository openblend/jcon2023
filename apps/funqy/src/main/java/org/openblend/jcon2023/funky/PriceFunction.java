package org.openblend.jcon2023.funky;

import io.quarkus.funqy.Funq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Ales Justin
 */
public class PriceFunction {
    private static final Logger log = LoggerFactory.getLogger(PriceFunction.class);

    @Funq
    public PriceDto calculate(PriceDto dto) {
        log.info("Funqy ... " + dto);
        return new PriceDto(dto.getPrice() * 1.22);
    }
}
