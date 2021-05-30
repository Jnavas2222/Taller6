package edu.unbosque.Auth2Tutorial.resources;

import edu.unbosque.Auth2Tutorial.resources.pojos.Pet;
import edu.unbosque.Auth2Tutorial.resources.pojos.Visit;
import javafx.beans.binding.IntegerBinding;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/vets/{vet_id}/pets/{pet_id}/visits/{visit_id}")
public class VisitsResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@PathParam("vet_id") Integer vet_id, @PathParam("pet_id") Integer pet_id) {

        List<Visit> visits = new ArrayList<Visit>();
        visits.add(new Visit(1,"Today", "Control","Control of the pet",vet_id,pet_id));
        visits.add(new Visit(2,"Today", "Microchip implantation","adding a chip",vet_id,pet_id));

        return Response.ok()
                .entity(visits)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("vet_id") Integer vet_id, @PathParam("pet_id") Integer pet_id, Visit visit) {

        visit.setCreated_at("Today");
        visit.setVet_id(vet_id);
        visit.setPet_id(pet_id);

        return Response.status(Response.Status.CREATED)
                .entity(visit)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createMicrochip(@PathParam("vet_id") Integer vet_id, Integer pet_id, String microchip,Visit visit, Pet pet) {

        visit.setCreated_at("Today");
        visit.setVet_id(vet_id);
        visit.setPet_id(pet_id);
        pet.setMicrochip(microchip);

        return Response.status(Response.Status.CREATED)
                .entity(visit)
                .build();
    }
}
