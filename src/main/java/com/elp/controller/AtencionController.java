package com.elp.controller;

import com.elp.dto.AtencionDTO;
import com.elp.dto.BarberoDTO;
import com.elp.dto.GenericResponse;
import com.elp.model.Atencion;
import com.elp.model.Barbero;
import com.elp.service.IAtencionService;
import com.elp.service.IBarberoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/atencion")
@RequiredArgsConstructor
public class AtencionController {

    private final IAtencionService service;
    private final ModelMapper modelMapper;
    /*
    public AtencionController(IAtencionService Service) {
        this.Service = Service;
    }
    */

    @GetMapping
    public ResponseEntity<GenericResponse<AtencionDTO>> getAllAtencion(){
        List<AtencionDTO> list = service.findAll().stream().map(this::convertToDTO).toList();
        return ResponseEntity.ok().body( new GenericResponse<>(200,"success", list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<AtencionDTO>> getAtencionById(@PathVariable("id") int id){
        Atencion obj = service.findById(id);
        return ResponseEntity.ok( new GenericResponse<>(200,"success", Arrays.asList(convertToDTO(obj))));
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody AtencionDTO dto){
        Atencion obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdAtencion()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public  ResponseEntity<GenericResponse<AtencionDTO>> update(@PathVariable("id") Integer id ,@RequestBody AtencionDTO dto){
        dto.setIdAtencion(id);
        Atencion obj = service.update(id, convertToEntity(dto));
        return ResponseEntity.ok( new GenericResponse<>(200,"success", Arrays.asList(convertToDTO(obj))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        service.delete(id);
        return  ResponseEntity.noContent().build();
    }

    private AtencionDTO convertToDTO(Atencion obj){
        return modelMapper.map(obj, AtencionDTO.class);
    }

    private Atencion convertToEntity(AtencionDTO dto){
        return modelMapper.map(dto, Atencion.class);
    }

}
