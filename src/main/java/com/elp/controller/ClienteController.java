package com.elp.controller;

import com.elp.dto.ClienteDTO;
import com.elp.dto.GenericResponse;
import com.elp.model.Cliente;
import com.elp.service.IClienteService;
import jakarta.servlet.Servlet;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final IClienteService service;
    @Qualifier("clienteMapper")
    private final ModelMapper modelMapper;

    /*
    public ClienteController(IClienteService Service) {
        this.Service = Service;
    }
    */

    @GetMapping
    public ResponseEntity<GenericResponse<ClienteDTO>> getAllCliente(){
        //List<Cliente> list = service.findAll();
        //List<ClienteDTO> list = service.findAll().stream().map(e -> modelMapper.map(e, ClienteDTO.class)).toList();
        List<ClienteDTO> list = service.findAll().stream().map(this::convertToDTO).toList();
        //return ResponseEntity.ok(list);
        return  ResponseEntity.ok(new GenericResponse<>(200,"success",list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<ClienteDTO>> getClienteById(@PathVariable("id") int id){
        Cliente obj = service.findById(id);
        return ResponseEntity.ok(new GenericResponse<>(200,"success", Arrays.asList(convertToDTO(obj))));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ClienteDTO dto){
        Cliente obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCliente()).toUri();
        return  ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<ClienteDTO>> update(@PathVariable("id") Integer id ,@Valid @RequestBody ClienteDTO dto){
        dto.setIdCliente(id);
        Cliente obj = service.update(id, convertToEntity(dto));
        return ResponseEntity.ok( new GenericResponse<>(200,"success", Arrays.asList(convertToDTO(obj))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private ClienteDTO convertToDTO(Cliente obj){
        return modelMapper.map(obj, ClienteDTO.class);
    }
    private Cliente convertToEntity(ClienteDTO dto){
        return  modelMapper.map(dto, Cliente.class);
    }


}
