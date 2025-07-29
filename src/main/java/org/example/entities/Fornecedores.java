package org.example.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Fornecedores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fornecedor")
    private Long id_fornecedor;

    @OneToMany(mappedBy = "fornecedores")
    private Set<Produtos> produtos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_contato", nullable = false)
    private Contatos contatos;

    @NotBlank(message = "Obrigatório preencher nome fantasia")
    @Size(max = 50, message = "Nome deve conter 50 caracteres máximo")
    @Column(name = "nome_for", nullable = false, length = 50)
    private String nome_for;

    @NotBlank(message = "Obrigatótio preencher")
    @Size(max = 255, message = "Razão Social inválida")
    @Column(name = "razao_social_for", nullable = false, length = 255)
    private String razao_social_for;

    @NotBlank(message = "Obrigatório preencher CNPJ")
    @Size(max = 18, message = "CNPJ inválido")
    @Column(name = "cnpj_for", nullable = false, length = 18)
    private String cnpj_for;

    @NotBlank(message = "Obrigatório preencher telefone")
    @Size(max = 14, message = "Telefone deve conter 14 caracteres máximo")
    @Column(name = "telefone_for", nullable = false, length = 15)
    private String telefone_for;

    @Size(max = 100, message = "Email deve conter 100 caracteres máximo")
    @Column(name = "email_for", length = 100)
    private String email_for;

    public Fornecedores() {
    }

    public Fornecedores(Long id_fornecedor, String nome_for, String razao_social_for, String cnpj_for, String telefone_for, String email_for) {
        this.id_fornecedor = id_fornecedor;
        this.nome_for = nome_for;
        this.razao_social_for = razao_social_for;
        this.cnpj_for = cnpj_for;
        this.telefone_for = telefone_for;
        this.email_for = email_for;
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

    public Contatos getContatos() {
        return contatos;
    }

    public void setContatos(Contatos contatos) {
        this.contatos = contatos;
    }

    public String getRazao_social_for() {
        return razao_social_for;
    }

    public void setRazao_social_for(String razao_social_for) {
        this.razao_social_for = razao_social_for;
    }
}
