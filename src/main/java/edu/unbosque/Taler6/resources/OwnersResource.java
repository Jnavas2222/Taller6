package edu.unbosque.Taler6.resources;

import edu.unbosque.Taler6.resources.pojos.Owner;
import edu.unbosque.Taler6.resources.pojos.Pet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("Owner")
public class OwnersResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {

        List<Owner> owners = new ArrayList<Owner>();

        owners.add(new Owner("juan", 1, "cristian u", "cdsanchezm@unbosque.edu.co", "barrio los andes"));
        owners.add(new Owner("Username", 2, "andres u", "pongan aca sus correos vagos", "suba"));
        owners.add(new Owner("Username", 3, "esteban c", "pongan aca sus correos vagos", "kenedy"));
        owners.add(new Owner("Username", 4, "pau u", "pongan aca sus correos vagos", "creo que es cerca de la u"));
        owners.add(new Owner("Username", 5, "esteban u", "pongan aca sus correos vagos", "no se XD"));

        return Response.ok()
                .entity(owners)
                .build();
    }

    //Punto 8
    @GET
    @Path("/{neighborhood}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listaPropetariosMascotas(@PathParam("neighborhood") String neighborhood) {

        List<Owner> owners = new ArrayList<Owner>();
        owners.add(new Owner("juan25", 1, "Juan", "calle", "bogota"));
        owners.add(new Owner("juan25", 1, "Juan", "calle", "cali"));
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

    //Punto 4
    @GET
    @Path("/person_id/{person_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listaIdentificacionMascotas(@PathParam("person_id") int person_id) {

        List<Pet> pets = new ArrayList<Pet>();
        List<Owner> owners = new ArrayList<Owner>();
        List<Owner> owners2 = new ArrayList<Owner>();

        owners.add(new Owner("juan25", 1, "Juan", "calle", "bogota"));
        owners.add(new Owner("juan25", 2, "Juan", "calle", "cali"));

        pets.add(new Pet(1, "1a", "Roberto", "Dogo", "Doge", "medium", "male", "1", 1));
        pets.add(new Pet(2,"Michel",  "2a", "Cat", "Pers", "small", "female", "2", 2));


        for (int i = 0; i < owners.size(); i++) {
            if (owners.get(i).getPerson_id()==(person_id)) {
                if(owners.get(i).getPerson_id() == (pets.get(i).getOwner_id())){
                    owners2.add(owners.get(i));
                }
            }
        }

        return Response.ok()
                .entity(owners2)
                .build();
    }

    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listaNombreMascotas(@PathParam("name") String name) {

        List<Pet> pets = new ArrayList<Pet>();
        List<Owner> owners = new ArrayList<Owner>();
        List<Owner> owners2 = new ArrayList<Owner>();

        owners.add(new Owner("juan25", 1, "Juan", "calle", "bogota"));
        owners.add(new Owner("juan2", 2, "Juan", "calle", "cali"));

        pets.add(new Pet(1, "1a", "Roberto", "Dogo", "Doge", "medium", "male", "1", 1));
        pets.add(new Pet(2,"Michel",  "2a", "Cat", "Pers", "small", "female", "2", 2));


        for (int i = 0; i < owners.size(); i++) {
            if (owners.get(i).getName()==(name)) {
                   owners2.add(owners.get(i));
            }
        }

        return Response.ok()
                .entity(owners2)
                .build();
    }


    @GET
    @Path("/neighborhood/{neighborhood}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listaLocalidadMascotas(@PathParam("neighborhood") String neighborhood) {

        List<Pet> pets = new ArrayList<Pet>();
        List<Owner> owners = new ArrayList<Owner>();
        List<Owner> owners2 = new ArrayList<Owner>();

        owners.add(new Owner("juan25", 1, "Juan", "calle", "bogota"));
        owners.add(new Owner("juan2", 2, "Juan", "calle", "cali"));

        pets.add(new Pet(1, "1a", "Roberto", "Dogo", "Doge", "medium", "male", "1", 1));
        pets.add(new Pet(2,"Michel",  "2a", "Cat", "Pers", "small", "female", "2", 2));


        for (int i = 0; i < owners.size(); i++) {
            if (owners.get(i).getName()==(neighborhood)) {
                owners2.add(owners.get(i));
            }
        }

        return Response.ok()
                .entity(owners2)
                .build();
    }

}