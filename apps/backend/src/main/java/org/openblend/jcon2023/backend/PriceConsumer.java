package org.openblend.jcon2023.backend;

import java.util.concurrent.ForkJoinPool;

import io.smallrye.reactive.messaging.annotations.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Ales Justin
 */
@ApplicationScoped
public class PriceConsumer {
    private static final Logger log = LoggerFactory.getLogger(PriceConsumer.class);

    @Inject
    EntityManager em;

    @Incoming("prices")
    @Transactional
    @Blocking
    public void consume(double price) {
        log.info("Consumed price of ... {}", price);
        Price p = new Price();
        p.setPrice(price);
        em.persist(p);
        log.info("Price saved ...");
    }

}