/**
 * Class yang mengatur semua hal yang berkaitan dengan sebuah akun,
 * yaitu: register, login, topup, create store
 */

package com.TimothyJmartKD.controller;

import com.TimothyJmartKD.Account;
import com.TimothyJmartKD.Algorithm;
import com.TimothyJmartKD.Predicate;
import com.TimothyJmartKD.Store;
import com.TimothyJmartKD.dbjson.JsonAutowired;
import com.TimothyJmartKD.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
    //Regex email dan password
    public static final String REGEX_EMAIL= "^\\w+([\\.]?[&\\*~\\w+])*@\\w+([\\.-]?)*(\\.\\w{2,3})+$";
    public static final String REGEX_PASSWORD= "^(?=.*[0-9])(?=.*[a-z])(?=\\S+$)(?=.*[A-Z]).{8,}$";
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);

    //Directory account table
    @JsonAutowired(filepath = "C:/Users/Timothy/Desktop/Kuliah/Semester_5/OOP/Praktikum/Modul 9/accountTable.json", value = Account.class)
    public static JsonTable<Account> accountTable;

    public JsonTable<Account> getJsonTable()
    {
        return accountTable;
    } //Ambil data dari file json

    /**
     * Login ke akun yang sudah ada di account table
     * @param email email yang digunakan untuk login
     * @param password password yang digunakan untuk login
     */
    @PostMapping("/login") //Method mengirimkan data ke URI login
    Account login(@RequestParam String email, @RequestParam String password)
    {
        String passwordToHash = password;
        String generatedPassword = null;

        //MD5 hashing dari password yang diinput
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
            //Bila input = pass yang tersimpan untuk akun tersebut, maka bisa login
            if (account.email.equals(email) && account.password.equals(generatedPassword))
                return account;
        }
        return null;
    }

    /**
     * Register akun baru ke account table
     * @param name nama akun yang didaftarkan
     * @param email email akun yang didaftarkan
     * @param password password akun yang didaftarkan
     */
    @PostMapping("/register") //Method mengirimkan data ke URI register
    Account register(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        Matcher matcherEmail = REGEX_PATTERN_EMAIL.matcher(email);
        Matcher matcherPassword = REGEX_PATTERN_PASSWORD.matcher(password);

        boolean matchEmail = matcherEmail.find();
        boolean matchPassword = matcherPassword.find();

        Predicate<Account> checkEmail = account -> account.email.equals(email);
        String hashedPassword = null;

        //MD5 hashing dari password yang diinput
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());

            byte[] bytes = md.digest();

            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            hashedPassword = sb.toString();
        }

        catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        //Jika kredensial belum ada di account table, buat akun baru dengan info yang dimasukkan
        if(!name.isBlank() && matchEmail && matchPassword && !Algorithm.exists(getJsonTable(), checkEmail)) {
            getJsonTable().add(new Account(name, email, hashedPassword, 0));
            return new Account(name, email, hashedPassword, 0); //Memasukkan info baru ke json table
        }
        return null;
    }

    /**
     * Register store untuk akun yang sedang login
     * @param id id dari akun yang akan register store
     * @param name nama store yang akan diregister
     * @param address alamat store yang akan diregister
     * @param phoneNumber nomor telepon store yang akan diregister
     */
    @PostMapping("{id}/registerStore") //Method mengirimkan data ke URI registerStore
    Store registerStore(@PathVariable int id, @RequestParam String name, @RequestParam String address, @RequestParam String phoneNumber) {
        if(Algorithm.exists(getJsonTable().toArray(), id) || !Algorithm.exists(getJsonTable().toArray(), name)) {
            Predicate<Account> accId = matchId -> matchId.id == id && matchId.store == null;
            Account account = Algorithm.find(getJsonTable().iterator(), accId);
            account.store = new Store(name, address, phoneNumber, 0);
            return new Store(name, address, phoneNumber, 0);
        } //Apabila akun sudah punya store, tidak bisa register lagi dan info store miliknya ditampilkan
        return null;
    }

    /**
     * Top up saldo untuk akun yang sedang login
     * @param id id dari akun yang akan top up
     * @param balance nominal uang yang akan ditambahkan ke akun
     */
    @PostMapping("/{id}/topUp") //Method mengirimkan data ke URI topUP
    boolean topUp(@PathVariable int id, @RequestParam double balance) {
        Predicate<Account> findAccount = matchAccount -> matchAccount.id == id;
        Account account = Algorithm.find(getJsonTable(), findAccount);
        if(account != null) {
            account.balance += balance;
            return true;
        } //Apabila akun terdaftar di account table, akun tersebut dapat top up
        return false;
    }
}