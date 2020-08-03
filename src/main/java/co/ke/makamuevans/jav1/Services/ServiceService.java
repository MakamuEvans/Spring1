package co.ke.makamuevans.jav1.Services;

import co.ke.makamuevans.jav1.Models.Service;
import co.ke.makamuevans.jav1.Repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;


@org.springframework.stereotype.Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    public Optional<Service> findById(Long id){
        return serviceRepository.findById(id);
    }

    public List<Service> findAll(){
        return serviceRepository.findAll();
    }

    public List<Service> findAllDesc(){
        return serviceRepository.findAllByOrderByIdDesc();
    }

    public Service save(Service service){
        serviceRepository.save(service);
        return service;
    }
}
