package com.elp.service;

import com.elp.model.Cliente;

import java.util.List;

public interface ICRUD<T, ID> {

    T save(T t);
    T update(ID id, T t);
    List<T> findAll();
    T findById(ID id);
    void delete(ID id);
}
