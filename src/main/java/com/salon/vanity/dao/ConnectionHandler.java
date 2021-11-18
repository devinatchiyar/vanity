
package com.salon.vanity.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.salon.vanity.model.ConnectionProp;


public class ConnectionHandler {

	public static Connection getConnection() {

		Connection conn = null;
		ConfigurableApplicationContext context = null;
		try {

			String confFile = "spring-config.xml";

			context = new ClassPathXmlApplicationContext(confFile);

			ConnectionProp connectionprop = (ConnectionProp) context.getBean("dbConfig");

			String dbDriverName = connectionprop.getDbDriver();
			String jdbcUrl = connectionprop.getDbConnectionURL();
			String dbUserName = connectionprop.getDbUser();
			String dbPassword = connectionprop.getDbPassword();

			Class.forName(dbDriverName);
			conn = DriverManager.getConnection(jdbcUrl, dbUserName, dbPassword);
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		}

		return conn;
	}

}
