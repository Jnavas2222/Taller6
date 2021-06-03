package edu.unbosque.Taler6.resources;

import edu.unbosque.Taler6.resources.pojos.Owner;
import edu.unbosque.Taler6.resources.pojos.Pet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/Owner2")
public class OwnerResource2 {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {

        List<Owner> owners = new ArrayList<Owner>();

        owners.add(new Owner("juan25", 3, "DAVID", "calle", "bogota"));
        owners.add(new Owner("juan25", 1, "Robin", "calle", "cali"));
        owners.add(new Owner("juan25", 2, "Juan", "calle", "cali" ));


        return Response.ok()
                .entity(owners)
                .build();
    }

    @GET
    @Path("/neighborhood/{neighborhood}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listaPetid(@PathParam("neighborhood") String neighborhood) {

        List<Owner> owners = new ArrayList<Owner>();

        owners.add(new Owner("juan25", 3, "DAVID", "calle", "bogota"));
        owners.add(new Owner("juan25", 1, "Robin", "calle", "cali"));
        owners.add(new Owner("juan25", 2, "Juan", "calle", "cali" ));

        List<Owner> owners2 = new ArrayList<Owner>();
        for (int i = 0; i < owners.size(); i++) {
            if (owners.get(i).getNeighborhood().equals(neighborhood)) {
                owners2.add(owners.get(i));
            }
        }

        return Response.ok()
                .entity(owners2)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Owner owner) {

        owner.setPerson_id(3);

        return Response.status(Response.Status.CREATED)
                .entity(owner)
                .build();
    }

}
