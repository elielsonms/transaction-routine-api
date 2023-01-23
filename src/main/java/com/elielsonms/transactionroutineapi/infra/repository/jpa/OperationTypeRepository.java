package com.elielsonms.transactionroutineapi.infra.repository.jpa;

import com.elielsonms.transactionroutineapi.infra.model.jpa.OperationType;
import org.springframework.data.repository.CrudRepository;

public interface OperationTypeRepository extends CrudRepository<OperationType, Integer> {

}
