package com.elp.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BarberoDTO {
    private Integer idBarbero;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 3, max = 20)
    private String nombreBarbero;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 3, max = 50)
    private String apellidosBarbero;

    @Min(1)
    private Integer anioExperienciaBarbero;
    @NotNull
    private boolean estadoBarbero;
}
