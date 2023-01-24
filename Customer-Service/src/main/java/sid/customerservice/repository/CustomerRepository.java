package sid.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sid.customerservice.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {
}
