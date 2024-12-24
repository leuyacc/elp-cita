package com.elp.controller;
import com.elp.dto.GenericResponse;
import com.elp.dto.PacienteDTO;
import com.elp.model.Paciente;
import com.elp.service.IPacienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/paciente")
@RequiredArgsConstructor
public class PacienteController {
    private final IPacienteService service;
    //@Qualifier("pacienteMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<GenericResponse<PacienteDTO>> getAllPaciente(){
        List<PacienteDTO> list = service.findAll().stream().map(this::convertToDTO).toList();
        return  ResponseEntity.ok(new GenericResponse<>(200,"success",list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<PacienteDTO>> getPacienteById(@PathVariable("id") int id){
        Paciente obj = service.findById(id);
        return ResponseEntity.ok(new GenericResponse<>(200,"success", Arrays.asList(convertToDTO(obj))));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody PacienteDTO dto){
        Paciente obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPaciente()).toUri();
        return  ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<PacienteDTO>> update(@PathVariable("id") Integer id ,@Valid @RequestBody PacienteDTO dto){
        dto.setId(id);
        Paciente obj = service.update(id, convertToEntity(dto));
        return ResponseEntity.ok( new GenericResponse<>(200,"success", Arrays.asList(convertToDTO(obj))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private PacienteDTO convertToDTO(Paciente obj){
        return modelMapper.map(obj, PacienteDTO.class);
    }
    private Paciente convertToEntity(PacienteDTO dto){ return modelMapper.map(dto, Paciente.class);
    }


}
