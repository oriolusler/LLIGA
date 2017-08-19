package Persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Domini.Club;
import Domini.Jugador;
import Domini.Posicions;

class JugadorBBDD {

	void storeJugador(Jugador jugador) throws Exception {

		PreparedStatement pst = null;
		try {
			String sql = "INSERT INTO JUGADOR VALUES(?,?,?,?,?,?,?,?)";
			pst = ConnectionBBDD.getInstacia().prepareStatement(sql);
			pst.setString(1, jugador.getNom());
			pst.setString(2, jugador.getCognom1());
			pst.setString(3, jugador.getCognom2());
			pst.setString(4, jugador.getClub().getNomClub());
			pst.setString(5, jugador.getPosicio().name());
			pst.setInt(6, jugador.getGrogues());
			pst.setInt(7, jugador.getVermelles());
			pst.setInt(8, jugador.getPartitsJugats());
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new Exception("ERROR de SQL/JUGADORBBDD/storeJugador\n" + e.getMessage());
		} catch (Exception e) {
			throw new Exception("ERROR de CLASS/JUGADORBBDD/storeJugador\n" + e.getMessage());
		} finally {
			if (pst != null)
				pst.close();
			ConnectionBBDD.getInstacia().close();
		}

	}

	Jugador getJugadorFromDB(Jugador jugador) throws Exception {

		Jugador jugadorRecuperat;
		PreparedStatement pst = null;
		try {
			String sql = "SELECT * FROM JUGADOR WHERE NOMJUGADOR = ? AND !COGNOM_ = ?";
			pst = ConnectionBBDD.getInstacia().prepareStatement(sql);
			pst.clearParameters();
			pst.setString(1, jugador.getNom());
			pst.setString(2, jugador.getCognom1());
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				return jugador;
			}
		} catch (SQLException e) {
			throw new Exception("ERROR de SQL/JUGADORBBDD/getJugadorFromDB\n" + e.getMessage());
		} catch (Exception e) {
			throw new Exception("ERROR de CLASS/JUGADORBBDD/getJugadorFromDB\n" + e.getMessage());
		} finally {
			if (pst != null)
				pst.close();
			ConnectionBBDD.getInstacia().close();
		}

		return null;

	}

	public List<Jugador> recuperarJugadorDeClub(String nomClub) throws Exception {
		List<Jugador> jugadorsEquips = new ArrayList<Jugador>();
		PreparedStatement pst = null;
		try {
			String sql = "SELECT * FROM JUGADOR WHERE NOMCLUB = ?";
			pst = ConnectionBBDD.getInstacia().prepareStatement(sql);
			pst.clearParameters();
			pst.setString(1, nomClub);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				Posicions posicio = null;
				switch (rs.getString(5)) {
				case "POT":
					posicio = Posicions.POT;
					break;
				case "DF":
					posicio = Posicions.DF;
					break;

				case "MC":
					posicio = Posicions.MC;
					break;
				case "DL":
					posicio = Posicions.DL;
					break;

				}

				Jugador nou = new Jugador(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						posicio, rs.getInt(6), rs.getInt(7), rs.getInt(8));

				jugadorsEquips.add(nou);
			}
			return jugadorsEquips;
		} catch (SQLException e) {
			throw new Exception("ERROR de SQL/JUGADORBBDD/getJugadorFromDB\n" + e.getMessage());
		} catch (Exception e) {
			throw new Exception("ERROR de CLASS/JUGADORBBDD/getJugadorFromDB\n" + e.getMessage());
		} finally {
			if (pst != null)
				pst.close();
			ConnectionBBDD.getInstacia().close();
		}
	}

}
