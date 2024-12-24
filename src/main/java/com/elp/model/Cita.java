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
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCita;

    @Column(nullable = false )
    private LocalDateTime fechaCita;

    @ManyToOne
    @JoinColumn( name = "id_paciente", nullable = false, foreignKey = @ForeignKey(name = "FK_Atencion_Paciente"))
    private Paciente paciente;

    @Column(nullable = false )
    private boolean estado;

    @Column
    private String  observacion;
}
