package com.elp.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    private Integer idCliente;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 3, max = 20)
    private String nombreCliente;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 3, max = 50)
    private String apellidosCliente;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 8, max = 8)
    private String dniCliente;

    private Integer edadCliente;
}
