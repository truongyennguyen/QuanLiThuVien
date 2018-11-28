package QuanLyThuVien.model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class connect xuống dưới MySql. Method: openConnection và
 * closeConnection.
 * 
 * @author param: jdbcURL, jdbcUsername, jdbcPassword bên file web.xml
 */
public class ConnectDatabase {

	protected String jdbcURL;
	protected String jdbcUsername;
	protected String jdbcPassword;
	protected Connection jdbcConnection;

	public ConnectDatabase(String jdbcURL) throws SQLException {
		this.jdbcURL = jdbcURL;
	}

	protected void openConnection() throws SQLException, ClassNotFoundException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(jdbcURL);
		}
	}

	protected void closeConnection() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}
}