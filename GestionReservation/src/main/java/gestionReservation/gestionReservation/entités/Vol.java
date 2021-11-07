package gestionReservation.gestionReservation.entités;

import java.time.LocalDate;

public class Vol {

	private int code; 
	private LocalDate dateArrivee; 
	private LocalDate dateDepart; 
	private int  etat;//0:annulée , 1:confirmée
	private Aeroport aeroportDepart;
	private Aeroport aeroportArrive;
	private Avion avion_vol;

	public Vol() {
		super();
	}
	public Vol(int code, LocalDate dateArrivee, LocalDate dateDepart, int etat) {
		super();
		this.code = code;
		this.dateArrivee = dateArrivee;
		this.dateDepart = dateDepart;
		this.etat = etat;
		
	}
	
	public Vol(int code, LocalDate dateArrivee, LocalDate dateDepart) {
		super();
		this.code = code;
		this.dateArrivee = dateArrivee;
		this.dateDepart = dateDepart;
	}
	
	public Vol(int code, LocalDate dateArrivee, LocalDate dateDepart,  int etat,Aeroport aeroportDepart,
			Aeroport aeroportArrive,Avion av) {
		super();
		this.code = code;
		this.dateArrivee = dateArrivee;
		this.dateDepart = dateDepart;
		this.etat = etat;

		this.aeroportDepart = aeroportDepart;
		this.aeroportArrive = aeroportArrive;
		this.avion_vol=av;
	}
	
	
	
	
	public Avion getAvion_vol() {
		return avion_vol;
	}
	public void setAvion_vol(Avion avion_vol) {
		this.avion_vol = avion_vol;
	}
	public Aeroport getAeroportDepart() {
		return aeroportDepart;
	}
	public void setAeroportDepart(Aeroport aeroportDepart) {
		this.aeroportDepart = aeroportDepart;
	}
	public Aeroport getAeroportArrive() {
		return aeroportArrive;
	}
	public void setAeroportArrive(Aeroport aeroportArrive) {
		this.aeroportArrive = aeroportArrive;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public LocalDate getDateArrivee() {
		return dateArrivee;
	}
	public void setDateArrivee(LocalDate dateArrivee) {
		this.dateArrivee = dateArrivee;
	}
	public LocalDate getDateDepart() {
		return dateDepart;
	}
	public void setDateDepart(LocalDate dateDepart) {
		this.dateDepart = dateDepart;
	}
	
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	
	
	@Override
	public String toString() {
		return "Vol [code=" + code + ", dateArrivee=" + dateArrivee + ", dateDepart=" + dateDepart + ", etat=" + etat
				+ ", aeroportDepart=" + aeroportDepart + ", aeroportArrive=" + aeroportArrive + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vol other = (Vol) obj;
		if (code != other.code)
			return false;
		return true;
	}
	
	
	
}
