package br.com.ficticius.service.core;

import br.com.ficticius.model.core.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public abstract class BaseService<T> implements Serializable {

    public abstract JpaRepository getRepository();

    public abstract void validateEntity(T obj);

    public T add(T obj) {
        validateEntity(obj);
        return (T) getRepository().save(obj);
    }

    public T update(T obj) {
        validateEntity(obj);
        return (T) getRepository().save(obj);
    }

    public void delete(String oid) {
        getRepository().delete(getRepository().findById(oid));
    }



}
