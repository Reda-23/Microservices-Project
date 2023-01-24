package sid.customerservice.mapper;

import org.mapstruct.Mapper;
import sid.customerservice.dto.CustomerRequest;
import sid.customerservice.dto.CustomerResponse;
import sid.customerservice.model.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerResponse customerToCustomerResponse(Customer customer);
    Customer customerRequestToCustomer(CustomerRequest customerRequest);
}
