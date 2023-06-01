package org.openblend.jcon2023.test.frontend;

import java.util.Map;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Ales Justin
 */
public class FrontendTestResource implements QuarkusTestResourceLifecycleManager {
    private static final Logger log = LoggerFactory.getLogger(FrontendTestResource.class);

    @Override
    public Map<String, String> start() {
        log.info("Starting Frontend LM ...");
        return Map.of("jcon23.frontend.property", "foobar");
    }

    @Override
    public void stop() {
        log.info("Stopping Frontend LM ...");
    }
}
