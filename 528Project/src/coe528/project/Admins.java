/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author vodde
 */
public class Admins {
    private static List<Customer> customers = new LinkedList<>();
    
    public void addCustomer(Customer c, Manager a)throws Exception{
        if(c == null)
            throw new NullPointerException("customer cannot be null");
        if(a.getClass() != Manager.class){
            throw new IllegalArgumentException("Non Admins cannot add customers");
        }
        for(Customer x: customers){
            if(x.getUserName().equals(c.getUserName()))
                throw new IllegalArgumentException("This customer already exists");
        }
        customers.add(c);
    }
    
    public void deleteCustomer(Customer c, Manager a)throws Exception{
        if(c == null)
            throw new NullPointerException("customer cannot be null");
        if(a.getClass()!= Manager.class)
            throw new IllegalArgumentException("This is not a manager");
        for(Customer x: customers){
            if(x.getUserName().equals(c.getUserName()))
                customers.remove(x);
        }
    }
    
    public boolean verifyCustomer(Customer c) throws Exception{
        
        if(c == null)
            throw new NullPointerException("customer cannot be null");
        for(Customer x: customers){
            if(x.getUserName().equals(c.getUserName()) && x.getPassword().equals(c.getPassword()))
                return true;
        }
        return false;
    }
}
