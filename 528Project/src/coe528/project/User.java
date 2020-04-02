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
public abstract class User {
    
        String username;
        String password;
        
    public User(String u, String p)
    {
        this.username=u;
        this.password=p;
    }   
    
        @Override
        public String toString()
        {
            String x = this.username + "\n" + this.password;
            return(x);
        }
        
        public String getUserName()
        {
            return username;
        }
        
        public void setUserName(String n)
        {
            this.username=n;
        }
        
        public String getPassword()
        {
            return password;
        }
        
        public void setPassword(String a)
        {
            this.password=a;
        }
        public abstract void additionalFeePurchase(int p);
}
