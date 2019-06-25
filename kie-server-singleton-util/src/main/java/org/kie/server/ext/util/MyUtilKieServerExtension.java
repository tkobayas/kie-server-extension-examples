package org.kie.server.ext.util;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.kie.server.services.api.KieContainerInstance;
import org.kie.server.services.api.KieServerExtension;
import org.kie.server.services.api.KieServerRegistry;
import org.kie.server.services.api.SupportedTransports;
import org.kie.server.services.impl.KieServerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyUtilKieServerExtension implements KieServerExtension {

    private static final Logger logger = LoggerFactory.getLogger(MyUtilKieServerExtension.class);

    public static final String EXTENSION_NAME = "MyUtil";
    
    private boolean initialized = false;

    public boolean isActive() {
        return true;
    }

    public void init(KieServerImpl kieServer, KieServerRegistry registry) {
        logger.info("init");
        MySingletonUtil.getSingleton(); // Trigger initialization
        
        initialized = true;
    }

    public void destroy(KieServerImpl kieServer, KieServerRegistry registry) {
        // If you want to cleanup something, write here
        logger.info("destroy");
    }

    public void createContainer(String id, KieContainerInstance kieContainerInstance, Map<String, Object> parameters) {
    }

    public void disposeContainer(String id, KieContainerInstance kieContainerInstance, Map<String, Object> parameters) {
    }

    public List<Object> getAppComponents(SupportedTransports type) {
        return Collections.emptyList();
    }

    public <T> T getAppComponents(Class<T> serviceType) {
        return null;
    }

    public String getImplementedCapability() {
        return "BPM-MyUtil";
    }

    public List<Object> getServices() {
        return Collections.emptyList();
    }

    public String getExtensionName() {
        return EXTENSION_NAME;
    }

    public Integer getStartOrder() {
        return 20;
    }

    @Override
    public String toString() {
        return EXTENSION_NAME + " KIE Server extension";
    }

    public boolean isInitialized() {
        return initialized;
    }

    public boolean isUpdateContainerAllowed(String arg0, KieContainerInstance arg1, Map<String, Object> arg2) {
        return false;
    }

    public void updateContainer(String arg0, KieContainerInstance arg1, Map<String, Object> arg2) {
    }
}
