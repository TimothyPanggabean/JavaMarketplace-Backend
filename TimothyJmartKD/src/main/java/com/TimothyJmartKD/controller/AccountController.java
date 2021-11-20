package com.TimothyJmartKD.controller;

import com.TimothyJmartKD.Account;
import com.TimothyJmartKD.Algorithm;
import com.TimothyJmartKD.Store;
import com.TimothyJmartKD.dbjson.JsonAutowired;
import com.TimothyJmartKD.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
    public static final String REGEX_EMAIL= "^\\w+([\\.]?[&\\*~\\w+])*@\\w+([\\.-]?)*(\\.\\w{2,3})+$";
    public static final String REGEX_PASSWORD= "^(?=.*[0-9])(?=.*[a-z])(?=\\S+$)(?=.*[A-Z]).{8,}$";
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);

    @JsonAutowired(filepath = "C:/Users/Timothy/Desktop/Kuliah/Semester 5/OOP/Praktikum/Modul 8", value = Account.class)
    public static JsonTable<Account> accountTable;

    public JsonTable<Account> getJsonTable()
    {
        return accountTable;
    }

    @PostMapping("/login")
    Account login(String email, String password)
    {
        for(Account account : accountTable)
        {
            if (account.email.equals(email) && account.password.equals(password))
                return account;
        }
        return null;
    }

    @PostMapping("/register")
    Account register
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password
            )
    {
        if(!name.isBlank() && REGEX_PATTERN_EMAIL.matcher(email).find() &&
                REGEX_PATTERN_PASSWORD.matcher(password).find() && !Algorithm.exists(accountTable.toArray(), email))
        return new Account(name, email, password, 0);

        else return null;
    }

    @PostMapping("/{id}/registerStore")
    Store registerStore(int id, String name, String address, String phoneNumber)
    {
        if(Algorithm.exists(getJsonTable().toArray(), id) || !Algorithm.exists(getJsonTable().toArray(), name))
            return new Store(name, address, phoneNumber, 0);


        return null;
    }

    @PostMapping("/{id}/topUp")
    boolean topUp(int id, double balance)
    {
        for(Account account : accountTable)
        {
            if(account.id == id)
            {
                account.balance += balance;
                return true;
            }
        }
        return false;
    }
}
