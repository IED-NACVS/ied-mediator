package fr.nacvs.ied_mediator.sources.film_data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.nacvs.ied_mediator.config.PropertiesHandler;

public class DatabaseConnection {
	
	private static Logger LOGGER = LoggerFactory.getLogger(DatabaseConnection.class);

	private String driver;
	private String host;
	private String port;
	private String optionalParams;
	private String username;
	private String password;
	private String dbName;

	private Connection connection;

	public DatabaseConnection() {
		// Init connection from properties file
		PropertiesHandler handler = PropertiesHandler.getInstance();
		driver = handler.getProperty("database.driver");
		host = handler.getProperty("database.host");
		port = handler.getProperty("database.port");
		username = handler.getProperty("database.user");
		password = handler.getProperty("database.password");
		dbName = handler.getProperty("database.name");
		optionalParams = handler.getProperty("database.optional_url_params");
		connection = createConnection();
	}

	private Connection createConnection() {
		try {
			String url = createUrl();
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// Cannot do more here, we have to stop the program
			LOGGER.error("Error while connecting to database : " + e.getMessage());
			throw new RuntimeException(e);
		}
	}

	private String createUrl() {
		return "jdbc:" + driver + "://" + host + ":" + port + "/" + dbName + optionalParams;
	}
	
	public Connection getConnection() {
		return connection;
	}
}
