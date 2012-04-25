package ua.edu.ChaliyLukyanov.laba3.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;

import ua.edu.ChaliyLukyanov.laba3.model.Device;
import ua.edu.ChaliyLukyanov.laba3.model.NoSuchDeviceException;
import ua.edu.ChaliyLukyanov.laba3.model.ShopException;

public class OracleDeviceDAO implements DeviceDAO {

	private static final String CANT_CLOSE_CONNECTION = "Can't close connection";

	private static final String CANT_CLOSE_STATEMENT = "Can't close statement";
	
	private static final String CANT_CLOSE_RESULT_SET = "Cant' close result set";

	public static final String LEVEL = "level";

	public static final String TITLE = "title";

	public static final String ID_PREV = "id_prev";

	public static final String ID_COMPONENT = "id_component";

	public static final String ID_DEVICE = "id_device";

	public static final String GET_ALL_DEVICES = "select level, id_device, id_component, id_prev, title from device start with id_prev is null connect by prior id_device=id_prev";

	public static final String GET_DEVICE_BY_ID = "select * from device where id_device = ?";

	public static final String INSERT_DEVICE = "insert into device values(dev_sq.nextval,?,?,?)";

	public static final String REMOVE_DEVICE = "delete from device where id_device = ?";
	
	public static final String GET_FIRST_LEVEL_DEVICES = "select id_device, id_component, id_prev, title from device where id_prev is null";

	public static final String GET_NEXT_LEVEL_DEVICE_BY_ID = "select level, id_device, id_component, id_prev, title from device where level = 1 start with id_prev = ? connect by prior id_device=id_prev";

	public static final String GET_PREV_LEVELS_DEVICE_BY_ID = "select level, id_device, id_component, id_prev, title from device where level > 1 start with id_device = ? connect by prior id_prev=id_device";

	public static final String GET_ID_LAST_DEVICE = "select dev_sq.currval from dual";
	
	@Override
	public List<Device> getAllDevices() {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet row = null;
		List<Device> devices = new LinkedList<Device>();
		try {
			conn = OracleDAOFactory.createConnection();
			st = conn.prepareStatement(GET_ALL_DEVICES);
			row = st.executeQuery();
			while (row.next()) {
				Device dev = new Device();
				dev.setId(row.getInt(ID_DEVICE));
				dev.setIdComponent(row.getInt(ID_COMPONENT));
				dev.setIdPrev(row.getInt(ID_PREV));
				dev.setTitle(row.getString(TITLE));
				dev.setLevel(row.getInt(LEVEL));
				devices.add(dev);
			}
			return devices;
		} catch (SQLException e) {
			throw new ShopException("Can't show device from database", e);
		} finally {
			try {
				if (row != null) {
					row.close();
				}
			} catch (SQLException e) {
				throw new ShopException(CANT_CLOSE_RESULT_SET, e);
			}
			
			
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException e) {
				throw new ShopException(CANT_CLOSE_STATEMENT, e);
			}
			
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new ShopException(CANT_CLOSE_CONNECTION, e);
			}
		}
	}

	@Override
	public Device getDeviceByID(int id) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet row = null;
		try {
			conn = OracleDAOFactory.createConnection();
			st = conn.prepareStatement(GET_DEVICE_BY_ID);
			st.setInt(1, id);
			row = st.executeQuery();
			Device dev = null;
			if (row.next()){
				dev = new Device();
				dev.setId(row.getInt(ID_DEVICE));
				dev.setIdComponent(row.getInt(ID_COMPONENT));
				dev.setIdPrev(row.getInt(ID_PREV));
				dev.setTitle(row.getString(TITLE));
			}else{
				throw new NoSuchDeviceException("No such device in database!");
			}			
			return dev;
		} catch (SQLException e) {
			throw new ShopException("Can't show device from database", e);
		} finally {
			try {
				if (row != null) {
					row.close();
				}
			} catch (SQLException e) {
				throw new ShopException(CANT_CLOSE_RESULT_SET, e);
			}
			
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException e) {
				throw new ShopException(CANT_CLOSE_STATEMENT, e);
			}

			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new ShopException(CANT_CLOSE_CONNECTION, e);
			}
		}
	}

	@Override
	public void addDevice(Device device) {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = OracleDAOFactory.createConnection();
			st = conn.prepareStatement(INSERT_DEVICE);
			int id_prev = device.getIdPrev();
			if (id_prev == -1) {
				st.setNull(1, Types.INTEGER);
			} else {
				st.setInt(1, id_prev);
			}
			st.setInt(2, device.getIdComponent());
			st.setString(3, device.getTitle());
			st.executeUpdate();
		} catch (SQLException e) {
			throw new ShopException("Can't add device to database", e);
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException e) {
				throw new ShopException(CANT_CLOSE_STATEMENT, e);
			}

			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new ShopException(CANT_CLOSE_CONNECTION, e);
			}
		}
	}

	@Override
	public void removeDevice(int id) {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = OracleDAOFactory.createConnection();
			st = conn.prepareStatement(REMOVE_DEVICE);
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			throw new ShopException("Can't remove device from database", e);
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException e) {
				throw new ShopException(CANT_CLOSE_STATEMENT, e);
			}

			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new ShopException(CANT_CLOSE_CONNECTION, e);
			}
		}
	}
	
	private List<Device> getLevelDevices(int id, String sql) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		LinkedList<Device> devices = new LinkedList<Device>();
		
		try {
			conn = OracleDAOFactory.createConnection();
			ps = conn.prepareStatement(sql);
			if (id != 0) {
				ps.setInt(1, id);
			}
			rs = ps.executeQuery();
			while (rs.next()) {
				Device dev = new Device();
				dev.setId(rs.getInt(ID_DEVICE));
				dev.setIdComponent(rs.getInt(ID_COMPONENT));
				dev.setIdPrev(rs.getInt(ID_PREV));
				dev.setTitle(rs.getString(TITLE));
				if (id != 0) {
					dev.setLevel(rs.getInt(LEVEL));
				}
				devices.addFirst(dev);
			}
			return (List<Device>) devices;
		} catch (SQLException e) {
			throw new ShopException("Can't show device from database", e);
		}
		finally {
			
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				throw new ShopException(CANT_CLOSE_RESULT_SET, e);
			}
			
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				throw new ShopException(CANT_CLOSE_STATEMENT, e);
			}

			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new ShopException(CANT_CLOSE_CONNECTION, e);
			}
		}
	}
	
	public List<Device> getPrevLevelsDeviceByID(int id) {
		return getLevelDevices(id, GET_PREV_LEVELS_DEVICE_BY_ID);
	}
	
	public List<Device> getNextLevelsDeviceByID(int id) {
		return getLevelDevices(id, GET_NEXT_LEVEL_DEVICE_BY_ID);
	}
	
	public List<Device> getFirstLevelsDeviceByID(int id) {
		return getLevelDevices(id, GET_FIRST_LEVEL_DEVICES);
	}	
	
	public int getIdLastDevice() {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet row  = null;
		int id = 0;
		try {
			conn = OracleDAOFactory.createConnection();
			st = conn.prepareStatement(GET_ID_LAST_DEVICE);
			row = st.executeQuery();
			if (row.next()) {
				id = row.getInt(1);
			}else{
				throw new NoSuchDeviceException("No such device in database!");
			}
			return id;
		} catch (SQLException e) {
			throw new ShopException("Can't show device from database", e);
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException e) {
				throw new ShopException(CANT_CLOSE_STATEMENT, e);
			}

			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new ShopException(CANT_CLOSE_CONNECTION, e);
			}
		}
	}
}
