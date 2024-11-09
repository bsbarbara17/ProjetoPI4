package com.projeto.DAO;

import org.springframework.stereotype.Repository;

import com.projeto.model.Produto;

@Repository
public class ProdutoDaoImpl extends AbstractDao<Produto, Long> implements ProdutoDAO  {

}
