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
public class Silver extends Customer {
   
    public Silver(String n, String a, int y)
    {
        super(n,a,y); 
    }
    
    @Override
    public void additionalFeePurchase(int p){
        int x = balance - p - 20;
        if(x>0)
        {
        if(balance<10000)
            balance = balance - p - 10;
        }
    }
}
