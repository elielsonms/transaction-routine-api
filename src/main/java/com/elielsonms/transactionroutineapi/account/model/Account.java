package com.elielsonms.transactionroutineapi.account.model;

import java.math.BigDecimal;

public record Account(Long accountId, String documentNumber, BigDecimal availableCreditLimit) {
}
