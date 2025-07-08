package org.example.entidades;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fornecedor")
    private int id_fornecedor;

    @ManyToMany(mappedBy = "fornecedores")
    private Set<Produto> produtos;

    @NotBlank(message = "Obrigatório preencher nome")
    @Size(max = 100, message = "Nome deve conter 100 caracteres máximo")
    @Column(name = "nome_forn", nullable = false, length = 100)
    private String nome_forn;

    @NotBlank(message = "Obrigatório preencher CNPJ")
    @Size(max = 18, message = "CNPJ deve conter 18 caracteres máximo")
    @Column(name = "cnpj_forn", nullable = false, length = 18)
    private String cnpj_forn;

    @NotBlank(message = "Obrigatório preencher telefone")
    @Size(max = 14, message = "Telefone deve conter 14 caracteres máximo")
    @Column(name = "telefone_forn", nullable = false, length = 14)
    private String telefone_forn;

    @Size(max = 100, message = "Email deve conter 100 caracteres máximo")
    @Column(name = "email_forn", length = 100)
    private String email_forn;

    public Fornecedor() {
    }

    public Fornecedor(int id_fornecedor, String nome_forn, String cnpj_forn, String telefone_forn, String email_forn) {
        this.id_fornecedor = id_fornecedor;
        this.nome_forn = nome_forn;
        this.cnpj_forn = cnpj_forn;
        this.telefone_forn = telefone_forn;
        this.email_forn = email_forn;
    }

    public int getId_fornecedor() {
        return id_fornecedor;
    }

    public void setId_fornecedor(int id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }

    public String getNome_forn() {
        return nome_forn;
    }

    public void setNome_forn(String nome_forn) {
        this.nome_forn = nome_forn;
    }

    public String getCnpj_forn() {
        return cnpj_forn;
    }

    public void setCnpj_forn(String cnpj_forn) {
        this.cnpj_forn = cnpj_forn;
    }

    public String getTelefone_forn() {
        return telefone_forn;
    }

    public void setTelefone_forn(String telefone_forn) {
        this.telefone_forn = telefone_forn;
    }

    public String getEmail_forn() {
        return email_forn;
    }

    public void setEmail_forn(String email_forn) {
        this.email_forn = email_forn;
    }
}


