package com.elp.dto;

import com.elp.model.Paciente;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitaDTO {

    private Integer id;

    @NotNull
    private LocalDateTime fecha;

    @NotNull
    private Paciente paciente;

    @NotNull
    private boolean estado;

    private String  observacion;
}
