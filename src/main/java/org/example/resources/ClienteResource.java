package org.example.resources;

import org.example.dto.ClienteDTO;
import org.example.entities.Clientes;
import org.example.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteResource {

    @Autowired
    private ClienteService service;

    @GetMapping
    public ResponseEntity<List<Clientes>> findAll() {
        List<Clientes> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Clientes> findById(@PathVariable Long id) {
        Clientes obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Clientes> insert(@Valid @RequestBody ClienteDTO dto) {
        Clientes obj = service.insert(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> update(@Valid @RequestBody ClienteDTO dto, @PathVariable Long id) {
        Clientes updatedCliente = service.update(id, dto);
        ClienteDTO responseDto = service.convertToDto(updatedCliente);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteClientes(@PathVariable Long id) {
        service.deleteClientes(id);
        return ResponseEntity.noContent().build();
    }
}
