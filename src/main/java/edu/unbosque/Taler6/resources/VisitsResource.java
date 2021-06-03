package edu.unbosque.Taler6.resources;

import edu.unbosque.Taler6.resources.pojos.Pet;
import edu.unbosque.Taler6.resources.pojos.Visit;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/vist")
public class VisitsResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listRegistro(@QueryParam("type") String type) {

        List<Visit>visits = new ArrayList<Visit>();

        if(type.equals("esterilización")){
            visits.add(new Visit(1,"Today", type,"Control of the pet",1,1));
            visits.add(new Visit(2,"Today", type,"Operacion",1,2));
            visits.add(new Visit(3,"Today", type,"Operacion",1,3));

        }
        if(type.equals("implantación de microchip")){
            visits.add(new Visit(1,"Today", type,"Control of the pet",1,1));
            visits.add(new Visit(2,"Today", type,"Operacion",1,2));
            visits.add(new Visit(3,"Today", type,"Operacion",1,3));

        }
        if(type.equals("vacunación")){
            visits.add(new Visit(1,"Today", type,"Control of the pet",1,1));
            visits.add(new Visit(2,"Today", type,"Operacion",1,2));
            visits.add(new Visit(3,"Today", type,"Operacion",1,3));

        }
        if(type.equals("desparasitación")){
            visits.add(new Visit(1,"Today", type,"Control of the pet",1,1));
            visits.add(new Visit(2,"Today", type,"Operacion",1,2));
            visits.add(new Visit(3,"Today", type,"Operacion",1,3));

        }
        if(type.equals("urgencia")){
            visits.add(new Visit(1,"Today", type,"Control of the pet",1,1));
            visits.add(new Visit(2,"Today", type,"Operacion",1,2));
            visits.add(new Visit(3,"Today", type,"Operacion",1,3));

        }
        if(type.equals("control")){
            visits.add(new Visit(1,"Today", type,"Control of the pet",1,1));
            visits.add(new Visit(2,"Today", type,"Operacion",1,2));
            visits.add(new Visit(3,"Today", type,"Operacion",1,3));

        }

        return Response.ok()
                .entity(visits)
                .build();
    }


}
