package edu.unbosque.Taler6.resources;


import edu.unbosque.Taler6.resources.pojos.Pet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/owners/{person_id}/pets")
public class PetsResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@PathParam("person_id") Integer person_id) {

        List<Pet> pets = new ArrayList<Pet>();
        pets.add(new Pet(1,"1a","Roberto","Dogo","Doge","medium","male","1",person_id));
        pets.add(new Pet(2,"2a","Michel","Cat","Pers","small","female","2",person_id));

        return Response.ok()
                .entity(pets)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("peron_id") Integer person_id, Pet pet) {

        pet.setPet_id(3);

        return Response.status(Response.Status.CREATED)
                .entity(pet)
                .build();
    }
}
