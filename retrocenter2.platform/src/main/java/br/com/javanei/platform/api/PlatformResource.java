package br.com.javanei.platform.api;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.ParameterIn;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import br.com.javanei.platform.api.mapper.PlatformMapper;
import br.com.javanei.platform.api.vo.PlatformListVO;
import br.com.javanei.platform.api.vo.PlatformVO;
import br.com.javanei.platform.service.PlatformDTO;
import br.com.javanei.platform.service.PlatformService;

@Path("/api/v1/platforms")
public class PlatformResource {
    @Inject
    PlatformService platformService;

    @APIResponses(
        value = {
            @APIResponse(
                responseCode = "200",
                description = "Platform created",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = PlatformVO.class))
            ),
            @APIResponse(
                responseCode = "409",
                description = "Platform already exists",
                content = @Content(mediaType = "text/plain")
            )
        }
    )
    @Operation(
        summary = "Create a platform",
        description = "Create a platform"
    )
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public PlatformVO create(
        @Parameter(description = "Platform info", required = true) 
        @RequestBody(description = "Platform to create", required = true) PlatformVO createVO
        ) {
            PlatformVO result = PlatformMapper.toVO(platformService.create(PlatformMapper.toDTO(createVO)));
            return result;
    }

    @APIResponses(
        value = {
            @APIResponse(
                responseCode = "200",
                description = "Wanted platform",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = PlatformVO.class))
            ),
            @APIResponse(
                responseCode = "404",
                description = "Platform not found",
                content = @Content(mediaType = "text/plain")
            )
        }
    )
    @Operation(
        summary = "Search a platform",
        description = "Search a platform by its identifier"
    )
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PlatformVO findById(
        @Parameter(description = "Platform identifier", required = true, example = "1", in = ParameterIn.PATH) @PathParam("id") Long id
        ) {
        PlatformVO result = PlatformMapper.toVO(platformService.findById(id));
        return result;
    }

    @APIResponses(
        value = {
            @APIResponse(
                responseCode = "200",
                description = "Platforms found",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = PlatformListVO.class))
            )
        }
    )
    @Operation(
        summary = "Search platforms",
        description = "Search platforms by filter"
    )
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PlatformListVO find(
        @Parameter(description = "Platform name", required = false, in = ParameterIn.QUERY) @QueryParam("name") String name,
        @Parameter(description = "Platform alternate name", required = false, in = ParameterIn.QUERY) @QueryParam("alternateName") String alternateName,
        @Parameter(description = "Start page", required = true, example = "0", in = ParameterIn.QUERY) @QueryParam("page") @DefaultValue("0") int page,
        @Parameter(description = "Page size", required = true, example = "100", in = ParameterIn.QUERY) @QueryParam("pageSize") @DefaultValue("100") int pageSize
        ) {
        List<PlatformDTO> list = platformService.find(name, alternateName, page, pageSize);
        PlatformListVO result = PlatformMapper.toListVO(list);
        return result;
    }
}
