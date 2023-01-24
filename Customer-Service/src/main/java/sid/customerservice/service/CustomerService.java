package sid.customerservice.service;

import sid.customerservice.dto.CustomerRequest;
import sid.customerservice.dto.CustomerResponse;

import java.util.List;

public interface CustomerService {

    CustomerResponse saveCustomer(CustomerRequest customerRequest);
    CustomerResponse getCustomer(String id);
    CustomerResponse updateCustomer(CustomerRequest customerRequest);
    List<CustomerResponse> getCustomers();
}
