package Controllers;

import java.util.Collection;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.MediaType;

import Services.EntityService;

public abstract class EntityController <T extends EntityService<R,E>, R extends EntityRepository<E>, E extends GenericEntity>{
	
	@Inject
	 protected T service;
	
	 @Context
	 private UriInfo context;
	
	@GET
	@Path("healthCheck")
	@Produces(MediaType.TEXT_PLAIN)
	public String healthcheck() {
		return "URI " + context.getRequestUri().toString() + " is OK!";
	}
	
	@GET
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<E> getAll () {
		return service.getAll();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public E getOne(@PathParam("id") long id) {
		return service.getOne(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public E post(E entity) {
		return service.create(entity);
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public E put(@PathParam("id") long id, E entity) {
		return service.edit(id, entity);
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String del(@PathParam("id") long id) {
		return service.del(id);
	}
	
}
