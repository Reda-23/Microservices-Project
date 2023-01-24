package sid.billingservice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sid.billingservice.dto.InvoiceRequest;
import sid.billingservice.dto.InvoiceResponse;
import sid.billingservice.mapper.InvoiceMapper;
import sid.billingservice.model.Customer;
import sid.billingservice.model.Invoice;
import sid.billingservice.openfeign.CustomerRestClient;
import sid.billingservice.repository.InvoiceRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;
    private final CustomerRestClient client;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper, CustomerRestClient client) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
        this.client = client;
    }

    @Override
    public InvoiceResponse save(InvoiceRequest invoiceRequest) {
        Invoice invoice = invoiceMapper.fromRequestToInvoice(invoiceRequest);
        invoice.setId(UUID.randomUUID().toString());
        Invoice savedInvoice = invoiceRepository.save(invoice);
        return invoiceMapper.fromInvoiceToResponse(savedInvoice);
    }

    @Override
    public InvoiceResponse getInvoiceById(String invoiceId) {
        Invoice invoice = invoiceRepository.findById(invoiceId).get();
        Customer customer = client.getCustomerById(invoice.getCustomerId());
        invoice.setCustomer(customer);
        return invoiceMapper.fromInvoiceToResponse(invoice);
    }

    @Override
    public List<InvoiceResponse> invoiceByCustomerId(String customerId) {
        List<Invoice> invoices = invoiceRepository.findByCustomerId(customerId);
        for (Invoice invoice: invoices){
            Customer customer = client.getCustomerById(invoice.getCustomerId());
            invoice.setCustomer(customer);
        }
        return invoices.stream().map(invoice ->
            invoiceMapper.fromInvoiceToResponse(invoice)
        ).collect(Collectors.toList());
    }

    @Override
    public List<InvoiceResponse> allInvoices() {
        List<Invoice> invoices = invoiceRepository.findAll();
        for (Invoice invoice: invoices){
           Customer customer = client.getCustomerById(invoice.getCustomerId());
            invoice.setCustomer(customer);
        }
        return invoices.stream().map(
                invoice -> invoiceMapper.fromInvoiceToResponse(invoice)
        ).collect(Collectors.toList());
    }
}
