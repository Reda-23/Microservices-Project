package sid.billingservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import sid.billingservice.dto.InvoiceRequest;
import sid.billingservice.service.InvoiceService;

import java.math.BigDecimal;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }



    @Bean
    CommandLineRunner start(InvoiceService invoiceService){
        return args -> {
            invoiceService.save(new InvoiceRequest(BigDecimal.valueOf(4325),"C01"));
            invoiceService.save(new InvoiceRequest(BigDecimal.valueOf(7786),"C02"));
            invoiceService.save(new InvoiceRequest(BigDecimal.valueOf(6213),"C03"));
        };
    }

}
