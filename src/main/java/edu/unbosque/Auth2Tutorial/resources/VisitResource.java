package edu.unbosque.Auth2Tutorial.resources;

import edu.unbosque.Auth2Tutorial.resources.pojos.Pet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/vets/{vet_id}/pets/{pet_id}/visit")
public class VisitResource {

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("vet_id") Integer vet_id, @PathParam("pet_id") Integer pet_id, Pet pet) {

        return Response.ok()
                .entity(pet)
                .build();
    }

    @DELETE
    public Response delete(@PathParam("vet_id") Integer vet_id, @PathParam("pet_id") Integer pet_id) {

        return Response.noContent()
                .build();
    }
}
