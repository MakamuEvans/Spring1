package co.ke.makamuevans.jav1.Services;

import co.ke.makamuevans.jav1.Repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    public co.ke.makamuevans.jav1.Models.Service save(co.ke.makamuevans.jav1.Models.Service service){
        serviceRepository.save(service);
        return service;
    }
}
