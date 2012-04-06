package ua.edu.ChaliyLukyanov.laba3.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;

import ua.edu.ChaliyLukyanov.laba3.model.Component;
import ua.edu.ChaliyLukyanov.laba3.model.Device;
import ua.edu.ChaliyLukyanov.laba3.model.ShopException;

public class OracleDeviceDAO implements DeviceDAO {

	public static final String GET_ALL_DEVICES = "select level, id_device, id_component, id_prev, title from device start with id_prev is null connect by prior id_device=id_prev";

	public static final String GET_DEVICE_BY_ID = "select * from device where id_device = ?";

	public static final String INSERT_DEVICE = "insert into device values(dev_sq.nextval,?,?,?)";

	public static final String REMOVE_DEVICE = "delete from device where id_device = ?";

	@Override
	public List<Device> getAllDevices() throws SQLException {
		Connection conn = null;
		PreparedStatement st = null;
		List<Device> devices = new LinkedList<Device>();
		try {
			conn = OracleDAOFactory.createConnection();
			st = conn.prepareStatement(GET_ALL_DEVICES);
			ResultSet row = st.executeQuery();
			while (row.next()) {
				Device dev = new Device();
				dev.setId(row.getInt("id_device"));
				dev.setIdComponent(row.getInt("id_component"));
				dev.setIdPrev(row.getInt("id_prev"));
				dev.setTitle(row.getString("title"));
				dev.setLevel(row.getInt("level"));
				devices.add(dev);
			}
			return devices;
		} catch (SQLException e) {
			throw new ShopException("Can't add device to database", e);
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException e) {
				throw new ShopException("Can't close statement", e);
			}

			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new ShopException("Can't close connection", e);
			}
		}
	}

	@Override
	public Component getDeviceByID(int id) throws SQLException {
		return null;
	}

	@Override
	public void addDevice(Device device) throws SQLException {
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
				throw new ShopException("Can't close statement", e);
			}

			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new ShopException("Can't close connection", e);
			}
		}
	}

	@Override
	public void removeDevice(int id) throws SQLException {
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
				throw new ShopException("Can't close statement", e);
			}

			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new ShopException("Can't close connection", e);
			}
		}
	}

}
