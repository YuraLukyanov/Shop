package ua.edu.ChaliyLukyanov.laba3.model;

import java.sql.SQLException;
import java.util.List;

public interface DeviceDAO {

	List<Device> getAllDevices() throws SQLException;
	
	Component getDeviceByID(int id) throws SQLException ;
	
	void addDevice(Device device) throws SQLException;
	
	void removeDevice(int id) throws SQLException;
}
