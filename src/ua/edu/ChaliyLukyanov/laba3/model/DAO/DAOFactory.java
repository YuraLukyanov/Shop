package ua.edu.ChaliyLukyanov.laba3.model.DAO;

public abstract class DAOFactory {

	public abstract DeviceDAO getDeviceDAO();

	public abstract ComponentDAO getComponentDAO();

	public static DAOFactory getDAOFactory() {
		return new OracleDAOFactory();
	}
}
