package edu.unbosque.Taler6.resources;


import edu.unbosque.Taler6.resources.pojos.Owner;
import edu.unbosque.Taler6.resources.pojos.Pet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/pets")
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
    @Path("/mascotaPropetario")
    @Produces(MediaType.APPLICATION_JSON)
    public Response punto4(@QueryParam("microchip") String microchip, @QueryParam("name") String name, @QueryParam("species") String species,@QueryParam("race") String race,@QueryParam("sex") String sex) {

        List<Pet> listaPet2 = new ArrayList<Pet>();
        List<Owner> owners = new ArrayList<Owner>();
        List<Pet> listaPet = new ArrayList<Pet>();

        owners.add(new Owner("juan25", 3, "DAVID", "calle", "bogota"));
        owners.add(new Owner("juan25", 1, "Robin", "calle", "cali", listaPet));
        owners.add(new Owner("juan25", 2, "Juan", "calle", "cali", listaPet));

        listaPet.add(new Pet(1, "123sad", "juan", "canino", "buldog", "grande", "masculino", "hola.png", 2,null));
        listaPet.add(new Pet(1, "123sad", "juan", "canino", "buldog", "grande", "masculino", "hola.png", 1,owners));



        for (int i = 0; i < listaPet.size(); i++) {
            if (microchip != null) {
                if (String.valueOf(listaPet.get(i).getMicrochip()).equals(String.valueOf(microchip))) {
                    listaPet2.add(listaPet.get(i));
                }
            }
            if (name != null) {
                if (listaPet.get(i).getName().equals(name)) {
                    listaPet2.add(listaPet.get(i));
                }
            }
            if (species != null) {
                if (listaPet.get(i).getSpecies().equals(species)) {
                    listaPet2.add(listaPet.get(i));
                }
            }
            if (race != null) {
                if (listaPet.get(i).getRace().equals(race)) {
                    listaPet2.add(listaPet.get(i));
                }
            }
            if (sex != null) {
                if (listaPet.get(i).getSex().equals(sex)) {
                    listaPet2.add(listaPet.get(i));
                }
            }
        }


        return Response.ok()
                .

                        entity(listaPet2)
                .

                        build();
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
