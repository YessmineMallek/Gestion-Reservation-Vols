package gestionReservation.gestionReservation.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestBody;

import com.sun.research.ws.wadl.Application;

import gestionReservation.gestionReservation.Dao.CompteDao;
import gestionReservation.gestionReservation.entités.Compte;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/comptes")
public class CompteController {
	
	private CompteDao cptDao=new CompteDao();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Compte> getAllComptes()
	{
		return this.cptDao.findAllComptes();
	}
	
	@GET
	@Path("{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Compte> getAllComptesByEmail(@PathParam("email")String email)
	{
		System.out.println("heeeey");
		System.out.println(this.cptDao.findAllCompteByEmail(email)); 
		return this.cptDao.findAllCompteByEmail(email);
	}
	
    @POST
    @Path("addCompte")
    @Consumes(MediaType.APPLICATION_JSON)
    public void ajouterCompte(@RequestBody Compte cptToAdd)
    {
    	this.cptDao.saveCompte(cptToAdd);
    }

    @PUT
    @Path("updateCompte")
    @Consumes(MediaType.APPLICATION_JSON)
    public void modifierCompte(@RequestBody Compte cptToModify,@QueryParam(value="email") String email)
    {
    	System.out.println(email);
    	System.out.println(cptToModify);

    	this.cptDao.updateCompte(cptToModify, email);
    }
    
    @DELETE
    @Path("deleteCompte")
    @Consumes(MediaType.APPLICATION_JSON)
    public void supprimerCompte(@QueryParam(value="email")String email)
    {
    	this.cptDao.deleteCompte(email);
    	
    }
}
