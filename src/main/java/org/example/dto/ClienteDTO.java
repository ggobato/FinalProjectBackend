package org.example.dto;

public class ClienteDTO {

    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private ContatoDTO contatos;

    public ClienteDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ContatoDTO getContatos() {
        return contatos;
    }

    public void setContatos(ContatoDTO contatos) {
        this.contatos = contatos;
    }
}
