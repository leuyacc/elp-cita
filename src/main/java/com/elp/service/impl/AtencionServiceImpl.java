package com.elp.service.impl;

import com.elp.model.Atencion;
import com.elp.repo.IAtencionRepo;
import com.elp.repo.IGenericRepo;
import com.elp.service.IAtencionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AtencionServiceImpl extends CRUDImpl<Atencion,Integer> implements IAtencionService {

    private final IAtencionRepo repo; //injeccion solo los refereridos (final)

    @Override
    protected IGenericRepo<Atencion, Integer> getRepo() {
        return repo;
    }

}
