package com.example.genchi.service;

import com.example.genchi.entities.Account;
import com.example.genchi.entities.Customer;
import com.example.genchi.model.AccountDto;
import com.example.genchi.model.AccountWithBalanceDTO;
import com.example.genchi.repository.AccountRepository;
import com.example.genchi.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountService {

    private final CustomerService customerService;
    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;

    public AccountService(CustomerService customerService, CustomerRepository customerRepository, AccountRepository accountRepository) {
        this.customerService = customerService;
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
    }

    public AccountDto doCreateAccountWithMinBalance(AccountWithBalanceDTO body) throws Exception {
        Customer customer = customerService.doFindCustomer(body.getCustomerId());
        Account account = new Account();
        account.setInitialCredit(new BigDecimal(body.getInitialCredit()));
        account.setCustomer(customer);
        accountRepository.save(account);
        return new AccountDto(account.getId(), account.getAccountNumber() ,account.getInitialCredit(), BigDecimal.ZERO);
    }
}
