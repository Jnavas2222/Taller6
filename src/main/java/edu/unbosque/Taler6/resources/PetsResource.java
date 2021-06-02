package edu.unbosque.Taler6.resources;


import edu.unbosque.Taler6.resources.pojos.Pet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("pets")
public class PetsResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {

        List<Pet> pets = new ArrayList<Pet>();
        pets.add(new Pet(1, "1a", "Roberto", "Dogo", "Doge", "medium", "male", "1", 1));
        pets.add(new Pet(2, "2a", "Michel", "Cat", "Pers", "small", "female", "2", 2));

        return Response.ok()
                .entity(pets)
                .build();
    }

    @GET
    @Path("/{race}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listaDis(@PathParam("race") String race) {

        List<Pet> pets = new ArrayList<Pet>();
        pets.add(new Pet(1, "1a", "Roberto", "Dogo", "Doge", "medium", "male", "1", 1));
        pets.add(new Pet(2, "2a", "Michel", "Cat", "Pers", "small", "female", "2", 2));
        List<Pet> pets2 = new ArrayList<Pet>();
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getRace().equals(race)) {
                pets2.add(pets.get(i));
            }
        }

        return Response.ok()
                .entity(pets2)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Pet pet) {

        pet.setPet_id(3);

        return Response.status(Response.Status.CREATED)
                .entity(pet)
                .build();
    }
}
