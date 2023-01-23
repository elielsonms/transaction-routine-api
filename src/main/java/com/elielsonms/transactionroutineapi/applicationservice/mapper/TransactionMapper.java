package com.elielsonms.transactionroutineapi.applicationservice.mapper;

import com.elielsonms.transactionroutineapi.applicationservice.dto.TransactionResponse;
import com.elielsonms.transactionroutineapi.transaction.model.Transaction;
import org.mapstruct.Mapper;

@Mapper( componentModel = "spring")
public interface TransactionMapper {
    TransactionResponse fromDomainToResponse(Transaction transaction);
}
