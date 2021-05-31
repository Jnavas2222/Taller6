package edu.unbosque.Taler6.resources;

import edu.unbosque.Taler6.resources.pojos.Case;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/pets/{pet_id}/cases")
public class CasesResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@PathParam("pet_id") Integer pet_id) {

        List<Case> cases = new ArrayList<Case>();
        cases.add(new Case(1,"Today","Steal","Someone was EVIL",pet_id));
        cases.add(new Case(2,"Today","Death","Poor thing got an arrow to the knee",pet_id));

        return Response.ok()
                .entity(cases)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("pet_id") Integer pet_id, Case aCase) {

        aCase.setCase_id(3);

        return Response.status(Response.Status.CREATED)
                .entity(aCase)
                .build();
    }
}
