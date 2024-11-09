package com.projeto.DAO;

import org.springframework.stereotype.Repository;

import com.projeto.model.Funcionario;

@Repository
public class FuncionarioDaoImpl  extends AbstractDao<Funcionario, Long> implements FuncionarioDAO {

}
