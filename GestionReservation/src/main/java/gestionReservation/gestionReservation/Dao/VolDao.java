package gestionReservation.gestionReservation.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.util.ArrayList;

import gestionReservation.gestionReservation.entités.Aeroport;
import gestionReservation.gestionReservation.entités.Avion;
import gestionReservation.gestionReservation.entités.Reservation;
import gestionReservation.gestionReservation.entités.Vol;

public class VolDao {

	//findAll()
	public ArrayList<Vol> findAllVol()
	{
		ArrayList<Vol>  lesVols=new ArrayList<Vol> ();
		try 
		{
			Connection cnx=SConnection.getInstance();
			if (cnx!=null)
			{		String req="select code,dateArrivee, dateDepart ,etat,aeroportDepart,aeroportArrive,avion_vol   from vol";
					PreparedStatement stm =cnx.prepareStatement(req);
					ResultSet rs=stm.executeQuery();
					while (rs.next())
					{
						int code=rs.getInt("code");
						LocalDate dateArrivee=rs.getObject("dateArrivee",LocalDate.class);
						LocalDate dateDepart=rs.getObject("dateDepart",LocalDate.class);
						int conf=rs.getInt("etat");
						String aeroDep=rs.getString("aeroportDepart");
						String aeroArr=rs.getString("aeroportArrive");
						String avionImmat=rs.getString("avion_vol");
						
						
						
						Aeroport adep=new Aeroport(aeroDep);
						Aeroport aArr=new Aeroport(aeroArr);
						Avion av=new AvionDao().findAllAvionByImmat(avionImmat);
						
						
						Vol v1=new Vol(code,dateArrivee,dateDepart,conf,adep,aArr,av);
						lesVols.add(v1);
					}
			stm.close();
			}
		}catch (SQLException ex)
		{
			System.out.println("PB Find All Vol()"+ex.getMessage());
			
		}
		
		return lesVols;
	}
	//save
	public void saveVol (Vol vol) 
	{
		
		try 
		{
			 Connection cnx=SConnection.getInstance();
			
			String req ="insert into vol(code,dateArrivee,dateDepart,aeroportDepart,aeroportArrive,avion_vol) values(?,?,?,?,?,?)";
			
			PreparedStatement stm=cnx.prepareStatement(req);
			stm.setInt(1,vol.getCode());
			stm.setObject(2, vol.getDateArrivee());
			stm.setObject(3, vol.getDateDepart());
			stm.setString(4, vol.getAeroportDepart().getNom());
			stm.setString(5, vol.getAeroportArrive().getNom());
			stm.setString(5, vol.getAvion_vol().getImmat());

			int i=stm.executeUpdate();
			if (i>0)
				System.out.println("ajout effectué avec succes");
			stm.close();	
		}catch (SQLException ex)
		{
			if(ex instanceof SQLIntegrityConstraintViolationException)
			{
				System.out.println("Vol numero : "+vol.getCode() +" existe deja!!!!!!!!!!");
			}
		}
		

	}
//update
	public void updateVol(Vol volToUpdate,int code)
	{
		Connection cnx=SConnection.getInstance();
		try
		{
			String req ="update vol SET dateArrivee =?,dateDepart=? ,etat=? ,aeroportDepart=? ,aeroportArrive=?,avion_vol=? where trim(code)=?";
			PreparedStatement stm=cnx.prepareStatement(req);
			stm.setObject(1, volToUpdate.getDateArrivee());
			stm.setObject(2, volToUpdate.getDateDepart());
			stm.setInt(3,volToUpdate.getEtat());
			stm.setString(4, volToUpdate.getAeroportDepart().getNom());
			stm.setString(5, volToUpdate.getAeroportArrive().getNom());
			stm.setString(6, volToUpdate.getAvion_vol().getImmat());
			stm.setInt(7,code);

			int i=stm.executeUpdate();
			if (i>0)
				System.out.println("******Update effectué avec succes\n");
			stm.close();

		}catch (Exception ex)
		{
			System.out.println("Pb in Update Vol \n"+ex);
		}
		
		
		
		
	}
	//delete
	public void deleteVol(int codeToDel)
	{
		try 
		{
			Connection cnx=SConnection.getInstance();
			String req ="delete from vol where trim(code)=?";
			PreparedStatement stm=cnx.prepareStatement(req);
			stm.setInt(1,codeToDel);
			int i=stm.executeUpdate();
			if (i>0)
				System.out.println("le Vol avec le code:"+codeToDel+" supprimer avec succes\n");

			stm.close();
		}catch (SQLException e) {
			System.out.println("PB: Delete volDao\n");
			e.printStackTrace();
		}
		
	}



}
