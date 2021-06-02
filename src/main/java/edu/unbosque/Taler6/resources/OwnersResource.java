package edu.unbosque.Taler6.resources;

import edu.unbosque.Taler6.resources.pojos.Owner;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/User/{username}/Owner")
public class OwnersResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@PathParam("username") String Username) {

        List<Owner> owners = new ArrayList<Owner>();

        owners.add(new Owner(Username, 1, "cristian u", "cdsanchezm@unbosque.edu.co", "barrio los andes"));
        owners.add(new Owner(Username, 2, "andres u", "pongan aca sus correos vagos", "suba"));
        owners.add(new Owner(Username, 3, "esteban c", "pongan aca sus correos vagos", "kenedy"));
        owners.add(new Owner(Username, 4, "pau u", "pongan aca sus correos vagos", "creo que es cerca de la u"));
        owners.add(new Owner(Username, 5, "esteban u", "pongan aca sus correos vagos", "no se XD"));

        return Response.ok()
                .entity(owners)
                .build();
    }


}