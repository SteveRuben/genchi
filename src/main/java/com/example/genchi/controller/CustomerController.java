package com.example.genchi.controller;

import com.example.genchi.model.CustomerDto;
import com.example.genchi.service.CustomerService;
import com.example.genchi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping( "v1/customer")
public class CustomerController {

    private final CustomerService userService;

    public CustomerController(CustomerService userService) {
        this.userService = userService;
    }

    public ResponseEntity<CustomerDto> doCreateCustomer(@RequestBody CustomerDto customerDto){
        return ResponseEntity.ok(null);
    }

    @RequestMapping("{id}")
    public ResponseEntity<CustomerDto> doRetrieveCustomer(@PathVariable("customerId") String customerId) throws Exception {
        return ResponseEntity.ok(userService.doRetrieveCustomer(customerId));
    }

}
