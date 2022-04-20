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
		driver = handler.getProperty("film_data.database.driver");
		host = handler.getProperty("film_data.database.host");
		port = handler.getProperty("film_data.database.port");
		username = handler.getProperty("film_data.database.user");
		password = handler.getProperty("film_data.database.password");
		dbName = handler.getProperty("film_data.database.name");
		optionalParams = handler.getProperty("film_data.database.optional_url_params");
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
