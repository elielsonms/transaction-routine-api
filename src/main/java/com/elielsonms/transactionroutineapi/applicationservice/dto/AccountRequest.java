package com.elielsonms.transactionroutineapi.applicationservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;

public record AccountRequest(
        @NotEmpty @JsonProperty("document_number") String documentNumber) {
}
