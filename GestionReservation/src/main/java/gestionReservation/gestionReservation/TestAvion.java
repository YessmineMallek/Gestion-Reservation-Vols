package gestionReservation.gestionReservation;

import gestionReservation.gestionReservation.Dao.AvionDao;
import gestionReservation.gestionReservation.entités.Avion;

public class TestAvion {
	public static void main(String[]args)
	{
		AvionDao av=new AvionDao();
		Avion a1=new Avion("123TN2021","disponible",12);
		av.saveAvion(a1);
		System.out.println(av.findAllAvions());
		Avion a2=new Avion("345TN2021","disponible",12);
		av.saveAvion(a2);
		System.out.println(av.findAllAvions());
		Avion a3=new Avion("Non disponible",12);

		av.updateAvion(a3, "345TN2021");
		av.delete("345TN2021");
	}

}
