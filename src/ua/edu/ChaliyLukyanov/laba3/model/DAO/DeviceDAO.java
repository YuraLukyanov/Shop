package ua.edu.ChaliyLukyanov.laba3.model.DAO;

import java.util.List;

import ua.edu.ChaliyLukyanov.laba3.model.Device;

public interface DeviceDAO {

	List<Device> getAllDevices();
	
	Device getDeviceByID(int id);
	
	void addDevice(Device device);
	
	void removeDevice(int id);
	
	List<Device> getPrevLevelsDeviceByID(int id);
	
	List<Device> getNextLevelsDeviceByID(int id);
	
	List<Device> getFirstLevelsDeviceByID(int id);
	
	int getIdLastDevice();
}
