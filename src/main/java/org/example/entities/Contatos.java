package org.example.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Contatos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contato")
    private Long id_contato;

    @NotBlank(message = "CEP é obrigatório")
    @Size(max = 9, message = "CEP inválido")
    @Column(name = "cep_ctt", nullable = false, length = 9)
    private String cep_ctt;

    @NotBlank(message = "Obrigatório preeencher município")
    @Column(name = "municipio_ctt", nullable = false)
    private String municipio_ctt;

    @NotBlank(message = "Obrigatório preeencher logradouro")
    @Column(name = "logradouro_ctt", nullable = false)
    private String logradouro_ctt;

    @NotBlank(message = "Número é obrigatório")
    @Column(name = "numero_ctt", nullable = false, length = 5)
    private String numero_ctt;

    @Column(name = "complemento_ctt")
    private String complemento_ctt;

    @NotBlank(message = "UF é obrigatório")
    @Size(max = 2, message = "UF inválida")
    @Column(name = "uf_ctt", nullable = false, length = 2)
    private String uf_ctt;

    public Contatos() {
    }

    public Contatos(Long id_contato, String cep_ctt, String municipio_ctt, String logradouro_ctt, String numero_ctt, String complemento_ctt, String uf_ctt) {
        this.id_contato = id_contato;
        this.cep_ctt = cep_ctt;
        this.municipio_ctt = municipio_ctt;
        this.logradouro_ctt = logradouro_ctt;
        this.numero_ctt = numero_ctt;
        this.complemento_ctt = complemento_ctt;
        this.uf_ctt = uf_ctt;
    }

    public Long getId_contato() {
        return id_contato;
    }

    public void setId_contato(Long id_contato) {
        this.id_contato = id_contato;
    }

    public String getCep_ctt() {
        return cep_ctt;
    }

    public void setCep_ctt(String cep_ctt) {
        this.cep_ctt = cep_ctt;
    }

    public String getMunicipio_ctt() {
        return municipio_ctt;
    }

    public void setMunicipio_ctt(String municipio_ctt) {
        this.municipio_ctt = municipio_ctt;
    }

    public String getLogradouro_ctt() {
        return logradouro_ctt;
    }

    public void setLogradouro_ctt(String logradouro_ctt) {
        this.logradouro_ctt = logradouro_ctt;
    }

    public String getNumero_ctt() {
        return numero_ctt;
    }

    public void setNumero_ctt(String numero_ctt) {
        this.numero_ctt = numero_ctt;
    }

    public String getComplemento_ctt() {
        return complemento_ctt;
    }

    public void setComplemento_ctt(String complemento_ctt) {
        this.complemento_ctt = complemento_ctt;
    }

    public String getUf_ctt() {
        return uf_ctt;
    }

    public void setUf_ctt(String uf_ctt) {
        this.uf_ctt = uf_ctt;
    }
}
