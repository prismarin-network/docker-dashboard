package in.prismar.docker.dashboard.resource;

import in.prismar.docker.dashboard.model.ImageDto;
import in.prismar.docker.dashboard.service.images.ImagesService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/images")
public class ImagesResource {

    @Inject
    ImagesService service;

    @GET
    public List<ImageDto> getAll() {
        return service.getAllImages();
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") String id) {
        ImageDto image = service.getImage(id);
        if(image != null) {
            return Response.ok(image).build();
        }
        return Response.status(404).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        boolean success = service.deleteImage(id);
        return Response.status(success ? 204 : 404).build();
    }
}