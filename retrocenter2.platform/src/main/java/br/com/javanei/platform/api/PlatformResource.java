package br.com.javanei.platform.api;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.javanei.platform.api.vo.PlatformVO;

@Path("/api/v1/platforms")
public class PlatformResource {

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public PlatformVO create(PlatformVO createVO) {
        return createVO;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PlatformVO findById(@PathParam("id") Long id) {
        PlatformVO result = new PlatformVO().setId(id).setName(String.format("Platform %d", id));
        return result;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PlatformVO> find(@QueryParam("name") String name,
                                 @QueryParam("alternateName") String alternateName,
                                 @QueryParam("page") @DefaultValue("0") int page,
                                 @QueryParam("pageSize") @DefaultValue("100") int pageSize) {
        List<PlatformVO> result = new LinkedList<>();
        for (int i = 0; i < pageSize; i++) {
            PlatformVO vo = new PlatformVO().setId((long)(i + page + 1));
            vo.setName("Plattorm " + vo.getId());
            result.add(vo);
        }
        return result;
    }
}
