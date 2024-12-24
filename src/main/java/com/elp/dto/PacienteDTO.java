package com.elp.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteDTO {

    private Integer id;

    @NotNull
    private String nombresPaciente;

    @NotNull
    private String apellidosPaciente;

    @NotNull
    private String dni;

    @NotNull
    private Integer edad;

}
