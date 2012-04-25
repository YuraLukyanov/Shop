package ua.edu.ChaliyLukyanov.laba3.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.edu.ChaliyLukyanov.laba3.model.Component;
import ua.edu.ChaliyLukyanov.laba3.model.NoSuchComponentException;
import ua.edu.ChaliyLukyanov.laba3.model.ShopException;

public class OracleComponentDAO implements ComponentDAO {

	private static final String CANT_CLOSE_CONNECTION = "Can't close connection";

	private static final String CANT_CLOSE_STATEMENT = "Can't close statement";
	
	private static final String CANT_CLOSE_RESULT_SET = "Cant' close result set";

	public static final String PRICE = "price";

	public static final String IMG = "img";

	public static final String WEIGHT = "weight";

	public static final String PRODUCER = "producer";

	public static final String DESCRIPTION = "description";

	public static final String TITLE = "title";

	public static final String ID_COMPONENT = "id_component";

	public static final String GET_ALL_COMPONENTS = "select * from component";
	
	public static final String GET_DISTINCT_PRODUCERS = "select distinct producer from component";

	public static final String GET_COMPONENT_BY_ID = "select * from component where id_component = ?";

	public static final String INSERT_COMPONENT = "insert into component values(com_sq.nextval,?,?,?,?,?,?)";

	public static final String REMOVE_COMPONENT = "delete from component where id_component = ?";
	
	public static final String UPDATE_COMPONENT = "update component set title = ?, description = ?, producer = ?, price = ? where id_component = ?";

	public static final String GET_ID_LAST_COMPONENT = "select com_sq.currval from dual";
	

	@Override
	public int getIdLastComponent() {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet row = null;
		int id = 0;
		try {
			conn = OracleDAOFactory.createConnection();
			st = conn.prepareStatement(GET_ID_LAST_COMPONENT);
			row = st.executeQuery();
			if (row.next()) {
				id = row.getInt(1);
			}else{
				throw new NoSuchComponentException("Can't get last component ID");
			}
			return id;
		} catch (SQLException e) {
			throw new ShopException("Can't get components from database", e);
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
	public List<Component> getAllComponents() {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet row = null;
		List<Component> res = new ArrayList<Component>();
		try {
			conn = OracleDAOFactory.createConnection();
			st = conn.prepareStatement(GET_ALL_COMPONENTS);
			row = st.executeQuery();
			while (row.next()) {
				Component comp = new Component();
				comp.setId(row.getInt(ID_COMPONENT));
				comp.setTitle(row.getString(TITLE));
				comp.setDescription(row.getString(DESCRIPTION));
				comp.setProducer(row.getString(PRODUCER));
				comp.setWeight(row.getDouble(WEIGHT));
				comp.setImg(row.getString(IMG));
				comp.setPrice(row.getDouble(PRICE));
				res.add(comp);
			}
			return res;
		} catch (SQLException e) {
			throw new ShopException("Can't get components from database", e);
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
	public Component getComponentByID(int id) {
		Connection conn = null;
		PreparedStatement st = null;
		Component component = null;
		ResultSet row = null;
		try {
			conn = OracleDAOFactory.createConnection();
			st = conn.prepareStatement(GET_COMPONENT_BY_ID);
			st.setInt(1,id);
			row = st.executeQuery();
			if (row.next()) {
				component = new Component(id, row.getString(TITLE),
						row.getString(DESCRIPTION),
						row.getString(PRODUCER), row.getDouble(WEIGHT),
						row.getString(IMG), row.getDouble(PRICE));
			}else{
				throw new NoSuchComponentException("Can't get component from database.");
			}
			return component;

		} catch (SQLException e) {
			throw new ShopException("Can't get component from database", e);
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
	public void addComponent(Component component) {
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
	public void removeComponent(int id) {
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
	
	public List<String> getDistinctProducers(){
		Connection conn = null;
		PreparedStatement st = null;
		List<String> producers = new ArrayList<String>();
		try {
			conn = OracleDAOFactory.createConnection();
			st = conn.prepareStatement(GET_DISTINCT_PRODUCERS);
			ResultSet row = st.executeQuery();
			while(row.next()){
				producers.add(row.getString(PRODUCER));
			}
			return producers;
		} catch (SQLException e) {
			throw new ShopException("Can't get producers from database", e);
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
	
	public void updateComponent(Component component) {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = OracleDAOFactory.createConnection();
			st = conn.prepareStatement(UPDATE_COMPONENT);
			st.setString(1, component.getTitle());
			st.setString(2, component.getDescription());
			st.setString(3, component.getProducer());
			st.setDouble(4, component.getPrice());
			st.setInt(5, component.getId());
			st.executeUpdate();
		} catch (SQLException e) {
			throw new ShopException("Can't get producers from database", e);
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
