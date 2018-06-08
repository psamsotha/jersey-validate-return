package com.peeskillet;

import com.peeskillet.validation.ValidationFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import javax.ws.rs.ApplicationPath;


@ApplicationPath("/api")
public class JerseyApplication extends ResourceConfig {

    public JerseyApplication() {
        register(HelloResource.class);

        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        register(ValidationFeature.class);
    }
}
