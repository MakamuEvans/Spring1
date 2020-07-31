package co.ke.makamuevans.jav1.Controllers;

import co.ke.makamuevans.jav1.Models.Service;
import co.ke.makamuevans.jav1.Repositories.ServiceRepository;
import co.ke.makamuevans.jav1.Services.ServiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.Optional;

@Controller
@RequestMapping("services")
public class ServicesController {

    private final ServiceService serviceService;
    Logger logger = LoggerFactory.getLogger(ServicesController.class);

    @Autowired
    public ServicesController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }


    @GetMapping({"/index", ""})
    public String index(Model model){
        Optional<Service> service = serviceService.findById(1L);
        logger.error(service.get().getFormattedStatus());
        model.addAttribute("services", serviceService.getAll());
        return "services/index";
    }

    @GetMapping(value = "/create")
    public String create(Model model){
        Service service = new Service();
        model.addAttribute("service", service);
        return "services/create";
    }

    @PostMapping(value = {"store"})
    public String store(@ModelAttribute("service") Service service){
        serviceService.save(service);
        return "redirect:/services/create";
    }
}
