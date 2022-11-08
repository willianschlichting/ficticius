package br.com.ficticius.resource.core;

import br.com.ficticius.service.core.IService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseResource<T> {
    public abstract IService getService();

    @GetMapping()
    public List<T> list(){
        return getService().findAll();
    }

    @PostMapping
    public T add(@RequestBody T obj) {
        return (T) getService().add(obj);
    }
    @PutMapping
    public T update(@RequestBody T obj) {
        return (T) getService().update(obj);
    }

    @DeleteMapping("{oid}")
    public void delete(@PathVariable("oid") String oid) {
        getService().delete(oid);
    }
}
