package com.example.genchi.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the {@link com.example.genchi.entities.Account} entity
 */
public class AccountDto implements Serializable {
    private Long id;
    private String accountNumber;
    private BigDecimal initialCredit;
    private BigDecimal availableCredit;

    public AccountDto() {
    }

    public AccountDto(Long id, String accountNumber, BigDecimal initialCredit, BigDecimal availableCredit) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.initialCredit = initialCredit;
        this.availableCredit = availableCredit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getInitialCredit() {
        return initialCredit;
    }

    public void setInitialCredit(BigDecimal initialCredit) {
        this.initialCredit = initialCredit;
    }

    public BigDecimal getAvailableCredit() {
        return availableCredit;
    }

    public void setAvailableCredit(BigDecimal availableCredit) {
        this.availableCredit = availableCredit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountDto entity = (AccountDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.accountNumber, entity.accountNumber) &&
                Objects.equals(this.initialCredit, entity.initialCredit) &&
                Objects.equals(this.availableCredit, entity.availableCredit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,  accountNumber, initialCredit, availableCredit);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "accountNumber = " + accountNumber + ", " +
                "initialCredit = " + initialCredit + ", " +
                "availableCredit = " + availableCredit + ")";
    }
}