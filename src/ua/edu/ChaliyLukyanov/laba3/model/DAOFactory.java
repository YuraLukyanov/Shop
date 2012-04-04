package ua.edu.ChaliyLukyanov.laba3.model;

import java.sql.Connection;

public abstract class DAOFactory {

	public abstract DeviceDAO getDeviceDAO();

	public abstract ComponentDAO getComponentDAO();

	public static DAOFactory getDAOFactory(Connection conn) {
		return new OracleDAOFactory(conn);
	}
}
