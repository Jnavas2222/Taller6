package edu.unbosque.Taler6.resources;

import edu.unbosque.Taler6.resources.filters.Logged;
import edu.unbosque.Taler6.resources.pojos.Owner;
import edu.unbosque.Taler6.resources.pojos.User;
import edu.unbosque.Taler6.services.UserAppService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/owners")
public class OwnerResource {

    @POST
    @Path("/creatOwner")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Owner owner) {

        return Response.status(Response.Status.CREATED)
                .entity(owner)
                .build();
    }

    @PUT
    @Path("/username/{username}/person_id/{person_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("username") String Username,  @PathParam("person_id") Integer id, Owner owner) {
        return Response.ok()
                .entity(owner)
                .build();
    }


    @Logged
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response modify(@HeaderParam("role") String role, User user) {
        user.setRole(role);

        return Response.ok().entity("Role changed").build();
    }

    @Logged
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response hello(@HeaderParam("role") String role) {

        // If role doesn't match
        if (!"owner".equals(role))
            return Response.status(Response.Status.FORBIDDEN)
                    .entity("Role " + role + " cannot access to this method")
                    .build();

        return Response.ok()
                .entity("Hello, World, " + role + "!")
                .build();

    }

}