package ville.bean;

public class VilleFrance {

	private String codeINSEE;
	private String nom;
	private String codePostal;
	private String libelleAcheminement;
	private String ligne_5;
	private String latitude;
	private String longitude;
	
	public VilleFrance() {
		super();
	}

	public VilleFrance(String codeINSEE, String nom, String codePostal, String libelleAcheminement, String ligne_5,
			String latitude, String longitude) {
		super();
		this.codeINSEE = codeINSEE;
		this.nom = nom;
		this.codePostal = codePostal;
		this.libelleAcheminement = libelleAcheminement;
		this.ligne_5 = ligne_5;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getCodeINSEE() {
		return codeINSEE;
	}
	
	public void setCodeINSEE(String codeINSEE) {
		this.codeINSEE = codeINSEE;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getCodePostal() {
		return codePostal;
	}
	
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	
	public String getLibelleAcheminement() {
		return libelleAcheminement;
	}
	
	public void setLibelleAcheminement(String libelleAcheminement) {
		this.libelleAcheminement = libelleAcheminement;
	}
	
	public String getLigne_5() {
		return ligne_5;
	}
	
	public void setLigne_5(String ligne_5) {
		this.ligne_5 = ligne_5;
	}
	
	public String getLatitude() {
		return latitude;
	}
	
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public String getLongitude() {
		return longitude;
	}
	
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	@Override
	public String toString() {
		return "VilleFrance [codeINSEE=" + codeINSEE + ", nom=" + nom + ", codePostal=" + codePostal
				+ ", libelleAcheminement=" + libelleAcheminement + ", ligne_5=" + ligne_5 + ", latitude=" + latitude
				+ ", longitude=" + longitude + "]";
	}
	
	
}
