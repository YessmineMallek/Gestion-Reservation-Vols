package  gestionReservation.gestionReservation.entités;

public class Avion {

	private int capacite;
	private String etatDisponible;
	private String immat;

	public Avion(){

	}

	public Avion(String immat, String etatDisponible, int capacite ) {
		super();
		this.capacite = capacite;
		this.etatDisponible = etatDisponible;
		this.immat = immat;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public String getEtatDisponible() {
		return etatDisponible;
	}

	public void setEtatDisponible(String etatDisponible) {
		this.etatDisponible = etatDisponible;
	}

	public String getImmat() {
		return immat;
	}

	public void setImmat(String immat) {
		this.immat = immat;
	}

	@Override
	public String toString() {
		return "Avion [capacite=" + capacite + ", etatDisponible=" + etatDisponible + ", immat=" + immat + "]\n";
	}



	public Avion( String etatDisponible,int capacite) {
		super();
		this.capacite = capacite;
		this.etatDisponible = etatDisponible;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Avion other = (Avion) obj;
		if (immat == null) {
			if (other.immat != null)
				return false;
		} else if (!immat.equals(other.immat))
			return false; 
		return true;
	}

	
	
	
	
}//end Avion