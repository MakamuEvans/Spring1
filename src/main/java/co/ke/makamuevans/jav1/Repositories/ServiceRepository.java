package co.ke.makamuevans.jav1.Repositories;

import co.ke.makamuevans.jav1.Models.Service;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Long>, QuerydslPredicateExecutor {
    public List<Service> findAllByStatus(Boolean status);
}
