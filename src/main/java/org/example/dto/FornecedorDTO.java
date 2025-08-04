package org.example.dto;

import org.example.entities.Fornecedores;

public class FornecedorDTO {

    private Long id_fornecedor;
    private String nome_for;
    private String razao_social_for;
    private String cnpj_for;
    private String telefone_for;
    private String email_for;
    private ContatoDTO contatos;

    public FornecedorDTO() {
    }

    public FornecedorDTO(Fornecedores fornecedores) {
        this.id_fornecedor = fornecedores.getId_fornecedor();
        this.nome_for = fornecedores.getNome_for();
        this.razao_social_for = fornecedores.getRazao_social_for();
        this.cnpj_for = fornecedores.getCnpj_for();
        this.telefone_for = fornecedores.getTelefone_for();
        this.email_for = fornecedores.getEmail_for();
        this.contatos = new ContatoDTO(fornecedores.getContatos());
    }

    public Long getId_fornecedor() {
        return id_fornecedor;
    }

    public void setId_fornecedor(Long id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }

    public String getNome_for() {
        return nome_for;
    }

    public void setNome_for(String nome_for) {
        this.nome_for = nome_for;
    }

    public String getCnpj_for() {
        return cnpj_for;
    }

    public void setCnpj_for(String cnpj_for) {
        this.cnpj_for = cnpj_for;
    }

    public String getTelefone_for() {
        return telefone_for;
    }

    public void setTelefone_for(String telefone_for) {
        this.telefone_for = telefone_for;
    }

    public String getEmail_for() {
        return email_for;
    }

    public void setEmail_for(String email_for) {
        this.email_for = email_for;
    }

    public ContatoDTO getContatos() {
        return contatos;
    }

    public void setContatos(ContatoDTO contatos) {
        this.contatos = contatos;
    }

    public String getRazao_social_for() {
        return razao_social_for;
    }

    public void setRazao_social_for(String razao_social_for) {
        this.razao_social_for = razao_social_for;
    }
}
