package com.elielsonms.transactionroutineapi.applicationservice.controller;

import com.elielsonms.transactionroutineapi.applicationservice.dto.TransactionRequest;
import com.elielsonms.transactionroutineapi.applicationservice.mapper.TransactionMapper;
import com.elielsonms.transactionroutineapi.transaction.service.TransactionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = TransactionController.class)
class TransactionControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    TransactionMapper transactionMapper;
    @MockBean
    TransactionService transactionService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void transaction_creation_succeed() throws Exception {
        final var transactionRequest = new TransactionRequest(1L, 1, BigDecimal.TEN);

        this.mockMvc
                .perform(post("/transactions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(transactionRequest)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();

        verify(transactionService).createTransaction(
                transactionRequest.accountId(),
                transactionRequest.operationTypeId(),
                transactionRequest.amount());

        verify(transactionMapper).fromDomainToResponse(any());

    }

}