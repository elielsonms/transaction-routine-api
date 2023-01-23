package com.elielsonms.transactionroutineapi.infra.model.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "OperationTypes")
public class OperationType {

    @Id
    @Column(name = "OperationType_ID")
    private Integer operationTypeId;

    @Column(name = "Description")
    private String description;

    @NotNull
    @Column(name = "OperacaoCredito")
    private Boolean creditOperation;

    public Integer getOperationTypeId() {
        return operationTypeId;
    }

    public void setOperationTypeId(Integer operationTypeId) {
        this.operationTypeId = operationTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCreditOperation() {
        return creditOperation;
    }

    public void setCreditOperation(Boolean creditOperation) {
        this.creditOperation = creditOperation;
    }
}
