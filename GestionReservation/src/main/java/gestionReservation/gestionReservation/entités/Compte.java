package gestionReservation.gestionReservation.entités;

public class Compte {
	private String email;
	private String nomUtilisateur ; 
	private String role; 
	private String motDePasse;
	public Compte(String email, String nomUtilisateur, String role, String password) {
		super();
		this.email = email;
		this.nomUtilisateur = nomUtilisateur;
		this.role = role;
		this.motDePasse = password;
	}
	public Compte() {
		super();
	}
	
	public Compte(String nomUtilisateur, String role, String password) {
		super();
		this.nomUtilisateur = nomUtilisateur;
		this.role = role;
		this.motDePasse = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compte other = (Compte) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Compte [email=" + email + ", nomUtilisateur=" + nomUtilisateur + ", role=" + role + ", password="
				+ motDePasse + "]";
	}
	
	
	
	
	

}
