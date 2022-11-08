package br.com.ficticius.service;

import br.com.ficticius.model.Vehicle;
import br.com.ficticius.repository.VehicleRepository;
import br.com.ficticius.service.core.BaseService;
import br.com.ficticius.service.core.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService extends BaseService<Vehicle> implements IService<Vehicle> {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public JpaRepository getRepository() {
        return vehicleRepository;
    }

    @Override
    public void validateEntity(Vehicle obj) {

    }

    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }
}
