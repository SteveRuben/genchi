package com.example.genchi.model;

import org.springframework.web.bind.annotation.RequestParam;

public class AccountWithBalanceDTO {
    private String customerId;
    private String initialCredit;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getInitialCredit() {
        return initialCredit;
    }

    public void setInitialCredit(String initialCredit) {
        this.initialCredit = initialCredit;
    }
}
