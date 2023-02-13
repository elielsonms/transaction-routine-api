package com.elielsonms.transactionroutineapi.applicationservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;

import java.math.BigDecimal;

public record AccountRequest(
        @NotEmpty @JsonProperty("document_number") String documentNumber, @JsonProperty("available_credit_limit") BigDecimal availableCreditLimit) {
}
