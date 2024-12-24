package com.elp.controller;

import com.elp.dto.CitaDTO;
import com.elp.dto.GenericResponse;
import com.elp.model.Cita;
import com.elp.service.ICitaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/cita")
@RequiredArgsConstructor
public class CitaController {
    private final ICitaService service;
    //@Qualifier("citaMapper")
    private final ModelMapper modelMapper;

    @Operation(summary = "Listar Citas") @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor") })
    @GetMapping
    public ResponseEntity<GenericResponse<CitaDTO>> getAllCita(){

        List<CitaDTO> list = service.findAll().stream().map(this::convertToDTO).toList();
        return  ResponseEntity.ok(new GenericResponse<>(200,"success",list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<CitaDTO>> getCitaById(@PathVariable("id") int id){
        Cita obj = service.findById(id);
        return ResponseEntity.ok(new GenericResponse<>(200,"success", Arrays.asList(convertToDTO(obj))));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody CitaDTO dto){
        Cita obj = service.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCita()).toUri();
        return  ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<CitaDTO>> update(@PathVariable("id") Integer id ,@Valid @RequestBody CitaDTO dto){
        dto.setId(id);
        Cita obj = service.update(id, convertToEntity(dto));
        return ResponseEntity.ok( new GenericResponse<>(200,"success", Arrays.asList(convertToDTO(obj))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private CitaDTO convertToDTO(Cita obj){
        return modelMapper.map(obj, CitaDTO.class);
    }
    private Cita convertToEntity(CitaDTO dto){ return modelMapper.map(dto, Cita.class);
    }
}
