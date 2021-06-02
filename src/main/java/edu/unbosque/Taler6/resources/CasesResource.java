package edu.unbosque.Taler6.resources;

import edu.unbosque.Taler6.resources.pojos.Case;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Path("/pets/{pet_id}/created/{created_at}/type/{type}/description/{description}")
public class CasesResource {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@PathParam("pet_id") Integer pet_id, @PathParam("created_at") String created_at, @PathParam("type") String type, @PathParam("description") String description) {

        List<Case> cases = new ArrayList<Case>();
        Date date = new Date();
        System.out.println(date.toString());
        DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fecha = fechaHora.format(date);


        for (int i = 0; i < cases.size(); i++) {
            cases.add(new Case(i, created_at, type, description, pet_id));
        }


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
