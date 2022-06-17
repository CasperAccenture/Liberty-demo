package io.liberty.event.client;

import java.util.logging.Logger;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;
import jakarta.ws.rs.BadRequestException;

@Provider
public class BadRequestExceptionMapper
        implements ResponseExceptionMapper<BadRequestException> {
    Logger LOG = Logger.getLogger(BadRequestExceptionMapper.class.getName());

    @Override
    public boolean handles(int status, MultivaluedMap<String, Object> headers) {
        LOG.info("status = " + status);
        return status == 400;
    }

    @Override
    public BadRequestException toThrowable(Response response) {
        return new BadRequestException(response.readEntity(String.class));
    }
}