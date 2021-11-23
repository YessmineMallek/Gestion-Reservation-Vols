package gestionReservation.gestionReservation.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import gestionReservation.gestionReservation.entités.Aeroport;

public class AeroportDao {

	//findAll()
		public List<Aeroport> findAllAeroport()
		{
			List<Aeroport>  lesAeroports=new ArrayList<Aeroport> ();
			try 
			{
				Connection cnx=SConnection.getInstance();
				if (cnx!=null)
				{		String req="select nom from aeroport";
						PreparedStatement stm =cnx.prepareStatement(req);
						ResultSet rs=stm.executeQuery();
						while (rs.next())
						{
							String nom=rs.getString("nom");
							
							Aeroport a1=new Aeroport(nom);
							lesAeroports.add(a1);
						}
				stm.close();
				}
			}catch (SQLException ex)
			{
				System.out.println("PB Find All aeroport()"+ex.getMessage());
				
			}
			
			return lesAeroports;
		}
		//findAll()
				public List<Aeroport> findAllAeroportByName(String nomToSearch)
				{
					List<Aeroport>  lesAeroports=new ArrayList<Aeroport> ();
					try 
					{
						Connection cnx=SConnection.getInstance();
						if (cnx!=null)
						{		String req="select nom from aeroport where nom=?";
								PreparedStatement stm =cnx.prepareStatement(req);
								stm.setString(1, nomToSearch);
								
								ResultSet rs=stm.executeQuery();
								while (rs.next())
								{
									String nom=rs.getString("nom");
									Aeroport a1=new Aeroport(nom);
									lesAeroports.add(a1);
								}
						stm.close();
						}
					}catch (SQLException ex)
					{
						System.out.println("PB Find All aeroport()"+ex.getMessage());
						
					}
					
					return lesAeroports;
				}
		//saveAeroport
	
		public void saveAeroport (Aeroport aeroportToAdd) 
		{
			
			try 
			{
				 Connection cnx=SConnection.getInstance();
				String req ="insert into aeroport(nom) values(?)";
				PreparedStatement stm=cnx.prepareStatement(req);
				stm.setString(1,aeroportToAdd.getNom());
				int i=stm.executeUpdate();
				if (i>0)
					System.out.println("ajout effectué avec succes");
				stm.close();	
			}catch (SQLException ex)
			{
				if(ex instanceof SQLIntegrityConstraintViolationException)
				{
					System.out.println("aeroport avec le nom: "+aeroportToAdd.getNom() +" existe deja!!!!!!!!!!");
				}
			}
			

		}
		//delete
		public void deleteAeroport(String nomToDelete)
		{
			try 
			{
				Connection cnx=SConnection.getInstance();
				String req ="delete from aeroport where trim(nom)=?";
				PreparedStatement stm=cnx.prepareStatement(req);
				stm.setString(1,nomToDelete);
				int i=stm.executeUpdate();
				if (i>0)
					System.out.println("l'aeroport avec le nom:"+nomToDelete+" supprimer avec succes\n");

				stm.close();
			}catch (SQLException e) {
				System.out.println("PB: Delete aeroportDao\n");
				e.printStackTrace();
			}
			
		}
}
