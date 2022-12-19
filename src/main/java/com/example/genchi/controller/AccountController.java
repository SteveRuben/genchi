package com.example.genchi.controller;

import com.example.genchi.model.AccountDto;
import com.example.genchi.model.AccountWithBalanceDTO;
import com.example.genchi.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController(value = "v1/account")
@RequestMapping(value = "")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping()
    public ResponseEntity<AccountDto> doCreateAccountWithMinBalance(
            @RequestBody AccountWithBalanceDTO body
            ) throws Exception {
        return ResponseEntity.ok(accountService.doCreateAccountWithMinBalance(body));
    }
}
