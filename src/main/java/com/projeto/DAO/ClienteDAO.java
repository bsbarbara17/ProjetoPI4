package com.projeto.DAO;

import java.util.List;

import com.projeto.model.Cliente;

public interface ClienteDAO {
	void save(Cliente cliente);
	void update(Cliente cliente);
	void delete(Long id);
	Cliente findById(Long id);
	List<Cliente> findAll();
	
}
