package edu.unbosque.Taler6.resources;

import edu.unbosque.Taler6.resources.pojos.Pet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("owners/{person_id}/pet/{pet_id}")
public class PetResource {

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("person_id") Integer person_id, @PathParam("pet_id") Integer pet_id, Pet pet) {

        return Response.ok()
                .entity(pet)
                .build();
    }

    @DELETE
    public Response delete(@PathParam("person_id") Integer person_id, @PathParam("pet_id") Integer pet_id) {

        return Response.noContent()
                .build();
    }
}
