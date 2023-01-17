package br.com.ficticius.repository;

import br.com.ficticius.model.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleModel, String> {

    VehicleModel findByPlate(String plate);
}
