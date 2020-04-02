/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.nio.file.Files;
import java.nio.file.Paths;
/**
 *
 * @author vodde
 */
public class Customer extends User{
    // Overview: Customers are mutable, used to      
    //   keep a customer info and allowing these
    //   customers to do specified functions.
    
    //    // The abstraction function is:   
    // a)Write the abstraction function here    
    //   AF(c) = c.balance = customer.balance
    //      
    //
    // The rep invariant is:
    // b)Write the rep invariant here   
    //  RI(c) = c.getBalance > 0, c.state != null 
    //
    //
    int balance;
    String state;
    
    public Customer(String u, String p, int b) 
    {
        //EFFECTS: Creates a Customer object
        //MODIFIES: nothing
        //REQUIRES: strings u,p != null, integer b is always 100
        super(u,p);
        //by default customers always have $100 balance, therefore start in Silver state
        this.balance=b;
        state="Silver";
    }   
    
        @Override
        public String toString()
        {
            //EFFECTS: Returns the customers balance as a String
            String x = "" + this.balance;
            return(x);
        }
        
        public boolean repOK(){
            //EFFECTS: Returns true if balance > 0, state != null
            if(balance<0 || state == null)
                return false;
        return true;
        }
        
        
        public int getBalance(){
            //EFFECTS: returns balance of Customer
            return balance;
        }
        
        public String getState(){
            //EFFECTS: returns the current state of Customer
            return state;
        }
        
        public void depositmoney(int b){
            //EFFECTS: deposits int b into balance of Customer
            //MODIFIES: nothing
            //REQUIRES: int b must be a positive integer
            this.balance=balance + b;
        }
        public void withdrawmoney(int b){
            //EFFECTS: withdraws int b from balance of customer if the balance will still be greater than 0
            //MODIFIES: nothing
            //REQUIRES: int b must be a positive integer
            int x=balance-b;
            if(x>0)
            this.balance=balance - b;
        }
        @Override
        public void additionalFeePurchase(int p){
            //EFFECTS: withdraws int p from balance of customer and an additional fee based off what current state the balance is in
            //MODIFIES: nothing
            //REQUIRES: p is a positive integer greater than 50
        if(p>50){
            int x = balance - p - 20;
            if(balance < 10000)
                if(x>0){
                    //silver state
                    state="Silver";
                    balance = balance - p - 20;
                }
            if(10000 <= balance && balance < 20000){
                //gold state
                state="Gold";
                balance = balance - p - 10;
            }
            if(balance >= 20000){
                //platinum state
                state="Platinum";
                balance = balance - p;
            }
        }else
            throw new IllegalArgumentException("Purchase must be greater than 50!!");
        }
}


