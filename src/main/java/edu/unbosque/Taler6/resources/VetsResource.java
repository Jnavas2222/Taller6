package edu.unbosque.Taler6.resources;

import edu.unbosque.Taler6.resources.pojos.Owner;
import edu.unbosque.Taler6.resources.pojos.Pet;
import edu.unbosque.Taler6.resources.pojos.Vet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
@Path("Vets")
public class VetsResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {

        List<Vet> vets = new ArrayList<Vet>();

        vets.add(new Vet("Username", "andres u", "pongan aca direccion", "suba"));
        vets.add(new Vet("Username", "andres u", "pongan aca direccion", "suba"));
        vets.add(new Vet("Username", "andres u", "pongan aca direccion", "suba"));
        vets.add(new Vet("Username", "andres u", "pongan aca direccion", "suba"));

        return Response.ok()
                .entity(vets)
                .build();
    }





    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Vet vet) {

        vet.setAddress("calle");

        return Response.status(Response.Status.CREATED)
                .entity(vet)
                .build();
    }

}
