package com.peeskillet;

import com.peeskillet.validation.ResponseValid;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Path("hello")
@Produces("application/json")
@Consumes("application/json")
public class HelloResource {


    @GET
    @ResponseValid
    public HelloMessage getSomething() {
        HelloMessage helloMessage = new HelloMessage();
        helloMessage.setMessage("H");
        return helloMessage;
    }
}
