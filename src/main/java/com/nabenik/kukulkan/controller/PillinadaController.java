package com.nabenik.kukulkan.controller;

import com.nabenik.kukulkan.model.Pillinada;
import com.nabenik.kukulkan.repository.PillinadaRepository;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pillinadas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PillinadaController {
    
    @Inject
    PillinadaRepository pillinadaRepository;
    
    @GET
    public List<Pillinada> findPillinadas(@QueryParam("author")
            @DefaultValue("%") String author){
        return pillinadaRepository.findByAuthorLike("%"+ author + "%");
    }
    
    @POST
    public Response createPillinada(Pillinada pillinada){
        pillinada = pillinadaRepository.save(pillinada);
        return Response.accepted().build();
    }
    
}
