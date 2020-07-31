package co.ke.makamuevans.jav1.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("services")
public class ServicesController {


    @GetMapping(value = "/index", name = "services.index")
    public String index(){
        return "services/index";
    }
}
