package com.example.genchi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link com.example.genchi.entities.Customer} entity
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDto implements Serializable {
    private Long id;
    private String name;
    private String surName;
    private String password;
    private Set<AccountDto> accounts = new LinkedHashSet<>();

    public CustomerDto() {
    }

    public CustomerDto(Long id, String name, String surName, Set<AccountDto> accounts) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.accounts = accounts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Set<AccountDto> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<AccountDto> accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDto entity = (CustomerDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.surName, entity.surName) &&
                Objects.equals(this.accounts, entity.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surName, accounts);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "surName = " + surName + ", " +
                "accounts = " + accounts + ")";
    }
}