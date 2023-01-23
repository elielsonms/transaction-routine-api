package com.elielsonms.transactionroutineapi.applicationservice.mapper;

import com.elielsonms.transactionroutineapi.account.model.Account;
import com.elielsonms.transactionroutineapi.applicationservice.dto.AccountResponse;
import org.mapstruct.Mapper;

@Mapper( componentModel = "spring")
public interface AccountMapper {
    AccountResponse fromDomainToResponse(Account account);

}
