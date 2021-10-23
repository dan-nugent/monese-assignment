package co.uk.monese.assignment.pojos;

import java.math.BigDecimal;

public class TransactionRequest {

    private Integer senderId;

    private Integer recipientId;

    private BigDecimal amount;

    public TransactionRequest() {
    }

    public TransactionRequest(Integer senderId, Integer recipientId, BigDecimal amount) {
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.amount = amount;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public Integer getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Integer recipientId) {
        this.recipientId = recipientId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
