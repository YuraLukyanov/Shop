package ua.edu.ChaliyLukyanov.laba3.model;

import java.sql.SQLException;
import java.util.List;

public interface ComponentDAO {

	List<Component> getAllComponents() throws SQLException;
	
	Component getComponentByID(int id) throws SQLException ;
	
	void addComponent(Component component) throws SQLException;
	
	void removeComponent(int id) throws SQLException;
}
