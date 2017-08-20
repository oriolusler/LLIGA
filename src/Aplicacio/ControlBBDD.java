package Aplicacio;

import java.util.List;

import Domini.Club;
import Domini.Jugador;
import Domini.Posicions;
import Persistencia.FacanaBBDD;

public class ControlBBDD {

	// private Map<Integer, Date> partidesRecuperades;
	// private Club club;
	// private Jugador jugador;

	String[] equips;

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
		Jugador jugador = new Jugador(nom, cognom1, cognom2, club, a, 0, 0, 0, 0);
		FacanaBBDD.getInstance().afegirJugador(jugador);

	}

	public String[] getJugadorsDeEquip(String nomClub) throws Exception {
		List<Jugador> jugador = FacanaBBDD.getInstance().recuperarJugador(nomClub);
		String[] jugadors = new String[jugador.size()];

		int contador = 0;
		for (Jugador jug : jugador) {
			jugadors[contador] = jug.toString();
			contador++;
		}

		return jugadors;

	}

	public String[] getJugadorBuscat(String nom, String iCognom) throws Exception {
		List<Jugador> jugadors = FacanaBBDD.getInstance().jugadorBuscat(nom, iCognom);
		String[] jugadors1 = new String[jugadors.size()];

		int contador = 0;
		for (Jugador jug : jugadors) {
			jugadors1[contador] = jug.toString();
			contador++;
		}

		return jugadors1;

	}

	public String[] getJugadorsFromAcctualitzacio(String equip, String poiscio) throws Exception {

		List<Jugador> jugadors = FacanaBBDD.getInstance().getJugadorsFromActulitzaio(equip, poiscio);
		String[] jugadors1 = new String[jugadors.size()];

		int contador = 0;
		for (Jugador jug : jugadors) {
			jugadors1[contador] = jug.toString();
			contador++;
		}

		return jugadors1;
	}

	public void actulitzarPartitsJugats(String nom, String ICognom, String IIcognom) throws Exception {
	
		FacanaBBDD.getInstance().actuizatrPartitsJugats(nom, ICognom, IIcognom);

	}

	public void actulitzarTgeogues(String nom, String ICognom, String IIcognom) throws Exception {
		FacanaBBDD.getInstance().actulitzarTgeogues(nom, ICognom, IIcognom);

	}

	public void actulitzarTvarmelles(String nom, String ICognom, String IIcognom) throws Exception {
		FacanaBBDD.getInstance().actulitzarTvarmelles(nom, ICognom, IIcognom);

	}

	public void actulitzarGols(String nom, String ICognom, String IIcognom) throws Exception {
		FacanaBBDD.getInstance().actulitzarGols(nom, ICognom, IIcognom);

	}

}
