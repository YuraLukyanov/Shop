package ua.edu.ChaliyLukyanov.laba3.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.edu.ChaliyLukyanov.laba3.model.ShopException;
import ua.edu.ChaliyLukyanov.laba3.model.Component;

public class OracleComponentDAO implements ComponentDAO {

	public static final String GET_ALL_COMPONENTS = "select * from component";

	public static final String GET_COMPONENT_BY_ID = "select * from component where id_component = ?";

	public static final String INSERT_COMPONENT = "insert into component values(com_sq.nextval,?,?,?,?,?,?)";

	public static final String REMOVE_COMPONENT = "delete from component where id_component = ?";

	@Override
	public List<Component> getAllComponents() {
		Connection conn = null;
		PreparedStatement st = null;
		List<Component> res = new ArrayList<Component>();
		try {
			conn = OracleDAOFactory.createConnection();
			st = conn.prepareStatement(GET_ALL_COMPONENTS);
			ResultSet row = st.executeQuery();
			while (row.next()) {
				Component comp = new Component();
				comp.setId(row.getInt("id_component"));
				comp.setTitle(row.getString("title"));
				comp.setDescription(row.getString("description"));
				comp.setProducer(row.getString("producer"));
				comp.setWeight(row.getDouble("weight"));
				comp.setImg(row.getString("img"));
				comp.setPrice(row.getDouble("price"));
				res.add(comp);
			}
			return res;
		} catch (SQLException e) {
			throw new ShopException("Can't get components from database", e);
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
	public Component getComponentByID(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement st = null;
		Component component = null;

		try {
			conn = OracleDAOFactory.createConnection();
			st = conn.prepareStatement(GET_COMPONENT_BY_ID);
			st.setInt(1,id);
			ResultSet row = st.executeQuery();
			if (row.next()) {
				component = new Component(id, row.getString("title"),
						row.getString("description"),
						row.getString("producer"), row.getDouble("weight"),
						row.getString("img"), row.getDouble("price"));

			}
			return component;

		} catch (SQLException e) {
			throw new ShopException("Can't get component from database", e);
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
	public void addComponent(Component component) throws SQLException {
		Connection conn = null;
		PreparedStatement st = null;

		try {
			conn = OracleDAOFactory.createConnection();
			st = conn.prepareStatement(INSERT_COMPONENT);
			st.setString(1, component.getTitle());
			st.setString(2, component.getDescription());
			st.setString(3, component.getProducer());
			st.setDouble(4, component.getWeight());
			st.setString(5, component.getImg());
			st.setDouble(6, component.getPrice());
			st.execute();

		} catch (SQLException e) {
			throw new ShopException("Can't add component to database", e);
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
	public void removeComponent(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = OracleDAOFactory.createConnection();
			st = conn.prepareStatement(REMOVE_COMPONENT);
			st.setInt(1,id);
			st.executeUpdate();
		} catch (SQLException e) {
			throw new ShopException("Can't remove component from database", e);
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
