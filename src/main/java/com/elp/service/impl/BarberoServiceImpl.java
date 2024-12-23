package com.elp.service.impl;

import com.elp.model.Barbero;
import com.elp.repo.IBarberoRepo;
import com.elp.repo.IGenericRepo;
import com.elp.service.IBarberoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BarberoServiceImpl extends CRUDImpl<Barbero, Integer> implements IBarberoService {

    private final IBarberoRepo repo; //injeccion solo los refereridos (final)

    @Override
    protected IGenericRepo<Barbero, Integer> getRepo() {
        return repo;
    }
}
