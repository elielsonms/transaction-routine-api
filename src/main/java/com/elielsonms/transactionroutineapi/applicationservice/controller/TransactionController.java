package com.elielsonms.transactionroutineapi.applicationservice.controller;

import com.elielsonms.transactionroutineapi.applicationservice.dto.TransactionRequest;
import com.elielsonms.transactionroutineapi.applicationservice.dto.TransactionResponse;
import com.elielsonms.transactionroutineapi.applicationservice.mapper.TransactionMapper;
import com.elielsonms.transactionroutineapi.transaction.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.badRequest;

@RestController
public class TransactionController {
    public TransactionController(
            TransactionMapper transactionMapper,
            TransactionService transactionService) {
        this.transactionMapper = transactionMapper;
        this.transactionService = transactionService;
    }

    private final TransactionMapper transactionMapper;
    private final TransactionService transactionService;

    @PostMapping("/transactions")
    public HttpEntity<TransactionResponse> createTransaction(@Valid @RequestBody TransactionRequest transactionRequest) {
        final var createdTransaction = transactionService.createTransaction(
                transactionRequest.accountId(),
                transactionRequest.operationTypeId(),
                transactionRequest.amount());
        if (createdTransaction == null) {
            return badRequest().build();
        }
        return ResponseEntity
                .status(CREATED)
                .body(transactionMapper.fromDomainToResponse(createdTransaction));
    }
}
