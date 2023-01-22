package com.elielsonms.transactionroutineapi.infra.repository.jpa;

import com.elielsonms.transactionroutineapi.infra.model.jpa.TransactionEntity;
import org.springframework.data.repository.CrudRepository;

public interface TransactionEntityRepository extends CrudRepository<TransactionEntity, Long>{
}
