package edu.unbosque.Taler6.resources;

import edu.unbosque.Taler6.resources.pojos.Pet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("owners/{person_id}/pet/{pet_id}")
public class PetResource {


    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("person_id") Integer person_id, @PathParam("pet_id") Integer pet_id, Pet pet) {

        List<Pet> listaPet = new ArrayList<>();
        for(int i = 0; i<listaPet.size(); i++){
            if(String.valueOf(pet_id).equals(listaPet.get(i).getPet_id())){

            }
        }


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
