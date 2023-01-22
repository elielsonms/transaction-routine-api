package com.elielsonms.transactionroutineapi.infra.mapper;

import com.elielsonms.transactionroutineapi.account.model.Account;
import com.elielsonms.transactionroutineapi.infra.model.jpa.AccountEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    Account fromJpaToDomain(AccountEntity accountEntity);

    AccountEntity fromDomainToJpa(Account account);
}
