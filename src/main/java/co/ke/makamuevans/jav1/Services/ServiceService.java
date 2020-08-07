package co.ke.makamuevans.jav1.Services;

import co.ke.makamuevans.jav1.Models.QService;
import co.ke.makamuevans.jav1.Models.Service;
import co.ke.makamuevans.jav1.Repositories.ServiceRepository;
import co.ke.makamuevans.jav1.utilities.Constants;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@org.springframework.stereotype.Service
public class ServiceService {

    private final ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public Optional<Service> findById(Long id){
        return serviceRepository.findById(id);
    }

    public List<Service> findAllByStatus(Boolean status){
        return serviceRepository.findAllByStatus(status);
    }

    public Page<Service> findAll(Map<String, String> params){
        int page = params.containsKey("page") ? Integer.parseInt(params.get("page")) : 1;
        Pageable pageable = PageRequest.of(page - 1, Constants.PER_PAGE);
        QService qService = QService.service;
        //BooleanExpression booleanExpression = ;
        BooleanBuilder queryBuilder = new BooleanBuilder();
        if (params.containsKey("title") && params.get("title").length() > 0)
            queryBuilder.and(qService.title.contains(params.get("title")));
        Predicate predicate = queryBuilder.getValue();
        return predicate != null ?
                serviceRepository.findAll(predicate, pageable) :
                serviceRepository.findAll(pageable);
    }

    /*public Page<Service> findAllDesc(Pageable pageable){
        //Service serviceQuery = Service.builder().title("Template One1").build();
        //return serviceRepository.findAllByOrderByIdDesc();
    }*/

    public Service save(Service service){
        serviceRepository.save(service);
        return service;
    }
}
