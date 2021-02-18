package model.dao;

import java.util.List;

import model.entities.Departament;

public interface DepartamentDao {
	
	void insert (Departament obj);
	
	void update (Departament obj);
	
	void deleteById(Integer id);
	
	Departament findById(Integer Id);
	
	List<Departament> findAll();
	
	
	
	

}
