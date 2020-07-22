package com.nabenik.kukulkan.controller;

import com.nabenik.kukulkan.model.Phrase;
import com.nabenik.kukulkan.repository.PhraseRepository;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.List;

@Path("/phrases")
public class PhraseController {

    @Inject
    PhraseRepository phraseRepository;

    @GET
    public List<Phrase> listAll() {
        return phraseRepository.findAll();
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    public Response findById(@PathParam("id") final Long id) {
        Phrase phrase = phraseRepository.findBy(id);
        if (phrase == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(phrase).build();
    }

    @POST
    public Response create(@Valid final Phrase phrase) {
        Phrase result = phraseRepository.save(phrase);
        return Response.created(
                UriBuilder.fromResource(PhraseController.class)
                        .path(result.getPhraseId().toString()).build())
                        .build();
    }

    @PUT
    @Path("/{id:[0-9][0-9]*}")
    public Response update(@PathParam("id") Long id, final Phrase entity) {
        Phrase updatedEntity = phraseRepository.save(entity);
        if (updatedEntity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    public Response deleteById(@PathParam("id") final Long id) {
        Phrase entity = phraseRepository.findBy(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        phraseRepository.attachAndRemove(entity);
        return Response.ok().build();
    }

}
