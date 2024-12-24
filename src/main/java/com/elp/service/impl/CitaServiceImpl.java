package com.elp.service.impl;

import com.elp.model.Cita;
import com.elp.repo.ICitaRepo;
import com.elp.repo.IGenericRepo;
import com.elp.service.ICitaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CitaServiceImpl extends CRUDImpl<Cita, Integer> implements ICitaService {
    private final ICitaRepo repo; //injeccion solo los refereridos (final)

    @Override
    protected IGenericRepo<Cita, Integer> getRepo() {
        return repo;
    }
}
