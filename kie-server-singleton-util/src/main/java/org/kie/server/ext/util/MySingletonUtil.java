package org.kie.server.ext.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySingletonUtil {

    private static final Logger logger = LoggerFactory.getLogger(MySingletonUtil.class);

    private static MySingletonUtil singleton = null;

    private MySingletonUtil() {
    }

    public static synchronized MySingletonUtil getSingleton() {
        if (singleton != null) {
            return singleton;
        }

        singleton = new MySingletonUtil();
        logger.info("doing initialization...");
        try {
            // your initialization logic
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        logger.info("initialization done");

        return singleton;
    }

    public String getSomeInfo() {
        return "hello";
    }
}
