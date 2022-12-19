package com.example.genchi.service;

import com.example.genchi.entities.Account;
import com.example.genchi.entities.Customer;
import com.example.genchi.model.AccountDto;
import com.example.genchi.model.AccountWithBalanceDTO;
import com.example.genchi.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountService {

    private final CustomerService customerService;
    private final CustomerRepository customerRepository;

    public AccountService(CustomerService customerService, CustomerRepository customerRepository) {
        this.customerService = customerService;
        this.customerRepository = customerRepository;
    }

    public AccountDto doCreateAccountWithMinBalance(AccountWithBalanceDTO body) throws Exception {
        Customer customer = customerService.doFindCustomer(body.getCustomerId());
        Account account = new Account();
        account.setInitialCredit(new BigDecimal(body.getInitialCredit()));
        customer.getAccounts().add(account);
        this.customerRepository.save(customer);
    }
}
