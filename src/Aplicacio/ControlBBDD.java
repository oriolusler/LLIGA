package Aplicacio;

import Domini.Club;
import Domini.Jugador;
import Domini.Posicions;
import Persistencia.FacanaBBDD;

public class ControlBBDD {

	// private Map<Integer, Date> partidesRecuperades;
	// private Club club;
	// private Jugador jugador;

	public ControlBBDD() {
		// jugador = new Jugador();
		// club = new Club();
	}

	//
	// LOGIN
	// Presentacio/UserLoginBBDD
	public void logIn(String user, String password) throws Exception {
		FacanaBBDD.getInstance().LoginUser(user, password);
	}

	public void afegirClub(String nom) throws Exception {
		FacanaBBDD.getInstance().afegirClub(nom);

	}

	public String[] recuperarClubs() throws Exception {
		return FacanaBBDD.getInstance().recuperarClubs();
	}

	public void afegirJugador(String nom, String cognom1, String cognom2, String club, String posicio)
			throws Exception {
		Club cluba = new Club(club);
		Posicions a = null;
		switch (posicio) {

		case "POT":
			a = Posicions.POT;
			break;

		case "DF":
			a = Posicions.DF;
			break;
		case "MC":
			a = Posicions.MC;
			break;
		case "DL":
			a = Posicions.DL;
			break;

		}
		Jugador jugador = new Jugador(nom, cognom1, cognom2, cluba, a, 0, 0, 0);
		FacanaBBDD.getInstance().afegirJugador(jugador);

	}

}
