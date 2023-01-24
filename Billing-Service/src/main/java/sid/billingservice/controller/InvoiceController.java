package sid.billingservice.controller;

import org.springframework.web.bind.annotation.*;
import sid.billingservice.dto.InvoiceRequest;
import sid.billingservice.dto.InvoiceResponse;
import sid.billingservice.service.InvoiceServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InvoiceController {

    private final InvoiceServiceImpl invoiceService;

    public InvoiceController(InvoiceServiceImpl invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/invoices/{id}")
    InvoiceResponse getInvoice(@PathVariable(name = "id") String id) {
        return invoiceService.getInvoiceById(id);
    }

    @GetMapping("/invoiceByCustomer/{customerId}")
    List<InvoiceResponse> invoiceByCustomer (@PathVariable(name = "customerId") String customerId){
        return invoiceService.invoiceByCustomerId(customerId);
    }

    @PostMapping(path = "/invoices")
    InvoiceResponse save (@RequestBody InvoiceRequest invoiceRequest){
        return invoiceService.save(invoiceRequest);
    }

    @GetMapping("/invoices")
    List<InvoiceResponse> allInvoices(){
        return invoiceService.allInvoices();
    }
}
