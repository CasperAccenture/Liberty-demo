package io.liberty.event.client;

import java.util.logging.Logger;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

@Provider
public class UnknownUrlExceptionMapper
        implements ResponseExceptionMapper<UnknownUrlException> {
    Logger LOG = Logger.getLogger(UnknownUrlExceptionMapper.class.getName());

    @Override
    public boolean handles(int status, MultivaluedMap<String, Object> headers) {
        LOG.info("status = " + status);
        return status == 404;
    }

    @Override
    public UnknownUrlException toThrowable(Response response) {
        return new UnknownUrlException();
    }
}