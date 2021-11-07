package gestionReservation.gestionReservation;

import gestionReservation.gestionReservation.Dao.CompteDao;
import gestionReservation.gestionReservation.entités.Compte;

public class TestCompte {
	public static void main(String[] args)
	{
		Compte cpt =new Compte("yessmine789","utilisateur","alooooo");
		CompteDao cptDao=new CompteDao();
		
		cptDao.updateCompte(cpt,"yessmine@gmail.com");
		//cptDao.deleteCompte("yessmin@gmail.com");
	}
	

}
