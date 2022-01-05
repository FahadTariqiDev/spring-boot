package com.example.bank.Users;

import com.example.bank.bank.Bank;

public class Users {
    private String id;
    private String name;
    private String email;
    private String password;
    private double balance;
    private double loanBalance;
    public static  String bankName = "vm";
    public static  Double bankBalance = 100000.0;
    public Users( String id, String name, String email, String password, double balance, double loanBalance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.loanBalance = loanBalance;
    }

    public static String getBankName() {
        return bankName;
    }

    public static void setBankName(String bankName) {
        Users.bankName = bankName;
    }

    public static Double getBankBalance() {
        return bankBalance;
    }

    public static void setBankBalance(Double bankBalance) {
        Users.bankBalance = bankBalance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getLoanBalance() {
        return loanBalance;
    }

    public void setLoanBalance(double loanBalance) {
        this.loanBalance = loanBalance;
    }
}
