package co.ke.makamuevans.jav1.Repositories;

import co.ke.makamuevans.jav1.Models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BookingRepository extends JpaRepository<Booking, Long>, QuerydslPredicateExecutor {
}
