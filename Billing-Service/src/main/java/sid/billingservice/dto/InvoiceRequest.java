package sid.billingservice.dto;




import java.math.BigDecimal;


public class InvoiceRequest {


    private BigDecimal amount;
    private String customerId;

    public InvoiceRequest() {
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public InvoiceRequest(BigDecimal amount, String customerId) {
        this.amount = amount;
        this.customerId = customerId;
    }
}