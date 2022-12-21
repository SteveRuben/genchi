package com.example.genchi.service;

import com.example.genchi.entities.Account;
import com.example.genchi.entities.Customer;
import com.example.genchi.entities.User;
import com.example.genchi.model.AccountDto;
import com.example.genchi.model.CustomerDto;
import com.example.genchi.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerDto doRetrieveCustomer(String customerId) throws Exception{
        return toCustomerDto(doFindCustomer(customerId));
    }

    public Customer doFindCustomer(String customerId) throws Exception{
        Optional<Customer> customer =  customerRepository.findById(Long.getLong(customerId));
        if(customer.isPresent()){
            return customer.get();
        }
        throw new Exception("User not found");
    }

    private CustomerDto toCustomerDto(Customer customer) {
        CustomerDto dto = new CustomerDto();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setSurName(customer.getSurName());
        dto.setAccounts(customer.getAccounts().stream().map(this::toAccountDto).collect(Collectors.toSet()));
        return dto;
    }

    private AccountDto toAccountDto(Account account) {
        AccountDto dto = new AccountDto();
        dto.setAccountNumber(account.getAccountNumber());
        dto.setInitialCredit(account.getInitialCredit());
        return dto;
    }

}
