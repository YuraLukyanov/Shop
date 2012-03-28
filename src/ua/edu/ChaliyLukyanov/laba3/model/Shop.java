package ua.edu.ChaliyLukyanov.laba3.model;

import java.sql.SQLException;
import java.util.List;

public interface Shop {

	List<Device> getAllDevices() throws SQLException;
	List<Device> getAllComponents();
	void addDevice(Device device);
	void addComponent(Component component);
	Device getDeviceByID(int id);
	Component getComponentByID(int id);
	void removDevice(int id);
	void removeComponent(int id);
}
