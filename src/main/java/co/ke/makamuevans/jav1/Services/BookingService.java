package co.ke.makamuevans.jav1.Services;

import co.ke.makamuevans.jav1.Models.Booking;
import co.ke.makamuevans.jav1.Repositories.BookingRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking save(Booking booking){
        return bookingRepository.save(booking);
    }
}
