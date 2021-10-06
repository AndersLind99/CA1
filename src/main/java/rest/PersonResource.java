package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.PersonDTO;
import facades.HobbyFacade;
import facades.PersonFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

//Todo Remove or change relevant parts before ACTUAL use
@Path("person")
public class PersonResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final PersonFacade FACADE = PersonFacade.getFacadeExample(EMF);
    private static final HobbyFacade HOBBY_FACADE = HobbyFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }


    @Path("count")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getPersonCount() {

        long count = FACADE.getPersonCount();
        //System.out.println("--------------->"+count);
        return "{\"count\":" + count + "}";  //Done manually so no need for a DTO
    }

    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() {
        List<PersonDTO> rns = FACADE.getAll();
        return Response.ok().entity(GSON.toJson(rns)).build();
    }

    @GET
    @Path("getpersonbyhobby/{name}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getPersonByHobby(@PathParam("name") String name) {
        List<PersonDTO> rn = FACADE.getByHobby(name);
        return Response.ok().entity(GSON.toJson(rn)).build();
    }


    @GET
    @Path("getpersonbyhobby/{name}/count")
    @Produces({MediaType.APPLICATION_JSON})
    public String getPersonByHobbyCount(@PathParam("name") String name) {
        long count = HOBBY_FACADE.getHobbyCount(name);
        return "{\"count\":" + count + "}";
    }


    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getById(@PathParam("id") Long id) {
        PersonDTO rn = FACADE.getById(id);
        return Response.ok().entity(GSON.toJson(rn)).build();
    }

    @POST
    @Path("create")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response CreatePerson(String a){

        PersonDTO personDTO = GSON.fromJson(a, PersonDTO.class);
        PersonDTO result = FACADE.create(personDTO);
        return Response.ok().entity(GSON.toJson(result)).build();


    }


    @PUT
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updatePerson(@PathParam("id") Long id, String a) {
        PersonDTO personDto = GSON.fromJson(a, PersonDTO.class);
        personDto.setId(id);
        PersonDTO result = FACADE.update(personDto);
        return Response.ok().entity(GSON.toJson(result)).build();
    }

    @PUT
    @Path("updateHobby/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateHobbies(@PathParam("id") Long id, String h) {

        PersonDTO personDTO = GSON.fromJson(h, PersonDTO.class);
        personDTO.setId(id);
        PersonDTO result = FACADE.updateHobbies(id, personDTO.getHobbies());


        return Response.ok().entity(GSON.toJson(result)).build();

    }

}
