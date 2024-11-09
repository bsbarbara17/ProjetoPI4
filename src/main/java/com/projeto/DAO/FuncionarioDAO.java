package com.projeto.DAO;

import java.util.List;

import com.projeto.model.Funcionario;

public interface FuncionarioDAO {
	void save(Funcionario funcionario);
	void update(Funcionario funcionario);
	void delete(Long id);
	Funcionario findById(Long id);
	List<Funcionario> findAll();
}
