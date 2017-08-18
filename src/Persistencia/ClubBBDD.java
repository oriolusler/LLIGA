package Persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Domini.Club;

class ClubBBDD {

	void storeClub(String nom) throws Exception {

		PreparedStatement pst = null;
		try {
			String sql = "INSERT INTO CLUB VALUES(?)";
			pst = ConnectionBBDD.getInstacia().prepareStatement(sql);
			pst.setString(1, nom);
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

	Club getJugadorFromDB(String nom) throws Exception {

		PreparedStatement pst = null;
		try {
			String sql = "SELECT * FROM CLUB WHERE NOMCLUB = ?";
			pst = ConnectionBBDD.getInstacia().prepareStatement(sql);
			pst.clearParameters();
			pst.setString(1, nom);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				return new Club(nom);
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

	public String[] recuperarClubs() throws Exception {
		String[] clubs = new String[50];
		PreparedStatement pst = null;
		try {
			String sql = "SELECT * FROM CLUB";
			pst = ConnectionBBDD.getInstacia().prepareStatement(sql);
			pst.clearParameters();
			ResultSet rs = pst.executeQuery();
			int contador = 0;
			while (rs.next()) {
				clubs[contador] = rs.getString(1);
				contador++;
			}
			return clubs;
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
