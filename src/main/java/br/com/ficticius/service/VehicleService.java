package br.com.ficticius.service;

import br.com.ficticius.model.VehicleModel;
import br.com.ficticius.repository.VehicleRepository;
import br.com.ficticius.service.core.BaseService;
import br.com.ficticius.service.core.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService extends BaseService<VehicleModel> implements IService<VehicleModel> {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public JpaRepository getRepository() {
        return vehicleRepository;
    }

    @Override
    public void validateEntity(VehicleModel obj) {

    }

    @Override
    public List<VehicleModel> findAll() {
        return vehicleRepository.findAll();
    }
}
