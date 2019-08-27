package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtility {

	public static ResultSet executeQuery(Connection con, String query) {
		ResultSet rs = null;
		try {
			Statement state = con.createStatement();
			rs = state.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public static String printEntireRS(ResultSet rs) {
		String str;
		ResultSetMetaData rsmd;

		try {
			rsmd = rs.getMetaData();
			while (rs.next()) {
				str = ": ";
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					str = str + (rs.getString(i) + " : ");
				}
				return str;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Nothing here!";
	}

	public static boolean executeUpdate(Connection con, String query) {
		Statement state;
		try {
			state = con.createStatement();
			System.out.println(state.executeUpdate(query) + " Rows  affected.");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public static void useDB(Connection con, String database) {
		try {
			con.setCatalog(database);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
