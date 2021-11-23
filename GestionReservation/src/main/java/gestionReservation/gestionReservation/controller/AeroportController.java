package gestionReservation.gestionReservation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.web.bind.annotation.RequestBody;

import gestionReservation.gestionReservation.Dao.AeroportDao;
import gestionReservation.gestionReservation.entités.Aeroport;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("/aeroports")
public class AeroportController {
	
	AeroportDao aeropDb=new AeroportDao();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Aeroport> getAllAeroport()
	{
		return this.aeropDb.findAllAeroport();
	}
	@GET
	@Path("{nom}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Aeroport> getAllAeroportByName(@PathParam("nom") String nom)
	{
		return this.aeropDb.findAllAeroportByName(nom);
	}
	
	@POST
	@Path("ajouterAero")
	@Consumes(MediaType.APPLICATION_JSON)
	public void ajouterAeroport(@RequestBody Aeroport aeroportToAdd)
	{
		this.aeropDb.saveAeroport(aeroportToAdd);
	}
	
	@DELETE
	@Path("deleteAero/{nom}")
	public void supprimerAeroport(@PathParam("nom")String nom)
	{
		this.aeropDb.deleteAeroport(nom);
	}
	

}


