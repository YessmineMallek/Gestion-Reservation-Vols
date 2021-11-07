package gestionReservation.gestionReservation.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestBody;

import gestionReservation.gestionReservation.Dao.VolDao;
import gestionReservation.gestionReservation.entités.Reservation;
import gestionReservation.gestionReservation.entités.Vol;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/vols")
public class VolController {
	
	VolDao volDb=new VolDao();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Vol> getAllVols()
	{
		return this.volDb.findAllVol();
	}
	
	@POST
    @Path("addVol")
    @Consumes(MediaType.APPLICATION_JSON)
	public void ajouterVol(@RequestBody  Vol volToADD)
	{
		this.volDb.saveVol(volToADD);
	}
	
	
	@PUT 
	@Path("updateVol/{code}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void modifierVol(@RequestBody Vol volToUpdate, @PathParam("code") int code)
	{
		this.volDb.updateVol(volToUpdate,code);
	}
	
	
	@DELETE
	@Path("deleteVol/{code}")
	public void supprimerVol(@PathParam("code") int code)
	{
		this.volDb.deleteVol(code);
	}
	

}
