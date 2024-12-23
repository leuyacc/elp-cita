package com.elp.controller;

import com.elp.dto.BarberoDTO;
import com.elp.dto.GenericResponse;
import com.elp.model.Barbero;
import com.elp.service.IBarberoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/barbero")
@RequiredArgsConstructor
public class BarberoController {

    private final IBarberoService service;
    private final ModelMapper modelMapper;

    /*
    public BarberoController(IBarberoService Service) {
        this.Service = Service;
    }
    */

    @GetMapping
    public ResponseEntity<GenericResponse<BarberoDTO>> getAllBarbero(){
        List<BarberoDTO> list = service.findAll().stream().map(this::convertToDTO).toList();
        return ResponseEntity.ok(new GenericResponse<>(200, "success",list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<BarberoDTO>> getBarberoById(@PathVariable("id") int id){
        Barbero obj = service.findById(id);
        return ResponseEntity.ok(new GenericResponse<>(200,"success", Arrays.asList(convertToDTO(obj))));
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody BarberoDTO dto){
        Barbero obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdBarbero()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<BarberoDTO>> update(@PathVariable("id") Integer id ,@RequestBody BarberoDTO dto){
        dto.setIdBarbero(id);
        Barbero obj = service.update(id, convertToEntity(dto));
        return ResponseEntity.ok( new GenericResponse<>(200,"success", Arrays.asList(convertToDTO(obj))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private BarberoDTO convertToDTO(Barbero obj){
        return modelMapper.map(obj, BarberoDTO.class);
    }

    private Barbero convertToEntity(BarberoDTO dto){
        return modelMapper.map(dto, Barbero.class);
    }
}
