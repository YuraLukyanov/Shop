package ua.edu.ChaliyLukyanov.laba3.model.DAO;

import java.util.List;

import ua.edu.ChaliyLukyanov.laba3.model.Component;

public interface ComponentDAO {

	List<Component> getAllComponents();
	
	Component getComponentByID(int id);
	
	void addComponent(Component component);
	
	void removeComponent(int id);
	
	List<String> getDistinctProducers();
	
	void updateComponent(Component component);
	
	int getIdLastComponent();
}
