package org.example.services;

import org.example.dto.ContatoDTO;
import org.example.dto.FornecedorDTO;
import org.example.entities.Contatos;
import org.example.entities.Fornecedores;
import org.example.repositories.ClienteRepository;
import org.example.repositories.FornecedorRepository;
import org.example.services.exceptions.ResourceNotFoundException;
import org.example.services.exceptions.ValueBigForAtributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    public FornecedorDTO convertToDTO(Fornecedores fornecedores) {
        FornecedorDTO dto = new FornecedorDTO();

        dto.setNome_for(fornecedores.getNome_for());
        dto.setRazao_social_for(fornecedores.getRazao_social_for());
        dto.setCnpj_for(fornecedores.getCnpj_for());
        dto.setTelefone_for(fornecedores.getTelefone_for());
        dto.setEmail_for(fornecedores.getEmail_for());

        if (fornecedores.getContatos() != null) {
            ContatoDTO contatoDTO = new ContatoDTO();

            Contatos contatos = fornecedores.getContatos();

            contatoDTO.setCep(contatos.getCep_ctt());
            contatoDTO.setMunicipio(contatos.getMunicipio_ctt());
            contatoDTO.setLogradouro(contatos.getLogradouro_ctt());
            contatoDTO.setNumero(contatos.getNumero_ctt());
            contatoDTO.setComplemento(contatos.getComplemento_ctt());
            contatoDTO.setUf(contatos.getUf_ctt());

            dto.setContatos(contatoDTO);
        }
        return dto;
    }

    public List<Fornecedores> findAll() {
        return repository.findAll();
    }

    public Fornecedores findById(Long id) {
        Fornecedores fornecedores = repository.findById(id).orElse(null);
        if (fornecedores == null) {
            throw new ResourceNotFoundException(id);
        }
        return fornecedores;
    }

    public Fornecedores insert(FornecedorDTO dto) {
        Contatos contatos = new Contatos();

        contatos.setCep_ctt(dto.getContatos().getCep());
        contatos.setMunicipio_ctt(dto.getContatos().getMunicipio());
        contatos.setLogradouro_ctt(dto.getContatos().getLogradouro());
        contatos.setNumero_ctt(dto.getContatos().getNumero());
        contatos.setComplemento_ctt(dto.getContatos().getComplemento());
        contatos.setUf_ctt(dto.getContatos().getUf());

        Fornecedores fornecedores = new Fornecedores();

        fornecedores.setNome_for(dto.getNome_for());
        fornecedores.setRazao_social_for(dto.getRazao_social_for());
        fornecedores.setCnpj_for(dto.getCnpj_for());
        fornecedores.setTelefone_for(dto.getTelefone_for());
        fornecedores.setEmail_for(dto.getEmail_for());

        fornecedores.setContatos(contatos);

        return repository.save(fornecedores);
    }

    public Fornecedores update(Long id, FornecedorDTO dto) {
        try {
            Fornecedores fornecedores = findById(id);

            fornecedores.setNome_for(dto.getNome_for());
            fornecedores.setCnpj_for(dto.getCnpj_for());
            fornecedores.setTelefone_for(dto.getTelefone_for());
            fornecedores.setEmail_for(dto.getEmail_for());

            Contatos contatos = fornecedores.getContatos();

            if (contatos == null) {
                contatos = new Contatos();
            }

            if (dto.getContatos() != null) {
                contatos.setCep_ctt(dto.getContatos().getCep());
                contatos.setMunicipio_ctt(dto.getContatos().getMunicipio());
                contatos.setLogradouro_ctt(dto.getContatos().getLogradouro());
                contatos.setNumero_ctt(dto.getContatos().getNumero());
                contatos.setComplemento_ctt(dto.getContatos().getComplemento());
                contatos.setUf_ctt(dto.getContatos().getUf());
            }

            fornecedores.setContatos(contatos);

            return repository.save(fornecedores);
        } catch (DataIntegrityViolationException e) {
            throw new ValueBigForAtributeException(e.getMessage());
        }
    }

    public void deleteFornecedores(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }
}
