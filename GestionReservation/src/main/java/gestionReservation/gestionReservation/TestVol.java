package gestionReservation.gestionReservation;

import java.time.LocalDate;

import gestionReservation.gestionReservation.Dao.VolDao;
import gestionReservation.gestionReservation.controller.VolController;
import gestionReservation.gestionReservation.entités.Vol;

public class TestVol {

	public static void main(String[]args)
	{
		VolController vol=new VolController(); 
		
		Vol v1=new Vol(1,LocalDate.of(2021, 6, 17),LocalDate.of(2020, 6, 18),1);
		//vol.ajouterVol(v1);
		//vol.modifierVol(v1,1);
		Vol v2=new Vol(2,LocalDate.of(2021, 6, 18),LocalDate.of(2021, 6, 18));
		Vol v3=new Vol(3,LocalDate.of(2021, 6, 19),LocalDate.of(2021, 6, 18));
		//vol.ajouterVol(v2);
		//vol.ajouterVol(v3);
		vol.modifierVol(v1,1);
		vol.supprimerVol(2);



	}
}
