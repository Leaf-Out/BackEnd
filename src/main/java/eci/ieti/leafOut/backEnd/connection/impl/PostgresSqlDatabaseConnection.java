package eci.ieti.leafout.backEnd.connection.impl;

import eci.ieti.leafout.backEnd.connection.SqlDatabaseConnection;
import org.springframework.stereotype.Service;

import java.sql.Connection;

@Service
public class PostgresSqlDatabaseConnection implements SqlDatabaseConnection {

	@Override public Connection getConnection() {

		return null;
	}

	@Override public void closeConnection(Connection connection) {

	}
}
