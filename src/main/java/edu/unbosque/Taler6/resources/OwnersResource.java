package edu.unbosque.Taler6.resources;

import edu.unbosque.Taler6.resources.pojos.Owner;
import edu.unbosque.Taler6.resources.pojos.Pet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/Owner")
public class OwnersResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {

        List<Owner> owners = new ArrayList<Owner>();

        owners.add(new Owner("juan25", 3, "DAVID", "calle", "bogota"));
        owners.add(new Owner("juan25", 1, "Robin", "calle", "cali"));
        owners.add(new Owner("juan25", 2, "Juan", "calle", "cali"));


        return Response.ok()
                .entity(owners)
                .build();
    }

    //Punto 4

    @GET
    @Path("/ownersMascota")
    @Produces(MediaType.APPLICATION_JSON)
    public Response punto4(@QueryParam("person_id") String person_id, @QueryParam("name") String name, @QueryParam("neighborhood") String neighborhood) {

        List<Owner> owners = new ArrayList<Owner>();
        List<Owner> owners2 = new ArrayList<Owner>();
        List<Pet> listaPet = new ArrayList<Pet>();

        listaPet.add(new Pet(1, "123sad", "juan", "canino", "buldog", "grande", "masculino", "hola.png", 2));
        listaPet.add(new Pet(1, "123sad", "juan", "canino", "buldog", "grande", "masculino", "hola.png", 1));

        owners.add(new Owner("juan25", 3, "DAVID", "calle", "bogota"));
        owners.add(new Owner("juan25", 1, "Robin", "calle", "cali", listaPet));
        owners.add(new Owner("juan25", 2, "Juan", "calle", "cali", listaPet));


        for (int i = 0; i < owners.size(); i++) {
            if (person_id != null) {
                if (String.valueOf(owners.get(i).getPerson_id()).equals(String.valueOf(person_id))) {
                    owners2.add(owners.get(i));
                }
            }
            if (name != null) {
                if (owners.get(i).getName().equals(name)) {
                    owners2.add(owners.get(i));
                }
            }
            if (neighborhood != null) {
                if (owners.get(i).getNeighborhood().equals(neighborhood)) {
                    owners2.add(owners.get(i));
                }
            }
        }


        return Response.ok()
                .

                        entity(owners2)
                .

                        build();
    }


}