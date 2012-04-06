package ua.edu.ChaliyLukyanov.laba3.model.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Locale;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class OracleDAOFactory extends DAOFactory {

	@Override
	public DeviceDAO getDeviceDAO() {
		return new OracleDeviceDAO();
	}

	@Override
	public ComponentDAO getComponentDAO() {
		return new OracleComponentDAO();
	}
	
	public static Connection createConnection() throws SQLException {
		try{
			Context cont = (Context) new InitialContext().lookup("java:comp/env");
			Locale.setDefault(Locale.ENGLISH);
			DataSource ds = (DataSource) cont.lookup("jdbc/shop");
			return ds.getConnection();
		}catch(Exception e){
			throw new SQLException(e);
		}
	}

}
