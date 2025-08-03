package org.example.dto;

import org.example.entities.Contatos;

public class ContatoDTO {

    private String cep;
    private String municipio;
    private String logradouro;
    private String numero;
    private String complemento;
    private String uf;

    public ContatoDTO() {
    }

    public ContatoDTO(Contatos contatos) {
        this.cep = contatos.getCep_ctt();
        this.municipio = contatos.getMunicipio_ctt();
        this.logradouro = contatos.getLogradouro_ctt();
        this.numero = contatos.getNumero_ctt();
        this.complemento = contatos.getComplemento_ctt();
        this.uf = contatos.getUf_ctt();
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
