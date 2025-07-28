package org.example.services;

import org.example.dto.ClienteDTO;
import org.example.dto.ContatoDTO;
import org.example.entities.Clientes;
import org.example.entities.Contatos;
import org.example.repositories.ClienteRepository;
import org.example.services.exceptions.ResourceNotFoundException;
import org.example.services.exceptions.ValueBigForAtributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public ClienteDTO convertToDto(Clientes clientes) {
        ClienteDTO dto = new ClienteDTO();

        dto.setNome(clientes.getNome_cli());
        dto.setCpf(clientes.getCpf_cli());
        dto.setTelefone(clientes.getTelefone_cli());
        dto.setEmail(clientes.getEmail_cli());

        if (clientes.getContatos() != null) {
            ContatoDTO contatoDTO = new ContatoDTO();

            Contatos contatos = clientes.getContatos();
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

    public List<Clientes> findAll() {
        return repository.findAll();
    }

    public Clientes findById(Long id) {
        Clientes clientes = repository.findById(id).orElse(null);
        if (clientes == null) {
            throw new ResourceNotFoundException(id);
        }
        return clientes;
    }

    //public Clientes insert(Clientes obj) {
        //try {
            //return obj = repository.save(obj);
        //} catch (DataIntegrityViolationException e) {
            //throw new ValueBigForAtributeException(e.getMessage());
        //}
    //}

    public Clientes insert(ClienteDTO dto){

        Contatos contatos = new Contatos();

        contatos.setCep_ctt(dto.getContatos().getCep());
        contatos.setMunicipio_ctt(dto.getContatos().getMunicipio());
        contatos.setLogradouro_ctt(dto.getContatos().getLogradouro());
        contatos.setNumero_ctt(dto.getContatos().getNumero());
        contatos.setComplemento_ctt(dto.getContatos().getComplemento());
        contatos.setUf_ctt(dto.getContatos().getUf());

        Clientes clientes = new Clientes();

        clientes.setNome_cli(dto.getNome());
        clientes.setCpf_cli(dto.getCpf());
        clientes.setTelefone_cli(dto.getTelefone());
        clientes.setEmail_cli(dto.getEmail());

        clientes.setContatos(contatos);

        return repository.save(clientes);
    }

    public Clientes update(Long id, ClienteDTO dto) {
        try {
            Clientes clientes = findById(id);

            clientes.setNome_cli(dto.getNome());
            clientes.setCpf_cli(dto.getCpf());
            clientes.setTelefone_cli(dto.getTelefone());
            clientes.setEmail_cli(dto.getEmail());

            Contatos contatos = clientes.getContatos();

            if(contatos == null) {
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

            clientes.setContatos(contatos);

            return repository.save(clientes);
        } catch (DataIntegrityViolationException e) {
            throw new ValueBigForAtributeException(e.getMessage());
        }
    }

    public void deleteClientes(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }
}
