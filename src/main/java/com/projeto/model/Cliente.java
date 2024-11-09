package com.projeto.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "Cliente")
public class Cliente extends AbstractEntity<Long> {

    @NotNull
    @Column(name = "nome", nullable = false, length = 255)
    private String nome;

    @NotNull
    @Email
    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @NotNull
    @Size(min = 6, max = 20)
    @Column(name = "senha", nullable = false, length = 20)
    private String senha;

    @NotNull
    @Column(name = "cpf", nullable = false, unique = true)
    private Integer cpf;
      
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }
}
