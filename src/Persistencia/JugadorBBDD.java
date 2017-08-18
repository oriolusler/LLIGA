package Persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Domini.Jugador;

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

}
