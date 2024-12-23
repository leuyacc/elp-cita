package com.elp.dto;

import com.elp.model.Barbero;
import com.elp.model.Cliente;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtencionDTO {
    private Integer idAtencion;

    @NotNull
    private LocalDateTime fechaAtencion;

    @NotNull
    private Cliente cliente;
    @NotNull
    private Barbero barbero;
    @NotNull
    private String tipoCorte;
    @NotNull
    private boolean estadoAtencion;
}
