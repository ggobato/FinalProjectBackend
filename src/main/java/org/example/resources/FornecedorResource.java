package org.example.resources;

import org.example.dto.FornecedorDTO;
import org.example.entities.Fornecedores;
import org.example.repositories.FornecedorRepository;
import org.example.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/fornecedores")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FornecedorResource {

    @Autowired
    private FornecedorService service;

    @Autowired
    private FornecedorRepository repository;

    @GetMapping("/count")
    public Long countFornecedores() {
        return repository.count();
    }

    @GetMapping
    public ResponseEntity<List<Fornecedores>> findAll() {
        List<Fornecedores> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<FornecedorDTO> findById(@PathVariable Long id) {
        Fornecedores fornecedores = service.findById(id);
        FornecedorDTO fornecedorDTO = new FornecedorDTO(fornecedores);
        return ResponseEntity.ok().body(fornecedorDTO);
    }

    @PostMapping
    public ResponseEntity<Fornecedores> insert(@Valid @RequestBody FornecedorDTO dto) {
        Fornecedores obj = service.insert(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<FornecedorDTO> update(@Valid @RequestBody FornecedorDTO dto, @PathVariable Long id) {
        Fornecedores updatedFornecedor = service.update(id, dto);
        FornecedorDTO responseDto = service.convertToDTO(updatedFornecedor);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteFornecedores(@PathVariable Long id) {
        service.deleteFornecedores(id);
        return ResponseEntity.noContent().build();
    }
}