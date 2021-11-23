package gestionReservation.gestionReservation.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;

import gestionReservation.gestionReservation.entités.Compte;

public class CompteDao {
	
	//encrypt & decrypt password
	private static String getEncodedPassowrd(String password)
	{
		return Base64.getEncoder().encodeToString(password.getBytes());
	}
	//decryption 
	private static String getDecoderString (String passwordToDecrypt)
	{
		return new String(Base64.getMimeDecoder().decode(passwordToDecrypt));
	}
	//findAllComptes
	public ArrayList<Compte> findAllComptes()
	{
		ArrayList<Compte>  lesComptes=new ArrayList<Compte> ();
		try 
		{
			Connection cnx=SConnection.getInstance();
			if (cnx!=null)
			{		String req="select email ,motDePasse ,nomUtilisateur,role from comptes";
					PreparedStatement stm =cnx.prepareStatement(req);
				
					ResultSet rs=stm.executeQuery();
					Compte cpt=null;
					while (rs.next())
					{
						String email=rs.getString("email");
						String motDe=rs.getString("motDePasse");
						String nomUtili=rs.getString("nomUtilisateur");
						String role=rs.getString("role");
						cpt=new Compte(email,nomUtili,role,motDe);
						
						lesComptes.add(cpt);
					}
			stm.close();
			}
		}catch (SQLException ex)
		{
			System.out.println(ex.getMessage());	
		}
		
		return lesComptes;
	}
	//findAllComptesByEmail
	public ArrayList<Compte> findAllCompteByEmail(String emailToSearch)
	{
		System.out.println(emailToSearch);
		ArrayList<Compte>  lesComptes=new ArrayList<Compte> ();
		try 
		{
			Connection cnx=SConnection.getInstance();
			if (cnx!=null)
			{		String req="select email ,motDePasse ,nomUtilisateur,role from comptes where trim(email)=?";
					PreparedStatement stm =cnx.prepareStatement(req);
					stm.setString(1, emailToSearch);
					ResultSet rs=stm.executeQuery();
					Compte cpt=null;
					while (rs.next())
					{
						String email=rs.getString("email");
						String motDe=rs.getString("motDePasse");
						String nomUtili=rs.getString("nomUtilisateur");
						String role=rs.getString("role");
						cpt=new Compte(email,nomUtili,role,motDe);
						
						lesComptes.add(cpt);
					}
			stm.close();
			}
		}catch (SQLException ex)
		{
			System.out.println(ex.getMessage());	
		}
		
		return lesComptes;
	}
	//SaveComptes
	public void saveCompte(Compte cpt)
	{
		try 
		{
			 Connection cnx=SConnection.getInstance();
		
			String req ="insert into comptes(email,motDePasse,nomUtilisateur,role) values(?,?,?,?)";
			System.out.println(cpt);
			PreparedStatement stm=cnx.prepareStatement(req);
			stm.setString(1, cpt.getEmail());
			//encrypter le password
			String encodedPassword=CompteDao.getEncodedPassowrd(cpt.getMotDePasse());
			System.out.println("password Encrypter"+encodedPassword);
			stm.setString(2, encodedPassword);
			stm.setString(3, cpt.getNomUtilisateur());
			stm.setString(4, cpt.getRole());
			
			int i=stm.executeUpdate();
			if (i>0)
			{
				System.out.println("ajout effectué avec succes");
			}
			stm.close();	
		}catch (SQLException ex)
		{
			if(ex instanceof SQLIntegrityConstraintViolationException)
			{
				System.out.println("Reservation numero : "+cpt.getNomUtilisateur() +" existe deja!!!!!!!!!!");
			}
			System.out.println(ex);
		}
	
	}
	
	//Modifier compte
	public void updateCompte(Compte NewcptToModifie,String email)
	{
		try
		{
			Connection cnx=SConnection.getInstance();
			String req ="update comptes SET nomUtilisateur=? , motDePasse=? ,role=? where trim(email)=?";
			
			PreparedStatement stm=cnx.prepareStatement(req);
			stm.setString(1, NewcptToModifie.getNomUtilisateur());
			String encodedPassword=CompteDao.getEncodedPassowrd(NewcptToModifie.getMotDePasse());
			stm.setString(2,encodedPassword);
			stm.setString(3, NewcptToModifie.getRole());
			stm.setString(4,email);
			

			int i=stm.executeUpdate();
			if (i>0)
			{	
				System.out.println("******Update effectué avec succes\n");
			}
			

		}catch (Exception ex)
		{
			System.out.println("Pb in Update \n"+ex);
		}

		
	}
	
	//delete compte
	public void deleteCompte (String email)
	{
		try 
		{
			Connection cnx=SConnection.getInstance();
			String req ="delete from comptes where trim(email)=?";
			PreparedStatement stm=cnx.prepareStatement(req);
			stm.setString(1,email);
			int i=stm.executeUpdate();
			if (i>0)
				System.out.println("la compte avec l' :"+ email +" supprimer avec succes\n");

			stm.close();
		}catch (SQLException e) {
			System.out.println("PB: Delete clienDao\n");
			e.printStackTrace();
		}
	}
	
	
	
	
}
