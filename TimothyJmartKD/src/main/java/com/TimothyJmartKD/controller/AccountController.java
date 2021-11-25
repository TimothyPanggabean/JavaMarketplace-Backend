package com.TimothyJmartKD.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.TimothyJmartKD.Account;
import com.TimothyJmartKD.Algorithm;
import com.TimothyJmartKD.Store;
import com.TimothyJmartKD.dbjson.JsonAutowired;
import com.TimothyJmartKD.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;
import java.util.regex.Pattern;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
    Account login(@RequestParam String email, @RequestParam String password)
    {
        String passwordToHash = password;
        String generatedPassword = null;

        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(passwordToHash.getBytes());
            byte[] bytes = md.digest();

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < bytes.length; i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch(NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }

        for(Account account : accountTable)
        {
            if (account.email.equals(email) && account.password.equals(generatedPassword))
                return account;
        }
        return null;
    }

    @PostMapping("/register")
    Account register(@RequestParam String name, @RequestParam String email,@RequestParam String password)
    {
        String passwordToHash = password;
        String generatedPassword = null;

        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(passwordToHash.getBytes());
            byte[] bytes = md.digest();

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < bytes.length; i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch(NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }

        if(!name.isBlank() && REGEX_PATTERN_EMAIL.matcher(email).find() &&
                REGEX_PATTERN_PASSWORD.matcher(password).find() && !Algorithm.exists(accountTable.toArray(), email))
        return new Account(name, email, generatedPassword, 0);

        else return null;
    }

    @PostMapping("/{id}/registerStore")
    Store registerStore(@PathVariable int id, @RequestParam String name, @RequestParam String address, @RequestParam String phoneNumber)
    {
        if(Algorithm.exists(getJsonTable().toArray(), id) || !Algorithm.exists(getJsonTable().toArray(), name))
            return new Store(name, address, phoneNumber, 0);


        return null;
    }

    @PostMapping("/{id}/topUp")
    boolean topUp(@PathVariable int id, @RequestParam double balance)
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
