package BankeBank;

import java.util.Random;

public class Account {
    private String username;
    private String password;
    private double balance;
    private String AccountNumber;

    public Account(String username,String password){
        this.username = username;
        this.password =password;
        this.balance =0;
        String AccNumber = "";
        Random random = new Random();

        for (int count = 0; count < 10; count++) {
            int randomInt = random.nextInt(10);
            String singleNum = String.valueOf(randomInt);
            AccNumber += singleNum;
        }
        this.AccountNumber = AccNumber;
    }

    public String getUsername(){return username;}
    public String getPassword(){return password;}
    public double getBalance(){return balance;}
    public String getAccountNumber(){return AccountNumber;}

    public void deposit(double amount){
        boolean noNegative = amount>0;
        if(noNegative){
            balance += amount;
        }

    }

    public void withdrawer(double amount){
        boolean noNegative = amount>0;
        boolean beyondLimit = balance > amount;
        boolean check = noNegative && beyondLimit;
        if(check){
            balance -= amount;
        }
    }

    public void setPassword(String pin){this.password = pin;}

    public String toString(){
        return "Name: "+this.username+", Balance: "+this.balance+", Account_Number: "+ this.AccountNumber;
    }
}
