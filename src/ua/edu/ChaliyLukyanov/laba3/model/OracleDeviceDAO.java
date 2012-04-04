package ua.edu.ChaliyLukyanov.laba3.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class OracleDeviceDAO implements DeviceDAO {

	public static final String GET_ALL_DEVICES = "select * from device";
	
	public static final String GET_DEVICE_BY_ID = "select * from device where id_device = ? ";
	
	public static final String INSERT_DEVICE = "insert into device values(dev_sq.nextval,?,?,?)";
	
	public static final String REMOVE_DEVICE = "delete from device where id_device = ?";
	
	private Connection conn = null;
	
	public OracleDeviceDAO(Connection conn){
		this.conn = conn;
	}

	@SuppressWarnings("finally")
	@Override
	public List<Device> getAllDevices() throws SQLException {
		PreparedStatement st = conn.prepareStatement(GET_ALL_DEVICES);
		List<Device> res = new ArrayList<Device>();
		try {
			ResultSet row =  st.executeQuery();
			while(row.next()){
				Device dev = new Device();
				dev.setId(row.getInt("id_device"));
				dev.setIdComponent(row.getInt("id_component"));
				dev.setIdPrev(row.getInt("id_prev"));
				dev.setTitle(row.getString("title"));
				res.add(dev);
			}
		} finally {
			st.close();
			return res;
		}
		
	}

	@Override
	public Component getDeviceByID(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addDevice(Device device) throws SQLException {
		PreparedStatement st = conn.prepareStatement(INSERT_DEVICE);
		try {
			int id_prev = device.getIdPrev();
			if (id_prev == -1) {
				st.setNull(1,Types.INTEGER);
			} else {
				st.setInt(1, id_prev);
			}
			st.setInt(2,device.getIdComponent());
			st.setString(3,device.getTitle());
			st.executeUpdate();
		} finally {
			st.close();
		}
	}

	@Override
	public void removeDevice(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
