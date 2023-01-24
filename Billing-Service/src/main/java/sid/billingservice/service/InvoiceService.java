package sid.billingservice.service;

import sid.billingservice.dto.InvoiceRequest;
import sid.billingservice.dto.InvoiceResponse;

import java.util.List;

public interface InvoiceService {

    InvoiceResponse save(InvoiceRequest invoiceRequest);
    InvoiceResponse getInvoiceById(String invoiceId);
    List<InvoiceResponse> invoiceByCustomerId(String customerId);
    List<InvoiceResponse> allInvoices();
}
