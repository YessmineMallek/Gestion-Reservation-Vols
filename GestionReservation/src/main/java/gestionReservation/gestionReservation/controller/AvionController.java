package gestionReservation.gestionReservation.controller;


import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import gestionReservation.gestionReservation.Dao.AvionDao;
import gestionReservation.gestionReservation.entités.Avion;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/avions")
public class AvionController {
	AvionDao avDb=new AvionDao();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Avion> getAllAvions()
	{
		return this.avDb.findAllAvions();
	}
	@GET
	@Path("{idAv}")
	@Produces(MediaType.APPLICATION_JSON)
	public Avion getAvionById(@PathParam("idAv") String idAvion )
	{
		return this.avDb.findAllAvionByImmat(idAvion);
	}
	@POST
	@Path("addAvion")
	@Consumes(MediaType.APPLICATION_JSON)
	public void ajouterAeroport(@RequestBody Avion avionToAdd)
	{
		this.avDb.saveAvion(avionToAdd);;
	}
	@PUT
	@Path("updateAv/{immat}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void ModifierAvion(@RequestBody Avion avionToUpdate,@PathParam("immat")String immat)
	{
		this.avDb.updateAvion(avionToUpdate,immat);;
	}
	@DELETE
	@Path("deleteAvion/{immat}")
	public void supprimerAeroport(@PathParam("immat")String immatricule)
	{
		this.avDb.delete(immatricule);
	}
	
	

}
