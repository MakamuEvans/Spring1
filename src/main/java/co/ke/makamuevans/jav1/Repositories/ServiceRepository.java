package co.ke.makamuevans.jav1.Repositories;

import co.ke.makamuevans.jav1.Models.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
