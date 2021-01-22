package cz.educanet.zoo;

import jdk.nashorn.internal.objects.annotations.Getter;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("animals")
@Produces(MediaType.APPLICATION_JSON)
public class AnimalResource {
    @Inject
    private AnimalManager animalManager;
    @GET
    public Response getAnimals() {
        return Response.ok(animalManager.getAnimals()).build();

    }

    @GET
    @Path("{id}")
    public Response getOneAnimal(@PathParam("id") int id) {
        return Response.ok(animalManager.getAnimalById(id)).build();
    }

    @POST
    public Response addAnimal(
            /*@FormParam("id") int id,
            @FormParam("Name") String name,
            @FormParam("Age") int age,
            @FormParam("Weight") double weight,
            @FormParam("Gender") String gender*/
            Animal animal
    ) {
        animalManager.addAnimal(animal);
        return Response.ok().build();

    }
    @PUT
    @Path("{id}")
    public Response editAnimal(@PathParam("id") int id, Animal animal) {
        if(animalManager.editAnimal(id, animal)) {
            return Response.ok().build();
        }
        else return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteAnimal(@PathParam("id") int id) {
        if(animalManager.deleteAnimal(id)) {
            return Response.ok().build();
        }
        else return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
