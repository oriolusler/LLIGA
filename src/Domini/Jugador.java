package Domini;

public class Jugador {

	String nom, cognom1, cognom2;
	Club club;
	Posicions posicio;
	int grogues, vermelles, partitsJugats, gols;

	public Jugador() {
	}

	public Jugador(String nom, String cognom1, String cognom2, String club, Posicions posicio, int grogues,
			int vermelles, int partitsJugats, int gols) {
		super();
		this.nom = nom;
		this.cognom1 = cognom1;
		this.cognom2 = cognom2;
		this.club = new Club(club);
		this.posicio = posicio;
		this.grogues = grogues;
		this.vermelles = vermelles;
		this.partitsJugats = partitsJugats;
		this.gols = gols;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCognom1() {
		return cognom1;
	}

	public void setCognom1(String cognom1) {
		this.cognom1 = cognom1;
	}

	public String getCognom2() {
		return cognom2;
	}

	public void setCognom2(String cognom2) {
		this.cognom2 = cognom2;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public Posicions getPosicio() {
		return posicio;
	}

	public void setPosicio(Posicions posicio) {
		this.posicio = posicio;
	}

	public int getGrogues() {
		return grogues;
	}

	public void setGrogues(int grogues) {
		this.grogues = grogues;
	}

	public int getVermelles() {
		return vermelles;
	}

	public void setVermelles(int vermelles) {
		this.vermelles = vermelles;
	}

	public int getPartitsJugats() {
		return partitsJugats;
	}

	public void setPartitsJugats(int vermelles) {
		this.vermelles = vermelles;
	}

	public int getGols() {
		return gols;
	}

	public void setGols(int gols) {
		this.gols = gols;
	}

	@Override
	public String toString() {
		return nom + "," + cognom1 + "," + cognom2 + "," + club.getNomClub() + "," + posicio + "," + grogues + ","
				+ vermelles + "," + partitsJugats + "," + gols;
	}

}
