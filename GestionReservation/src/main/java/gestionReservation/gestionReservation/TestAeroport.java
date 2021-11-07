package gestionReservation.gestionReservation;

import gestionReservation.gestionReservation.Dao.AeroportDao;
import gestionReservation.gestionReservation.entités.Aeroport;

public class TestAeroport {

	public static void main(String[]args )
	{
		AeroportDao aerDb=new AeroportDao();
		Aeroport ae=new Aeroport("sfax");
		aerDb.saveAeroport(ae);
		Aeroport a2=new Aeroport("tunis");
		aerDb.saveAeroport(a2);
		System.out.println(aerDb.findAllAeroport());
		aerDb.deleteAeroport("tunis");
		System.out.println(aerDb.findAllAeroport());


	}
}
