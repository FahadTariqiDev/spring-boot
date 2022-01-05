package com.example.bank.bank;

public class Bank {
    public static  String bankName = "vm";
    public static  Double bankBalance = 100000.0;

    public static String getBankName() {
        return bankName;
    }

    public static void setBankName(String bankName) {
        Bank.bankName = bankName;
    }

    public static Double getBankBalance() {
        return bankBalance;
    }

    public static void setBankBalance(Double bankBalance) {
        Bank.bankBalance = bankBalance;
    }
}
