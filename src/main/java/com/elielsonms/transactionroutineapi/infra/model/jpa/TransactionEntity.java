package com.elielsonms.transactionroutineapi.infra.model.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "Transactions")
public class TransactionEntity {

    @Id
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

}
