package sid.customerservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sid.customerservice.dto.CustomerRequest;
import sid.customerservice.service.CustomerService;
import sid.customerservice.service.CustomerServiceImpl;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
     CommandLineRunner start(CustomerService customerService){
        return args -> {
            customerService.saveCustomer(new CustomerRequest("C01","John","john23@outlook.com"));
            customerService.saveCustomer(new CustomerRequest("C02","Luke","luke44@gmail.com"));
            customerService.saveCustomer(new CustomerRequest("C03","Ethan","ethan@outlook.com"));
        };
     }
}
