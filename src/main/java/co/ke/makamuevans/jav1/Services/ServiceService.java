package co.ke.makamuevans.jav1.Services;

import co.ke.makamuevans.jav1.Models.Service;
import co.ke.makamuevans.jav1.Repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


@org.springframework.stereotype.Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    public Optional<Service> findById(Long id){
        return serviceRepository.findById(id);
    }

    public List<Service> getAll(){
        return serviceRepository.findAll();
    }

    public Service save(Service service){
        serviceRepository.save(service);
        return service;
    }
}
