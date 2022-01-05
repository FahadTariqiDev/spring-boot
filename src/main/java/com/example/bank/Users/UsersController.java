package com.example.bank.Users;

import com.example.bank.bank.Bank;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsersController {
    private List<Users> usersList = new ArrayList<Users>();

    @GetMapping("users")
    public List<Users> getUser() {
        return usersList;
    }

    @PostMapping("users")
    private ResponseEntity addUser(@RequestBody Users user) {
        if (user.getId() == null || user.getName() == null || user.getEmail() == null) {
            return ResponseEntity.badRequest().body("Please fill all input");
        }
        boolean password = checkPassword(user.getPassword());
        boolean unique = isUnique(user.getId(), user.getEmail());
        System.out.println(password);
        if (!password) {
            return ResponseEntity.badRequest().body("password less than 6");

        }
        if (!unique) {
            return ResponseEntity.badRequest().body("id not unique");

        }
        usersList.add(user);
        return ResponseEntity.ok("user added");
    }

    @PostMapping("withdraw/{amount}")
    public ResponseEntity Withdraw(@PathVariable String amount, @RequestBody Users user) {
        double amount_d = Double.parseDouble(amount);
        System.out.println(amount);
        for (Users temp : usersList) {
            System.out.println(temp.getPassword());
            System.out.println(user.getPassword());
            System.out.println(temp.getId() + "" + user.getId());
            if (temp.getId().equals(user.getId()) && temp.getPassword().equals(user.getPassword())) {
                if (temp.getBalance() >= amount_d) {
                    temp.setBalance(temp.getBalance() - amount_d);
                    return ResponseEntity.ok("You just withdraw a :" + amount);
                } else {
                    return ResponseEntity.badRequest().body("no enough money");

                }

            }

        }
        return ResponseEntity.badRequest().body("Password not correct");
    }

    @PostMapping("deposit/{amount}")
    public ResponseEntity Deposit(@PathVariable String amount, @RequestBody Users user) {
        double amount_d = Double.parseDouble(amount);
        System.out.println(amount);
        for (Users temp : usersList) {
            System.out.println(temp.getPassword());
            System.out.println(user.getPassword());
            System.out.println(temp.getId() + "" + user.getId());
            if (temp.getId().equals(user.getId()) && temp.getPassword().equals(user.getPassword())) {

                temp.setBalance(temp.getBalance() + amount_d);
                return ResponseEntity.ok("You just deposit a :" + amount);


            }

        }
        return ResponseEntity.badRequest().body("Password not correct");
    }

    @PostMapping("loan/{amount}")
    public ResponseEntity Loan(@PathVariable String amount, @RequestBody Users user) {
        double amount_d = Double.parseDouble(amount);
        System.out.println(amount);
        for (Users temp : usersList) {

            if (temp.getId().equals(user.getId()) && temp.getPassword().equals(user.getPassword())) {
                if (temp.getBankBalance() > amount_d) {
                    temp.setBalance(temp.getBalance() + amount_d);
                    temp.setBankBalance(temp.getBankBalance() - amount_d);
                    temp.setLoanBalance(temp.getLoanBalance() + amount_d);
                    return ResponseEntity.ok("You just take a Loan a :" + amount);
                }


            }

        }
        return ResponseEntity.badRequest().body("Password not correct");
    }

    @DeleteMapping("users/{id}")
    private String deleteUser(@PathVariable String id) {
        for (Users temp : usersList) {
            if (temp.getId().equals(id) && temp.getLoanBalance()==0) {
                usersList.remove(temp);
                return "user deleted";
            }
        }
        return "You have dept";
    }

    @PutMapping("users/{id}")
    private ResponseEntity updateUser(@RequestBody Users user, @PathVariable String id) {
        if (user.getId() == null || user.getName() == null || user.getEmail() == null) {
            return ResponseEntity.badRequest().body("Please fill all input");

        }
        for (Users temp : usersList) {
            if (temp.getId().equals(id)) {

                if (user.getName() != null) {
                    temp.setName(user.getName());
                }
                if (user.getName() != null) {
                    temp.setName(user.getName());
                }
            }
        }
        return ResponseEntity.ok("user updated");
    }

    public boolean checkPassword(String password) {
        System.out.println(password + " " + password.trim().length());
        if (password.trim().length() < 6) {
            return false;
        }
        return true;
    }


    public boolean isUnique(String id, String email) {
        for (Users temp : usersList) {
            if (temp.getId().equals(id) || temp.getEmail().equals(email)) {
                return false;
            }
        }
        return true;
    }
}
