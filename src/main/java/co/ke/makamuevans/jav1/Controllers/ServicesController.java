package co.ke.makamuevans.jav1.Controllers;

import co.ke.makamuevans.jav1.Models.Service;
import co.ke.makamuevans.jav1.Services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("services")
public class ServicesController {

    public final ServiceService serviceService;

    @Autowired
    public ServicesController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }


    @GetMapping(value = {"/index"}, name = "services.index")
    public String index(){
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
        System.out.println("We here");
        serviceService.save(service);

        return "redirect:/services/create";
    }
}
