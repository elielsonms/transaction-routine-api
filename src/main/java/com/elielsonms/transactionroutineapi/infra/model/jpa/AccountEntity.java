package com.elielsonms.transactionroutineapi.infra.model.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Accounts")
public class AccountEntity {
    @Id
    @Column(name = "Account_ID")
    private Long accountId;

    @Column(name = "Document_Number")
    private String documentNumber;
}
