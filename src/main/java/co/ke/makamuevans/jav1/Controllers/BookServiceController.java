package co.ke.makamuevans.jav1.Controllers;

import co.ke.makamuevans.jav1.Models.Booking;
import co.ke.makamuevans.jav1.Models.Commands.AttendeeCommand;
import co.ke.makamuevans.jav1.Models.Commands.BookingCommand;
import co.ke.makamuevans.jav1.Models.Service;
import co.ke.makamuevans.jav1.Services.BookingService;
import co.ke.makamuevans.jav1.Services.ServiceService;
import co.ke.makamuevans.jav1.utilities.Helpers.ElmHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class BookServiceController {

    private final BookingService bookingService;
    private final ServiceService serviceService;

    public BookServiceController(BookingService bookingService, ServiceService serviceService) {
        this.bookingService = bookingService;
        this.serviceService = serviceService;
    }

    @ModelAttribute("services")
    public List<Service> services(){
        return serviceService.findAllByStatus(true);
    }

    @GetMapping({"/book-service"})
    public String bookService(Model model){
        model.addAttribute("booking", new BookingCommand());
        //model.addAttribute("services", serviceService.findAllByStatus(true));
        return "book-service1";
    }

    @PostMapping({"/book-service"})
    public String saveService(@Valid @ModelAttribute("booking") BookingCommand bookingAction, BindingResult bindingResult,
                              RedirectAttributes redirectAttributes){
        log.error(bookingAction.toString());
        if (bindingResult.hasErrors()){
            return "book-service1";
        }
        Optional<Service> service = serviceService.findById(bookingAction.getService_id());
        if (!service.isPresent())
            return "redirect:/book-service"; //TODO add error message
        String uuid = ElmHelper.generateUUID(false);
        for (AttendeeCommand attendee:bookingAction.getAttendees()) {
            Booking booking = new Booking(service.get(),attendee.getPhone(),uuid, attendee.getNames());
            bookingService.save(booking);
        }
        redirectAttributes.addFlashAttribute("message", "Booking successfully received!");
        return "redirect:/book-service";
    }
}
