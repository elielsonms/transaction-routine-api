package com.elielsonms.transactionroutineapi.infra.mapper;

import com.elielsonms.transactionroutineapi.infra.model.jpa.TransactionEntity;
import com.elielsonms.transactionroutineapi.transaction.model.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionEntityMapper {

    Transaction fromJpaToDomain(TransactionEntity transactionEntity);

    TransactionEntity fromDomainToJpa(Transaction transaction);
}
