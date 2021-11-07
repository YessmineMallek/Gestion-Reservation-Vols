package gestionReservation.gestionReservation.entités;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement()
public class Aeroport {
	private String nom;

	public Aeroport() {
		super();
	}

	public Aeroport(String nom) {
		super();
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aeroport other = (Aeroport) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}

	

}
