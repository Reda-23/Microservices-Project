package sid.customerservice.controller;

import org.springframework.web.bind.annotation.*;
import sid.customerservice.dto.CustomerRequest;
import sid.customerservice.dto.CustomerResponse;
import sid.customerservice.service.CustomerServiceImpl;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api")
public class CustomerController {

    private final CustomerServiceImpl customerService;


    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @PostMapping(path = "/customer")
    CustomerResponse saveCustomer(@RequestBody CustomerRequest customerRequest){
        customerRequest.setId(UUID.randomUUID().toString());
        return customerService.saveCustomer(customerRequest);
    }

    @GetMapping(path = "/customers")
    List<CustomerResponse> listAllCustomers(){
        return customerService.getCustomers();
    }

    @PutMapping(path = "/")
    CustomerResponse updateCustomer(@RequestBody CustomerRequest customerRequest){
        return customerService.updateCustomer(customerRequest);
    }

    @GetMapping(path = "/customers/{id}")
    CustomerResponse getCustomer(@PathVariable String id){
            return customerService.getCustomer(id);
    }
}
