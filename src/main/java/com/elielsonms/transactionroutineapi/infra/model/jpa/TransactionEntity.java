package com.elielsonms.transactionroutineapi.infra.model.jpa;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "Transactions")
public class TransactionEntity {

    @Id
    @GeneratedValue
    @Column(name="Transaction_ID")
    private Long transactionId;

    @Column(name="Account_ID")
    private Long accountId;

    @Column(name="OperationType_ID")
    private Integer operationTypeId;

    @Column(name="Amount")
    private BigDecimal amount;

    @Column(name = "EventDate")
    private OffsetDateTime eventDate;

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Integer getOperationTypeId() {
        return operationTypeId;
    }

    public void setOperationTypeId(Integer operationTypeId) {
        this.operationTypeId = operationTypeId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public OffsetDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(OffsetDateTime eventDate) {
        this.eventDate = eventDate;
    }
}
