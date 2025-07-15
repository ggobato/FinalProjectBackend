package org.example.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Vendas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id_cliente;

    @NotBlank(message = "Obrigatório preencher nome")
    @Size(max = 100, message = "Nome deve contaer menos de 100 caracteres")
    @Column(name = "nome_cli", nullable = false, length = 100)
    private String nome_cli;

    @NotBlank(message = "Obrigatório preencher o CPF")
    @Size(max = 11, message = "CPF inválido")
    @Column(name = "cpf_cli", nullable = false, length = 11)
    private String cpf_cli;


}
