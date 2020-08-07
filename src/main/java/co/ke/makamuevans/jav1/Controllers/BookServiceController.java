package co.ke.makamuevans.jav1.Controllers;

import co.ke.makamuevans.jav1.Models.Booking;
import co.ke.makamuevans.jav1.Models.Commands.AttendeeAction;
import co.ke.makamuevans.jav1.Models.Commands.BookingAction;
import co.ke.makamuevans.jav1.Models.Service;
import co.ke.makamuevans.jav1.Services.BookingService;
import co.ke.makamuevans.jav1.Services.ServiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
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

    @GetMapping({"/book-service"})
    public String bookService(Model model){
        model.addAttribute("booking", new BookingAction());
        model.addAttribute("services", serviceService.findAllByStatus(true));
        return "book-service1";
    }

    @PostMapping({"/book-service"})
    public String saveService(@ModelAttribute("booking") BookingAction bookingAction){
        Optional<Service> service = serviceService.findById(bookingAction.getService_id());
        if (!service.isPresent())
            return "redirect:/book-service"; //TODO add error message
        for (AttendeeAction attendee:bookingAction.getAttendees()) {
            Booking booking = new Booking(service.get(),attendee.getPhone(),"101", attendee.getNames());
            bookingService.save(booking);
        }
        return "redirect:/book-service";
    }
}
