package com.peeskillet.validation;

import org.glassfish.hk2.api.InterceptionService;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import javax.inject.Singleton;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;


public class ValidationFeature implements Feature {

    @Override
    public boolean configure(FeatureContext context) {

        context.register(ResponseValidationExceptionMapper.class);
        context.register(getBinder());

        return true;
    }

    public AbstractBinder getBinder() {
        return new AbstractBinder() {
            @Override
            protected void configure() {
                bind(ValidationInterceptionService.class)
                        .to(InterceptionService.class)
                        .in(Singleton.class);
            }
        };
    }
}
