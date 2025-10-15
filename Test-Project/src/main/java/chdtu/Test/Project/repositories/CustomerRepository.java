package chdtu.Test.Project.repositories;

import chdtu.Test.Project.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    boolean existsCustomerByFullName(String fullName);
}
