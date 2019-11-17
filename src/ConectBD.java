
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConectBD {

		public static Connection conect() throws SQLException {

			try {

				Class.forName("com.mysql.jdbc.Driver");

				return DriverManager.getConnection("jdbc:mysql://localhost/bd_desafio", "root", "12345");

			} catch (ClassNotFoundException e) {

				throw new SQLException(e.getException());

			}

		}

	}


