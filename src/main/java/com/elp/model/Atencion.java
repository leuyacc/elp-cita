package com.elp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Atencion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAtencion;

    @Column(nullable = false )
    private LocalDateTime fechaAtencion;

    @ManyToOne
    @JoinColumn( name = "id_cliente", nullable = false, foreignKey = @ForeignKey(name = "FK_Atencion_Cliente"))
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_barbero", nullable = false, foreignKey = @ForeignKey(name = "FK_Atencion_Barbero"))
    private Barbero barbero;

    private String tipoCorte;
    @Column(nullable = false )
    private boolean estado;
}
