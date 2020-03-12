package eci.ieti.leafout.backEnd.connection;

import java.sql.Connection;

/**
 * This interface defines the methods used to manage database connections
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
public interface SqlDatabaseConnection {

	Connection getConnection();

	void closeConnection(Connection connection);

}
