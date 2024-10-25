package xyz.ge1st;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import xyz.ge1st.impl.DiffService;
import xyz.ge1st.model.DiffRequest;

import javax.validation.constraints.NotNull;

@Path("/diff")
public class DiffResource {

    @Inject
    DiffService diffService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String getDiff(@NotNull DiffRequest diffRequest) {

        return diffService.compareSpecs(diffRequest);

    }
}
