package ua.edu.ChaliyLukyanov.laba3.model;

import java.sql.Connection;

public class OracleDAOFactory extends DAOFactory {

	private Connection conn = null;
	
	public OracleDAOFactory(Connection conn){
		this.conn = conn;
	}
	@Override
	public DeviceDAO getDeviceDAO() {
		return new OracleDeviceDAO(conn);
	}

	@Override
	public ComponentDAO getComponentDAO() {
		return new OracleComponentDAO(conn);
	}

}
