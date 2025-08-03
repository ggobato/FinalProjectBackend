package org.example.dto;

import org.example.entities.Clientes;

public class ClienteDTO {

    private Long id_cliente;
    private String nome_cli;
    private String cpf_cli;
    private String telefone_cli;
    private String email_cli;
    private ContatoDTO contatos;

    public ClienteDTO() {
    }

    public ClienteDTO(Clientes clientes) {
        this.id_cliente = clientes.getId_cliente();
        this.nome_cli = clientes.getNome_cli();
        this.cpf_cli = clientes.getCpf_cli();
        this.telefone_cli = clientes.getTelefone_cli();
        this.email_cli = clientes.getEmail_cli();
        this.contatos = new ContatoDTO(clientes.getContatos());
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome_cli() {
        return nome_cli;
    }

    public void setNome_cli(String nome_cli) {
        this.nome_cli = nome_cli;
    }

    public String getCpf_cli() {
        return cpf_cli;
    }

    public void setCpf_cli(String cpf_cli) {
        this.cpf_cli = cpf_cli;
    }

    public String getTelefone_cli() {
        return telefone_cli;
    }

    public void setTelefone_cli(String telefone_cli) {
        this.telefone_cli = telefone_cli;
    }

    public String getEmail_cli() {
        return email_cli;
    }

    public void setEmail_cli(String email_cli) {
        this.email_cli = email_cli;
    }

    public ContatoDTO getContatos() {
        return contatos;
    }

    public void setContatos(ContatoDTO contatos) {
        this.contatos = contatos;
    }
}
