package io.liberty.event.client;

import jakarta.enterprise.context.Dependent;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.BadRequestException;

import jakarta.json.JsonObject;
import jakarta.json.JsonArray;

@Dependent
@RegisterRestClient
@RegisterProvider(UnknownUrlExceptionMapper.class)
@RegisterProvider(BadRequestExceptionMapper.class)
@Path("/events")
public interface EventClient {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    JsonArray getEvents() throws UnknownUrlException;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    JsonObject getEvent(@PathParam("id") int eventId) throws UnknownUrlException;

    @DELETE
    @Path("/{id}")
    void deleteEvent(@PathParam("id") int eventId) throws UnknownUrlException;

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    void addEvent(@FormParam("name") String name,
                  @FormParam("time") String time, @FormParam("location") String location) throws
            UnknownUrlException, BadRequestException;

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    void updateEvent(@FormParam("name") String name,
                     @FormParam("time") String time, @FormParam("location") String location,
                     @PathParam("id") int id) throws UnknownUrlException, BadRequestException;

}
