package org.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Contato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CON_ID")
    private Long conId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "Con_CLI_ID")
    private Cliente conCliente;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "Con_FOR_ID")
    private Fornecedor conFornecedor;

    @NotBlank(message = "Celular é Obrigatório")
    @Size(max = 14, message = "Campo teleone não deve conter mais de 14 caracteres")
    @Column(name = "CON_CELULAR",nullable = false, length = 14)
    private String conCelular;

    @NotBlank(message = "Telefone comercial é Obrigatório")
    @Size(max = 14, message = "Campo teleone não deve conter mais de 14 caracteres")
    @Column(name = "CON_TELEFONE_COMERCIAL", nullable = false, length = 14)
    private String conTelefoneComercial;

    @NotBlank(message = "Email é Obrigatório")
    @Email(message = "Email é invalido")
    @Size(max = 55, message = "Email não deve conter mais de 55 caracteres")
    @Column(length = 55, name = "CON_EMAIL", nullable = false)
    private String conEmail;

    public Contato() {
    }

    public Contato(Long conId, Cliente conCliente, String conCelular, String conTelefoneComercial, String conEmail) {
        this.conId = conId;
        this.conCliente = conCliente;
        this.conCelular = conCelular;
        this.conTelefoneComercial = conTelefoneComercial;
        this.conEmail = conEmail;
    }

    public Contato(Long conId, Fornecedor conFornecedor, String conCelular, String conTelefoneComercial, String conEmail) {
        this.conId = conId;
        this.conFornecedor = conFornecedor;
        this.conCelular = conCelular;
        this.conTelefoneComercial = conTelefoneComercial;
        this.conEmail = conEmail;
    }
    public Long getConId() {
        return conId;
    }

    public void setConId(Long conId) {
        this.conId = conId;
    }

    public String getConCelular() {
        return conCelular;
    }

    public void setConCelular(String conCelular) {
        this.conCelular = conCelular;
    }

    public String getConTelefoneComercial() {
        return conTelefoneComercial;
    }

    public void setConTelefoneComercial(String conTelefoneComercial) {
        this.conTelefoneComercial = conTelefoneComercial;
    }

    public String getConEmail() {
        return conEmail;
    }

    public void setConEmail(String conEmail) {
        this.conEmail = conEmail;
    }
}
