package com.elielsonms.transactionroutineapi.applicationservice.controller;

import com.elielsonms.transactionroutineapi.account.model.Account;
import com.elielsonms.transactionroutineapi.account.service.AccountService;
import com.elielsonms.transactionroutineapi.applicationservice.dto.AccountRequest;
import com.elielsonms.transactionroutineapi.applicationservice.mapper.AccountMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AccountController.class)
class AccountControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @MockBean
    private AccountMapper accountMapper;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void account_creation_succeed() throws Exception {
        final var accountRequest = new AccountRequest("documentNumber");
        final var account = new Account(1L, accountRequest.documentNumber());

        when(accountService.createAccount(accountRequest.documentNumber()))
                .thenReturn(account);

        this.mockMvc
                .perform(post("/accounts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(accountRequest)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();

        verify(accountService).createAccount(accountRequest.documentNumber());
        verify(accountMapper).fromDomainToResponse(account);
    }


    @Test
    void fetch_account_succeed() throws Exception {
        final var account = new Account(1L, "document_number");

        when(accountService.fetchAccount(account.accountId())).thenReturn(account);

        this.mockMvc
                .perform(get("/accounts/:accountId")
                        .param("accountId", account.accountId().toString()))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();


        verify(accountService).fetchAccount(account.accountId());
        verify(accountMapper).fromDomainToResponse(any());
    }

}