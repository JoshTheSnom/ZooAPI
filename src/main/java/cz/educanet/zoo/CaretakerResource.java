package cz.educanet.zoo;

import jdk.nashorn.internal.objects.annotations.Getter;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("caretakers")
@Produces(MediaType.APPLICATION_JSON)
public class CaretakerResource {
    @Inject
    private CaretakerManager caretakerManager;
    @GET
    public Response getCaretakers() {
        return Response.ok(caretakerManager.getCaretakers()).build();

    }

    @GET
    @Path("{id}")
    public Response getOneCaretaker(@PathParam("id") int id) {
        return Response.ok(caretakerManager.getCaretakerById(id)).build();
    }

    @POST
    public Response addCaretaker(Caretaker caretaker) {
        caretakerManager.addCaretaker(caretaker);
        return Response.ok().build();

    }
    @PUT
    @Path("{id}")
    public Response editCaretaker(@PathParam("id") int id, Caretaker caretaker) {
        if(caretakerManager.editCaretaker(id, caretaker)) {
            return Response.ok().build();
        }
        else return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteCaretaker(@PathParam("id") int id) {
        if(caretakerManager.deleteCaretaker(id)) {
            return Response.ok().build();
        }
        else return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
