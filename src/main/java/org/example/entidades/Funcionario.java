package org.example.entidades;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_funcionario;

    @OneToMany(mappedBy = "funcionarios")
    private List<Venda> vendas;

    @NotBlank(message = "Obrigatório preencher nome")
    @Size(max = 100, message = "Nome deve conter 100 caracteres máximo.")
    @Column(name = "nome_func", nullable = false, length = 100)
    private String nome_func;

    @NotBlank(message = "CPF inválido")
    @Size(max = 11, message = "CPF deve conter 11 caracteres máximo")
    @Column(name = "cpf_func", nullable = false, length = 11)
    private String cpf_func;

    @NotBlank(message = "Obrigatório preencher cargo")
    @Size(max = 50, message = "Cargo deve conter 50 caracteres máximo")
    @Column(name = "cargo_func", nullable = false, length = 50)
    private String cargo_func;

    @NotBlank
    @Size(max = 255)
    @Column(name = "login_func")
    private Date login_func;

    @NotBlank
    @Size(max = 255)
    @Column(name = "logout_func")
    private Date logout_func;

    @NotBlank
    private String senha_func;

    public Funcionario() {
    }

    public Funcionario(int id_funcionario, String nome_func, String cpf_func, String cargo_func, Date login_func, Date logout_func, String senha_func) {
        this.id_funcionario = id_funcionario;
        this.nome_func = nome_func;
        this.cpf_func = cpf_func;
        this.cargo_func = cargo_func;
        this.login_func = login_func;
        this.logout_func = logout_func;
        this.senha_func = senha_func;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getNome_func() {
        return nome_func;
    }

    public void setNome_func(String nome_func) {
        this.nome_func = nome_func;
    }

    public String getCpf_func() {
        return cpf_func;
    }

    public void setCpf_func(String cpf_func) {
        this.cpf_func = cpf_func;
    }

    public String getCargo_func() {
        return cargo_func;
    }

    public void setCargo_func(String cargo_func) {
        this.cargo_func = cargo_func;
    }

    public Date getLogin_func() {
        return login_func;
    }

    public void setLogin_func(Date login_func) {
        this.login_func = login_func;
    }

    public Date getLogout_func() {
        return logout_func;
    }

    public void setLogout_func(Date logout_func) {
        this.logout_func = logout_func;
    }

    public String getSenha_func() {
        return senha_func;
    }

    public void setSenha_func(String senha_func) {
        this.senha_func = senha_func;
    }
}
