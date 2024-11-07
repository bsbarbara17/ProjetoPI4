package com.projeto.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import java.math.BigDecimal;

@Entity
public class Comanda {

    @Id
    private Long idCarrinho;

    @Column(nullable = false)
    private int itens;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

    // Getters e setters
    public Long getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(Long idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public int getItens() {
        return itens;
    }

    public void setItens(int itens) {
        this.itens = itens;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
