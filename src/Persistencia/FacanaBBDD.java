package Persistencia;

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
	public Jugador getJugadorFromDB(Jugador jugador) throws Exception {
		return jugadorBBDD.getJugadorFromDB(jugador);
	}

	public void afegirJugador(Jugador jugador) throws Exception {
		jugadorBBDD.storeJugador(jugador);

	}

	public String[] recuperarClubs() throws Exception {
		return clubBBDD.recuperarClubs();
	}

	
}
