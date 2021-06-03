package edu.unbosque.Taler6.resources;


import edu.unbosque.Taler6.resources.pojos.Owner;
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
    @Path("/pet_id/{pet_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listaIDPet(@PathParam("pet_id") int pet_id) {

        List<Pet> pets = new ArrayList<Pet>();
        pets.add(new Pet(1, "1a", "Roberto", "Dogo", "Doge", "medium", "male", "1", 1));
        pets.add(new Pet(2, "2a", "Michel", "Cat", "Pers", "small", "female", "2", 2));
        List<Pet> pets2 = new ArrayList<Pet>();
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getPet_id()==(pet_id)) {
                pets2.add(pets.get(i));
            }
        }

        return Response.ok()
                .entity(pets2)
                .build();
    }

    @GET
    @Path("/species/{species}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listaSpeciesPet(@PathParam("species") String species) {

        List<Pet> pets = new ArrayList<Pet>();
        pets.add(new Pet(1, "1a", "Roberto", "Dogo", "Doge", "medium", "male", "1", 1));
        pets.add(new Pet(2, "2a", "Michel", "Cat", "Pers", "small", "female", "2", 2));
        List<Pet> pets2 = new ArrayList<Pet>();
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getSpecies().equals(species)) {
                pets2.add(pets.get(i));
            }
        }

        return Response.ok()
                .entity(pets2)
                .build();
    }
    @GET
    @Path("/race/{race}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listaRacePet(@PathParam("race") String race) {

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
    @GET
    @Path("/size/{size}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listaSizePet(@PathParam("size") int size) {

        List<Pet> pets = new ArrayList<Pet>();
        pets.add(new Pet(1, "1a", "Roberto", "Dogo", "Doge", "medium", "male", "1", 1));
        pets.add(new Pet(2, "2a", "Michel", "Cat", "Pers", "small", "female", "2", 2));
        List<Pet> pets2 = new ArrayList<Pet>();
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getSize().equals(size)) {
                pets2.add(pets.get(i));
            }
        }

        return Response.ok()
                .entity(pets2)
                .build();
    }
    @GET
    @Path("/sex/{sex}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listaSexPet(@PathParam("sex") String sex) {

        List<Pet> pets = new ArrayList<Pet>();
        pets.add(new Pet(1, "1a", "Roberto", "Dogo", "Doge", "medium", "male", "1", 1));
        pets.add(new Pet(2, "2a", "Michel", "Cat", "Pers", "small", "female", "2", 2));
        List<Pet> pets2 = new ArrayList<Pet>();
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getSex().equals(sex)) {
                pets2.add(pets.get(i));
            }
        }

        return Response.ok()
                .entity(pets2)
                .build();
    }
    @GET
    @Path("/microchip/{microchip}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listaMicroshipPet(@PathParam("microchip") int microchip) {

        List<Pet> pets = new ArrayList<Pet>();
        pets.add(new Pet(1, "1a", "Roberto", "Dogo", "Doge", "medium", "male", "1", 1));
        pets.add(new Pet(2, "2a", "Michel", "Cat", "Pers", "small", "female", "2", 2));
        List<Pet> pets2 = new ArrayList<Pet>();
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getMicrochip().equals(microchip)) {
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
