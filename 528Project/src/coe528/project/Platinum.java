/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

/**
 *
 * @author vodde
 */
public class Platinum extends Customer {
     
    public Platinum(String n, String a, int y)
    {
        super(n,a,y); 
    }
    
    @Override
    public void additionalFeePurchase(int p){
        if( balance > 20000)
            balance = balance - p;
    }
}   

