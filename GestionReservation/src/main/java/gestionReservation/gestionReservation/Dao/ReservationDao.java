package gestionReservation.gestionReservation.Dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

import gestionReservation.gestionReservation.entités.Reservation;

public class ReservationDao {
	

	public ArrayList<Reservation> findAll()
	{
		ArrayList<Reservation>  lesRes=new ArrayList<Reservation> ();
		try 
		{
			Connection cnx=SConnection.getInstance();
			System.out.println(cnx);
			if (cnx!=null)
			{		String req="select numero ,date ,client ,confirmee from reservation";
					PreparedStatement stm =cnx.prepareStatement(req);
				
					ResultSet rs=stm.executeQuery();
					Reservation res=null;
					while (rs.next())
					{
						String num=rs.getString("numero");
						LocalDate time=rs.getObject("date",LocalDate.class);
						String client=rs.getString("client");
						int conf=rs.getInt("confirmee");
						res=new Reservation();
						res.setNumero(num);
						res.setDate(time);
						res.setClient(client);
						res.setConfirmee(conf);
						lesRes.add(res);
					}
			stm.close();
			}
		}catch (SQLException ex)
		{
			System.out.println(ex.getMessage());
			
		}
		
		return lesRes;
	}
	//findByNumero
	public ArrayList<Reservation> findAllByNumero(String numero)
	{
		ArrayList<Reservation>  lesRes=new ArrayList<Reservation> ();
		try 
		{
			Connection cnx=SConnection.getInstance();
			System.out.println(cnx);
			if (cnx!=null)
			{		String req="select numero ,date ,client ,confirmee from reservation where numero=?";
					PreparedStatement stm =cnx.prepareStatement(req);
					stm.setString(1, numero);
					
					ResultSet rs=stm.executeQuery();
					Reservation res=null;
					while (rs.next())
					{
						String num=rs.getString("numero");
						LocalDate time=rs.getObject("date",LocalDate.class);
						String client=rs.getString("client");
						int conf=rs.getInt("confirmee");
						res=new Reservation();
						res.setNumero(num);
						res.setDate(time);
						res.setClient(client);
						res.setConfirmee(conf);
						lesRes.add(res);
					}
			stm.close();
			}
		}catch (SQLException ex)
		{
			System.out.println(ex.getMessage());
			
		}
		
		return lesRes;
	}
	
	public void save (Reservation res) 
	{
		
		try 
		{
			 Connection cnx=SConnection.getInstance();
			
			String req ="insert into reservation(numero,date,client) values(?,?,?)";
			
			PreparedStatement stm=cnx.prepareStatement(req);
			stm.setString(1,res.getNumero());
			stm.setObject(2, res.getDate());
			stm.setString(3, res.getClient());
			int i=stm.executeUpdate();
			if (i>0)
				System.out.println("ajout effectué avec succes");
			stm.close();	
		}catch (SQLException ex)
		{
			if(ex instanceof SQLIntegrityConstraintViolationException)
			{
				System.out.println("Reservation numero : "+res.getNumero() +" existe deja!!!!!!!!!!");
			}
		}
		

	}
	
	public void update(Reservation resToUdate,String num)
	{
		Connection cnx=SConnection.getInstance();
		try
		{
			String req ="update reservation SET date =? , client=? ,confirmee=? where trim(numero)=?";
			PreparedStatement stm=cnx.prepareStatement(req);
			stm.setObject(1, resToUdate.getDate());
			stm.setString(2,resToUdate.getClient());
			stm.setInt(3,resToUdate.getConfirmee());
			stm.setString(4,num);

			int i=stm.executeUpdate();
			if (i>0)
				System.out.println("******Update effectué avec succes\n");
			stm.close();

		}catch (Exception ex)
		{
			System.out.println("Pb in Update \n"+ex);
		}
		
		
		
		
	}
	public void delete(String numToDel)
	{
		
		try 
		{
			Connection cnx=SConnection.getInstance();
			String req ="delete from reservation where trim(numero)=?";
			PreparedStatement stm=cnx.prepareStatement(req);
			stm.setString(1,numToDel);
			int i=stm.executeUpdate();
			if (i>0)
				System.out.println("la reservation numero :"+numToDel+" supprimer avec succes\n");

			stm.close();
		}catch (SQLException e) {
			System.out.println("PB: Delete clienDao\n");
			e.printStackTrace();
		}
		
	}

}
