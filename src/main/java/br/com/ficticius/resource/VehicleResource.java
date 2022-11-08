package br.com.ficticius.resource;

import br.com.ficticius.model.Vehicle;
import br.com.ficticius.resource.core.BaseResource;
import br.com.ficticius.service.VehicleService;
import br.com.ficticius.service.core.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicles")
public class VehicleResource extends BaseResource<Vehicle> {

    @Autowired
    private VehicleService vehicleService;

    @Override
    public IService getService() {
        return vehicleService;
    }

}
