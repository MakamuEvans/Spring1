package co.ke.makamuevans.jav1.Controllers;

import co.ke.makamuevans.jav1.Models.Service;
import co.ke.makamuevans.jav1.Repositories.ServiceRepository;
import co.ke.makamuevans.jav1.Services.ServiceService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("services")
@Slf4j
public class ServicesController {

    private final ServiceService serviceService;

    @Autowired
    public ServicesController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }


    @GetMapping({"/index", ""})
    public String index(Model model) {
        model.addAttribute("services", serviceService.findAllDesc());
        return "services/index";
    }

    @GetMapping(value = "/create")
    public String create(Model model) {
        Service service = new Service();
        model.addAttribute("service", service);
        return "services/create";
    }

    @PostMapping({"store"})
    public String store(@ModelAttribute("service") Service service) {
        serviceService.save(service);
        return "redirect:/services/create";
    }

    @GetMapping({"{id}"})
    public String view(@PathVariable("id") Long id, Model model) {
        Optional<Service> service = serviceService.findById(id);
        if (service.isPresent())
            model.addAttribute("service", service.get());
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "hahahah");
        return "services/view";
    }
}
