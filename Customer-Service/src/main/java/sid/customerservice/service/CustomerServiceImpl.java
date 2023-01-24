package sid.customerservice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sid.customerservice.dto.CustomerRequest;
import sid.customerservice.dto.CustomerResponse;
import sid.customerservice.mapper.CustomerMapper;
import sid.customerservice.model.Customer;
import sid.customerservice.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponse saveCustomer(CustomerRequest customerRequest) {

        Customer customer = customerMapper.customerRequestToCustomer(customerRequest);
        Customer savedCustomer = customerRepository.save(customer);
        CustomerResponse customerResponse = customerMapper.customerToCustomerResponse(savedCustomer);

        return customerResponse;
    }

    @Override
    public CustomerResponse getCustomer(String id) {
        Customer customer = customerRepository.findById(id).get();
        CustomerResponse customerResponse = customerMapper.customerToCustomerResponse(customer);
        return customerResponse;
    }

    @Override
    public CustomerResponse updateCustomer(CustomerRequest customerRequest) {
        Customer customer = customerMapper.customerRequestToCustomer(customerRequest);
        Customer updatedCustomer = customerRepository.save(customer);
        CustomerResponse customerResponse = customerMapper.customerToCustomerResponse(updatedCustomer);
        return customerResponse;
    }

    @Override
    public List<CustomerResponse> getCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerResponse> customerResponses = customerList.stream().map(
                customer -> customerMapper.customerToCustomerResponse(customer)
        ).collect(Collectors.toList());
        return customerResponses;
    }
}
