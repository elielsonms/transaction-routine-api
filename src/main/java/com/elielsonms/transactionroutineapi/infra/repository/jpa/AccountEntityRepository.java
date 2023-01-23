package com.elielsonms.transactionroutineapi.infra.repository.jpa;

import com.elielsonms.transactionroutineapi.infra.model.jpa.AccountEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountEntityRepository extends CrudRepository<AccountEntity, Long> {
    Optional<AccountEntity> findByDocumentNumber(String documentNumber);
}
