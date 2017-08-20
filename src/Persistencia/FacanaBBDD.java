package Persistencia;

import java.util.List;

import Domini.Jugador;

public class FacanaBBDD {

	private static FacanaBBDD facana;

	private JugadorBBDD jugadorBBDD;
	private ClubBBDD clubBBDD;

	// LOGIN USER

	// Cridat a control linia 24
	public void LoginUser(String user, String password) throws Exception {
		ConnectionBBDD.initInstancia(user, password);

		initAtributs();

	}

	public synchronized static FacanaBBDD getInstance() throws Exception {
		if (facana == null)
			facana = new FacanaBBDD();
		return facana;
	}

	private FacanaBBDD() throws Exception {
		super();

	}

	private void initAtributs() throws Exception {
		this.jugadorBBDD = new JugadorBBDD();
		this.clubBBDD = new ClubBBDD();
	}

	// CLUB

	public void afegirClub(String nom) throws Exception {
		clubBBDD.storeClub(nom);
	}

	// JUGADOR

	public void afegirJugador(Jugador jugador) throws Exception {
		jugadorBBDD.storeJugador(jugador);

	}

	public String[] recuperarClubs() throws Exception {

		List<String> clubsRecuperats = clubBBDD.recuperarClubs();
		String[] clubs = new String[clubsRecuperats.size()];
		int contador = 0;
		for (String string : clubsRecuperats) {
			clubs[contador] = string;
			contador++;
		}
		return clubs;
	}

	public List<Jugador> recuperarJugador(String nomEquip) throws Exception {
		return jugadorBBDD.recuperarJugadorDeClub(nomEquip);
	}

	public List<Jugador> jugadorBuscat(String nom, String iCognom) throws Exception {
		return jugadorBBDD.jugadorBuscat(nom, iCognom);
	}

	public List<Jugador> getJugadorsFromActulitzaio(String equip, String poiscio) throws Exception {
		return jugadorBBDD.getJugadorsFromActulitzacion(equip, poiscio);
	}

	public void actuizatrPartitsJugats(String nom, String iCognom, String iIcognom) throws Exception {
		System.out.println("HOLA!");
		jugadorBBDD.actulitzarPartitsJugats(nom, iCognom, iIcognom);

	}

	public void actulitzarTgeogues(String nom, String iCognom, String iIcognom)throws Exception {
		jugadorBBDD.actulitzarTgeogues(nom, iCognom, iIcognom);

		
	}

	public void actulitzarTvarmelles(String nom, String iCognom, String iIcognom) throws Exception {
		jugadorBBDD.actulitzarTvarmelles(nom, iCognom, iIcognom);

		
	}

	public void actulitzarGols(String nom, String iCognom, String iIcognom)  throws Exception {
		jugadorBBDD.actulitzarGols(nom, iCognom, iIcognom);

		
	}
}
