package edu.unbosque.Taler6.resources;

import edu.unbosque.Taler6.resources.pojos.Pet;
import edu.unbosque.Taler6.resources.pojos.Visit;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/visit2")
public class VisitsResource2 {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {

        List<Visit> visits = new ArrayList<Visit>();
        visits.add(new Visit(1, "Today", "esterilización", "Control of the pet", 1, 1));
        visits.add(new Visit(2, "Today", "implantación", "Operacion", 1, 2));
        visits.add(new Visit(3, "Today", "urgencia ", "Operacion", 1, 3));


        return Response.ok()
                .entity(visits)
                .build();
    }


    @GET
    @Path("/type/{type}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listaTipo(@PathParam("type") String type) {

        List<Visit> visits = new ArrayList<Visit>();
        visits.add(new Visit(1, "Today", "esterilización", "Control of the pet", 1, 1));
        visits.add(new Visit(2, "Today", "implantación", "Operacion", 1, 2));
        visits.add(new Visit(3, "Today", "urgencia ", "Operacion", 1, 3));
        List<Visit> visits2 = new ArrayList<Visit>();
        for (int i = 0; i < visits.size(); i++) {
            if (visits.get(i).getType().equals(type)) {
                visits2.add(visits.get(i));
            }
        }

        return Response.ok()
                .entity(visits2)
                .build();
    }
    @GET
    @Path("/vet_id/{vet_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listaVeterinaria(@PathParam("vet_id") String vet_id) {

        List<Visit> visits = new ArrayList<Visit>();
        visits.add(new Visit(1, "Today", "esterilización", "Control of the pet", 1, 1));
        visits.add(new Visit(2, "Today", "implantación", "Operacion", 2, 2));
        visits.add(new Visit(3, "Today", "urgencia ", "Operacion", 3, 3));
        List<Visit> visits2 = new ArrayList<Visit>();
        for (int i = 0; i < visits.size(); i++) {
            if (String.valueOf(visits.get(i).getVet_id()).equals(vet_id)) {
                visits2.add(visits.get(i));
            }
        }

        return Response.ok()
                .entity(visits2)
                .build();
    }
}
