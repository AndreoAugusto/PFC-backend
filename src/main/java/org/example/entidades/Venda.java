package org.example.entidades;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Set;

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_venda;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionarios;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente clientes;

    @ManyToMany
    @JoinTable(name = "venda_produto", joinColumns = @JoinColumn(name = "id_venda"), inverseJoinColumns = @JoinColumn(name = "id_produto"))
    private Set<Produto> produtos;

    @Column(name = "data_venda")
    private Date data_venda;

    @Column(name = "total_venda")
    private double total_venda;

    @Column(name = "desconto_venda")
    private double desconto_venda;

    @Column(name = "formaPagamento_venda")
    private String formaPagamento_venda;

    public Venda() {
    }

    public Venda(int id_venda, Date data_venda, double total_venda, double desconto_venda, String formaPagamento_venda) {
        this.id_venda = id_venda;
        this.data_venda = data_venda;
        this.total_venda = total_venda;
        this.desconto_venda = desconto_venda;
        this.formaPagamento_venda = formaPagamento_venda;
    }

    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public Date getData_venda() {
        return data_venda;
    }

    public void setData_venda(Date data_venda) {
        this.data_venda = data_venda;
    }

    public double getTotal_venda(double preco) {
        return total_venda = preco * 1.5;
    }

    public void setTotal_venda(double total_venda) {
        this.total_venda = total_venda;
    }

    public double getDesconto_venda() {
        return desconto_venda;
    }

    public void setDesconto_venda(double desconto_venda) {
        this.desconto_venda = desconto_venda;
    }

    public String getFormaPagamento_venda() {
        return formaPagamento_venda;
    }

    public void setFormaPagamento_venda(String formaPagamento_venda) {
        this.formaPagamento_venda = formaPagamento_venda;
    }

}
