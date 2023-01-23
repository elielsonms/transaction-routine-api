package com.elielsonms.transactionroutineapi.applicationservice.controller;

import com.elielsonms.transactionroutineapi.account.service.AccountService;
import com.elielsonms.transactionroutineapi.applicationservice.dto.AccountRequest;
import com.elielsonms.transactionroutineapi.applicationservice.dto.AccountResponse;
import com.elielsonms.transactionroutineapi.applicationservice.mapper.AccountMapper;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.*;

@RestController
public class AccountController {

    public AccountController(
            AccountService accountService,
            AccountMapper accountMapper) {
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }
    private final AccountService accountService;
    private final AccountMapper accountMapper;

    @PostMapping("/accounts")
    public HttpEntity<AccountResponse> createAccount(@Valid @RequestBody AccountRequest accountRequest){
        final var createdAccount = accountService.createAccount(accountRequest.documentNumber());
        if (createdAccount == null) {
            return badRequest().build();
        }
        return ResponseEntity.status(CREATED).body(accountMapper.fromDomainToResponse(createdAccount));
    }

    @GetMapping("/accounts/:accountId")
    public HttpEntity<AccountResponse> fetchAccount(@PathParam("accountId") Long accountId) {
        final var account = accountService.fetchAccount(accountId);
        if (account == null) {
            return notFound().build();
        }
        return ok(accountMapper.fromDomainToResponse(account));
    }
}
