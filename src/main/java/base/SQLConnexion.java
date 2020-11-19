package base;

import java.sql.*;

import common.Constantes;

public class SQLConnexion {
	public static Connection connection = null;
	
	public static Connection getConnect() {
		try {
			if (connection == null || connection.isClosed()) {
				new SQLConnexion();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
	
	private SQLConnexion() {
		try {
			
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:" + Constantes.sqliteFilePath);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
