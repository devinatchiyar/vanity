package com.salon.vanity.model;

public class ConnectionProp {

	private String dbDriver;
	private String dbConnectionURL;
	private String dbUser;
	private String dbPassword;

	public String getDbDriver() {
		return dbDriver;
	}

	public void setDbDriver(String dbDriver) {
		this.dbDriver = dbDriver;
	}

	public String getDbConnectionURL() {
		return dbConnectionURL;
	}

	public void setDbConnectionURL(String dbConnectionURL) {
		this.dbConnectionURL = dbConnectionURL;
	}

	public String getDbUser() {
		return dbUser;
	}

	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	@Override
	public String toString() {
		return "ConnectionProp [dbDriver=" + dbDriver + ", dbConnectionURL=" + dbConnectionURL + ", dbUser=" + dbUser
				+ ", dbPassword=" + dbPassword + "]";
	}

}
