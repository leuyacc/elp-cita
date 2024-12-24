package com.elp.service.impl;

import com.elp.model.Cita;
import com.elp.model.Paciente;
import com.elp.repo.ICitaRepo;
import com.elp.repo.IGenericRepo;
import com.elp.repo.IPacienteRepo;
import com.elp.service.IPacienteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PacienteServiceImpl extends CRUDImpl<Paciente, Integer> implements IPacienteService {
    private final IPacienteRepo repo; //injeccion solo los refereridos (final)

    @Override
    protected IGenericRepo<Paciente, Integer> getRepo() {
        return repo;
    }
}
