package com.peeskillet.validation;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;


public class ResponseValidationExceptionMapper implements ExceptionMapper<ResponseValidationException> {

    @Override
    public Response toResponse(ResponseValidationException ex) {
        return Response.serverError().entity("There was an error processing the request.").build();
    }
}
