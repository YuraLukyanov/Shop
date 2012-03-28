package ua.edu.ChaliyLukyanov.laba3.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShopJDBC implements Shop {

	private Connection conn = null;
	
	public ShopJDBC(Connection conn){
		this.conn = conn;
	}
	
	@Override
	public List<Device> getAllDevices() throws SQLException {
		PreparedStatement st = conn.prepareStatement("select * from device");
		ResultSet row =  st.executeQuery();
		List<Device> res = new ArrayList<Device>();
		while(row.next()){
			Device dev = new Device();
			dev.setId(row.getInt("id_device"));
			dev.setIdComponent(row.getInt("id_component"));
			dev.setIdPrev(row.getInt("id_prev"));
			dev.setTitle(row.getString("title"));
			res.add(dev);
		}
		return res;
		
	}

	@Override
	public List<Device> getAllComponents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addDevice(Device device) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addComponent(Component component) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Device getDeviceByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Component getComponentByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removDevice(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeComponent(int id) {
		// TODO Auto-generated method stub
		
	}

	
}
