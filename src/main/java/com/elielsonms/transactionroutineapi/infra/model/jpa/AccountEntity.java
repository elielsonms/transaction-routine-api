package com.elielsonms.transactionroutineapi.infra.model.jpa;

import jakarta.persistence.*;

@Entity
@Table(name = "Accounts")
public class AccountEntity {
    @Id
    @GeneratedValue
    @Column(name = "Account_ID")
    private Long accountId;

    @Column(name = "Document_Number")
    private String documentNumber;


    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }
}
