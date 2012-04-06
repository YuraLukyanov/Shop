package ua.edu.ChaliyLukyanov.laba3.model.DAO;

import java.sql.SQLException;
import java.util.List;

import ua.edu.ChaliyLukyanov.laba3.model.Component;

public interface ComponentDAO {

	List<Component> getAllComponents() throws SQLException;
	
	Component getComponentByID(int id) throws SQLException ;
	
	void addComponent(Component component) throws SQLException;
	
	void removeComponent(int id) throws SQLException;
}
