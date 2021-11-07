package gestionReservation.gestionReservation.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import gestionReservation.gestionReservation.entités.Aeroport;
import gestionReservation.gestionReservation.entités.Avion;

public class AvionDao {
	//findAllAvion()
		public Avion findAllAvionByImmat(String immat)
			{
			Avion av=null;
	
			try 
				{
					Connection cnx=SConnection.getInstance();
					if (cnx!=null)
					{		String req="select immat, capacite,etatDisponible from avion where immat=?";
							PreparedStatement stm =cnx.prepareStatement(req);
							stm.setString(1, immat);
							ResultSet rs=stm.executeQuery();
							while (rs.next())
							{
								  av=new Avion(rs.getString("immat"), rs.getString("etatDisponible"),rs.getInt("capacite") );
							}
					stm.close();
					}
				}catch (SQLException ex)
				{
					System.out.println("PB FindALL Avion()"+ex.getMessage());
					
				}
				
				return av;
			}
		
		
		//findAll
		public ArrayList<Avion> findAllAvions()
		{
			ArrayList<Avion> lesAvions=new ArrayList<Avion>();
		try 
			{
				Connection cnx=SConnection.getInstance();
				if (cnx!=null)
				{		String req="select immat, capacite,etatDisponible from avion ";
						PreparedStatement stm =cnx.prepareStatement(req);
						ResultSet rs=stm.executeQuery();
						while (rs.next())
						{
							 Avion av=new Avion(rs.getString("immat"), rs.getString("etatDisponible"),rs.getInt("capacite") );
							 lesAvions.add(av);
						}
				stm.close();
				}
			}catch (SQLException ex)
			{
				System.out.println("PB Find All avion()"+ex.getMessage());
				
			}
			
			return lesAvions;
		}
		//saveAvion
		public void saveAvion (Avion avionToAdd) 
		{
			
			try 
			{
				 Connection cnx=SConnection.getInstance();
				String req ="insert into avion(immat, etatDisponible,capacite) values(?,?,?)";
				PreparedStatement stm=cnx.prepareStatement(req);
				stm.setString(1,avionToAdd.getImmat());
				stm.setString(2,avionToAdd.getEtatDisponible());
				stm.setInt(3,avionToAdd.getCapacite());


				int i=stm.executeUpdate();
				if (i>0)
					System.out.println("ajout effectué avec succes");
				stm.close();	
			}catch (SQLException ex)
			{
				if(ex instanceof SQLIntegrityConstraintViolationException)
				{
					System.out.println("Avion avec le matricule: "+avionToAdd.getImmat() +" existe deja!!!!!!!!!!");
				}
			}
			

		}
		//update Avion 
		public void updateAvion (Avion avionToUpdate,String immatavion) 
		{
			
			try 
			{
				 Connection cnx=SConnection.getInstance();
				String req ="update avion SET etatDisponible=? , capacite=?  where trim(immat)=?";				
				PreparedStatement stm=cnx.prepareStatement(req);
				stm.setString(1,avionToUpdate.getEtatDisponible());
				stm.setInt(2,avionToUpdate.getCapacite());
				stm.setString(3,immatavion);


				int i=stm.executeUpdate();
				if (i>0)
					System.out.println("update effectué avec succes");
				stm.close();	
			}catch (SQLException ex)
			{
				System.out.println(ex);
			}
			

		}
		//delete 
		public void delete(String immatToDelete)
		{
			
			try 
			{
				Connection cnx=SConnection.getInstance();
				String req ="delete from avion where trim(immat)=?";
				PreparedStatement stm=cnx.prepareStatement(req);
				stm.setString(1,immatToDelete);
				int i=stm.executeUpdate();
				if (i>0)
					System.out.println("l'avion avec l'immat :"+immatToDelete+" supprimer avec succes\n");

				stm.close();
			}catch (SQLException e) {
				System.out.println("PB: Delete clienDao\n");
				e.printStackTrace();
			}
			
		}


}
