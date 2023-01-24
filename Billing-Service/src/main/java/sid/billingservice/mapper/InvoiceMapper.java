package sid.billingservice.mapper;

import org.mapstruct.Mapper;
import sid.billingservice.dto.InvoiceRequest;
import sid.billingservice.dto.InvoiceResponse;
import sid.billingservice.model.Invoice;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {

    Invoice fromRequestToInvoice(InvoiceRequest invoiceRequest);
    InvoiceResponse fromInvoiceToResponse(Invoice invoice);
}
