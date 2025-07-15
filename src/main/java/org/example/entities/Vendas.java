package org.example.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Vendas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venda")
    private int id_venda;

    @Column(name = "data_venda", nullable = false)
    private Date data_venda;

    @Column(name = "total_venda", nullable = false)
    private double total_venda;

    @Column(name = "desconto_venda")
    private double desconto_venda;

    @Column(name = "formaPagamento_venda", nullable = false)
    private String formaPagamento_venda;

    public Vendas() {
    }

    public Vendas(int id_venda, Date data_venda, double total_venda, double desconto_venda, String formaPagamento_venda) {
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

    public double getTotal_venda() {
        return total_venda;
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
