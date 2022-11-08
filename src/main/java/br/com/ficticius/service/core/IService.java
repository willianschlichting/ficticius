package br.com.ficticius.service.core;

import java.util.List;

public interface IService<T> {
    T add(T obj);

    T update(T obj);

    void delete(String obj);

    List<T> findAll();
}
