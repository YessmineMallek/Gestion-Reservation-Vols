package gestionReservation.gestionReservation.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import com.sun.research.ws.wadl.Application;

import gestionReservation.gestionReservation.Dao.ReservationDao;
import gestionReservation.gestionReservation.entités.Reservation;
//import jakarta.websocket.server.PathParam;
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
@CrossOrigin(origins = "http://localhost:4200")
@Path("/reservations")
public class ReservationController {
	
	private ReservationDao resDao=new ReservationDao();
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Reservation> getAll()
	{
    	return  this.resDao.findAll();
	}

    @GET
    @Path("{numero}")
    @Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Reservation> getAllByNumero(@PathParam("numero")String numero)
	{
    	return  this.resDao.findAllByNumero(numero);
	}
    
    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
	public void ajouterReservation(@RequestBody  Reservation res)
	{
		this.resDao.save(res);
	}
    @PUT
    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
	public void modifierReservation(@RequestBody Reservation res , @QueryParam(value = "num") String num)
	{
		this.resDao.update(res, num);
	}
    
    @DELETE
    @Path("{numero}")
	public void SupprimerReservation (@PathParam(value="numero")String num)
	{
		System.out.println("le numero"+num);
    	this.resDao.delete(num);
	}

}
