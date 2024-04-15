package org.example;

import io.quarkus.qute.Engine;
import io.quarkus.qute.Qute;
import io.quarkus.qute.Template;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@ApplicationScoped
public class AppLifecycleBean {
    private static final Logger LOGGER = Logger.getLogger("AppLifecycleBean");
    void onStart(@Observes StartupEvent ev) {
        LOGGER.info("The application is starting...");
        Map<String, Object> payload = new HashMap<>();
        Object payloadObject = "Dummy string";
        payload.put("payloadObject", payloadObject);
        LOGGER.info(Qute.fmt("{obj:varargs(payloadObject??)}", payload));

    }
}
