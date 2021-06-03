package edu.unbosque.Taler6.resources;

import edu.unbosque.Taler6.resources.pojos.Case;
import edu.unbosque.Taler6.resources.pojos.Pet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("Cases")
public class CasesResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {

        List<Case> cases = new ArrayList<Case>();
        cases.add(new Case(1,"Today","Perdida","Someone was EVIL",1));
        cases.add(new Case(2,"Today","Robo","Poor thing got an arrow to the knee",2));
        cases.add(new Case(1,"Today","fallecimiento","Someone was EVIL",3));


        return Response.ok()
                .entity(cases)
                .build();
    }

    @GET
    @Path("/type/{type}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listaSexo(@PathParam("type") String type) {

        List<Case> cases = new ArrayList<Case>();
        cases.add(new Case(1,"Today","esterilización","Someone was EVIL",1));
        cases.add(new Case(2,"Today","implantación de microchip","Poor thing got an arrow to the knee",2));
        cases.add(new Case(1,"Today","vacunación","Someone was EVIL",3));
        List<Case> cases2 = new ArrayList<Case>();
        for (int i = 0; i < cases.size(); i++) {
            if (cases.get(i).getType().equals(type)) {
                cases2.add(cases.get(i));
            }
        }

        return Response.ok()
                .entity(cases2)
                .build();
    }

    @GET
    @Path("/case")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listaSexo() {

        List<Case> cases = new ArrayList<Case>();
        cases.add(new Case(1,"Today","esterilización","Someone was EVIL",1));
        cases.add(new Case(2,"Today","implantación de microchip","Poor thing got an arrow to the knee",2));
        cases.add(new Case(1,"Today","vacunación","Someone was EVIL",3));


        return Response.ok()
                .entity(cases)
                .build();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Case aCase) {

        aCase.setCase_id(3);

        return Response.status(Response.Status.CREATED)
                .entity(aCase)
                .build();
    }
}