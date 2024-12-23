package com.elp.service.impl;

import com.elp.repo.IClienteRepo;
import com.elp.repo.IGenericRepo;
import com.elp.service.ICRUD;
import com.elp.service.IClienteService;
import com.elp.model.Cliente;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteServiceImpl extends CRUDImpl<Cliente, Integer> implements IClienteService {

    private final IClienteRepo repo; //injeccion solo los refereridos (final)

    @Override
    protected IGenericRepo<Cliente, Integer> getRepo() {
        return repo;
    }


    /*
    public ClienteServiceImpl(IClienteRepo repo) {
        this.repo = repo;
    }
    */
    /*
    @Override
    public Cliente save(Cliente cliente) {
        return repo.save(cliente);
    }

    @Override
    public Cliente update(Integer id, Cliente cliente) {
        cliente.setIdCliente(id);
        return repo.save(cliente);
    }

    @Override
    public List<Cliente> findAll() {
        return repo.findAll();
    }

    @Override
    public Cliente findById(Integer id) {
        return repo.findById(id).orElse(new Cliente());
    }

    @Override
    public void delete(Integer id) {
         repo.deleteById(id);
    }
    */

}
