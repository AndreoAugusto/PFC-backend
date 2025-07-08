package org.example.entidades;

import org.w3c.dom.Text;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_produto;

    @ManyToMany(mappedBy = "produtos")
    private Set<Venda> vendas;

    @ManyToMany
    @JoinTable(name = "produto_fornecedor",
    joinColumns = @JoinColumn(name = "id_produto"),
    inverseJoinColumns = @JoinColumn(name = "id_fornecedor"))
    private Set<Fornecedor> fornecedores;

    @NotBlank(message = "Obrigatório preencher marca")
    @Size(max = 100, message = "Marca deve conter 100 caracteres máximo")
    @Column(name = "marca_prod", nullable = false, length = 100)
    private String marca_prod;

    @NotBlank(message = "Obrigatório preencher nome")
    @Size(max = 100, message = "Nome deve conter 100 caracteres máximo")
    @Column(name = "nome_prod", nullable = false, length = 100)
    private String nome_prod;

    @NotBlank(message = "Obrigatório preencer quantidade")
    @Column(name = "qtde_prod", nullable = false, length = 3)
    private int qtde_prod;

    @NotBlank(message = "Obrigatório preencher preço")
    @Column(name = "preco_prod", nullable = false, length = 10)
    private double preco_prod;

    @Column(name = "descricao_prod")
    private Text descricao_prod;

    public Produto() {
    }

    public Produto(int id_produto, String marca_prod, String nome_prod, int qtde_prod, double preco_prod, Text descricao_prod) {
        this.id_produto = id_produto;
        this.marca_prod = marca_prod;
        this.nome_prod = nome_prod;
        this.qtde_prod = qtde_prod;
        this.preco_prod = preco_prod;
        this.descricao_prod = descricao_prod;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getMarca_prod() {
        return marca_prod;
    }

    public void setMarca_prod(String marca_prod) {
        this.marca_prod = marca_prod;
    }

    public String getNome_prod() {
        return nome_prod;
    }

    public void setNome_prod(String nome_prod) {
        this.nome_prod = nome_prod;
    }

    public int getQtde_prod() {
        return qtde_prod;
    }

    public void setQtde_prod(int qtde_prod) {
        this.qtde_prod = qtde_prod;
    }

    public double getPreco_prod() {
        return preco_prod;
    }

    public void setPreco_prod(double preco_prod) {
        this.preco_prod = preco_prod;
    }

    public Text getDescricao_prod() {
        return descricao_prod;
    }

    public void setDescricao_prod(Text descricao_prod) {
        this.descricao_prod = descricao_prod;
    }
}
