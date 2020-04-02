/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author vodde
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setHgap(10);
        pane.setVgap(8);
        
        //Username label
        Label username = new Label("Username:");
        GridPane.setConstraints(username, 0, 0);
        
        //Username input
        TextField userInput = new TextField();
        userInput.setPromptText("username");
        GridPane.setConstraints(userInput, 1, 0);
        
        //Password label
        Label password = new Label("Password:");
        GridPane.setConstraints(password, 0, 1);
        
        //Password input
        TextField passwordInput = new TextField();
        passwordInput.setPromptText("password");
        GridPane.setConstraints(passwordInput, 1, 1);
        
        //Role label
        Label role = new Label("Role:");
        GridPane.setConstraints(role, 0, 2);
        
        //Role input
        TextField roleInput = new TextField();
        roleInput.setPromptText("role");
        GridPane.setConstraints(roleInput, 1, 2);
        
        //Log In Button
        Button loginButton = new Button("Log In");
        GridPane.setConstraints(loginButton,2,3);
             
        pane.getChildren().addAll(username,userInput,password,passwordInput,role,roleInput,loginButton);
         
        Scene scene = new Scene(pane, 400, 200);
        
        primaryStage.setTitle("LogIn Information");
        primaryStage.setScene(scene);
        primaryStage.show();
        
         loginButton.setOnAction((ActionEvent event) -> {
             String a = "admin";
             String b = "manager";
             String c = "customer";
             Customer cx = new Customer(userInput.getText(),passwordInput.getText(),100);
             Admins x = new Admins();
             if(userInput.getText().equals(a) && passwordInput.getText().equals(a) && roleInput.getText().equals(b) ){
                 Manager manager = new Manager(userInput.getText(),passwordInput.getText());
                 //then open new window for manager
                 GridPane pane1 = new GridPane();
                 pane1.setPadding(new Insets(10, 10, 10, 10));
                 pane1.setHgap(10);
                 pane1.setVgap(8);
                 
                 Button logoutButton = new Button("Log out");
                 GridPane.setConstraints(logoutButton, 2, 3);
                 
                 Button AddCustomer = new Button("Add Customer");
                 GridPane.setConstraints(AddCustomer, 1, 1);
                 
                 Button DeleteCustomer = new Button("Delete Customer");
                 GridPane.setConstraints(DeleteCustomer, 2, 1);
                 
                 pane1.getChildren().addAll(logoutButton,AddCustomer,DeleteCustomer);
                 
                 Scene man = new Scene(pane1,400,300);
                 primaryStage.setTitle("Manager Menu");
                 primaryStage.setScene(man);
                 primaryStage.show();
                 
                 //Action for logout
                 logoutButton.setOnAction((ActionEvent eventlogout) -> {
                     primaryStage.setTitle("LogIn Information");
                     primaryStage.setScene(scene);
                     primaryStage.show();
                 });
                 //Action for adding customer button
                 AddCustomer.setOnAction((ActionEvent eventaddcust) -> {
                       GridPane pane3 = new GridPane();
                       pane3.setPadding(new Insets(10, 10, 10, 10));
                       pane3.setHgap(10);
                       pane3.setVgap(8);

                        //Username label
                        Label userna = new Label("Username: ");
                        GridPane.setConstraints(userna, 0, 0);

                                //Username input
                        TextField usernaInput = new TextField();
                        GridPane.setConstraints(usernaInput, 1, 0);

                                //Password label
                       Label passwo = new Label("Password: ");
                       GridPane.setConstraints(passwo, 0, 1);

                                //Password input
                       TextField passwoInput = new TextField();
                       GridPane.setConstraints(passwoInput, 1, 1);

                       //Add this customer Button
                       Button AddthisCustomer = new Button("Add this Customer");
                       GridPane.setConstraints(AddthisCustomer,1,2);

                       Button backwards = new Button("Go Back");
                       GridPane.setConstraints(backwards,2,2);
                       
                       pane3.getChildren().addAll(userna,usernaInput,passwo,passwoInput,AddthisCustomer,backwards);

                       Scene addcust = new Scene(pane3, 400, 200);

                       primaryStage.setTitle("Add Customer Information");
                       primaryStage.setScene(addcust);
                       primaryStage.show(); 
                       
                       backwards.setOnAction((ActionEvent eventback) -> {
                                    primaryStage.setScene(man);
                                    primaryStage.setTitle("Manager Menu");
                                    primaryStage.show();
                        });
                       
                       AddthisCustomer.setOnAction((ActionEvent eventadd) -> {
                           Customer cust = new Customer(usernaInput.getText(),passwoInput.getText(),100);
                           try {
                               x.addCustomer(cust, manager);
                           } catch (Exception ex) {
                               Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                           }
                           Alert alert = new Alert(AlertType.INFORMATION);
                             alert.setTitle("Customer Added");
                             alert.setHeaderText(null);
                             alert.setContentText("Customer with username " + usernaInput.getText() + " and password " + passwoInput.getText() + " added to list");
                             alert.showAndWait();
                           
                       });
            
            }); //Action for deleting customer button
                        DeleteCustomer.setOnAction((ActionEvent eventdeletecust) -> {
                                GridPane pane4 = new GridPane();
                                pane4.setPadding(new Insets(10, 10, 10, 10));
                                pane4.setHgap(10);
                                pane4.setVgap(8);

                                //Username label
                                Label usern = new Label("Username: ");
                                GridPane.setConstraints(usern, 0, 0);

                                //Username input
                                TextField usernInput = new TextField();
                                GridPane.setConstraints(usernInput, 1, 0);

                                //Password label
                                Label passw = new Label("Password: ");
                                GridPane.setConstraints(passw, 0, 1);

                                //Password input
                                TextField passwInput = new TextField();
                                GridPane.setConstraints(passwInput, 1, 1);
                                
                                //Delete this customer Button
                                Button DeletethisCustomer = new Button("Delete this Customer");
                                GridPane.setConstraints(DeletethisCustomer,1,2);
                                
                                Button backwards = new Button("Go Back");
                                GridPane.setConstraints(backwards,2,2);
                                
                                pane4.getChildren().addAll(usern,usernInput,passw,passwInput,DeletethisCustomer,backwards);

                                Scene deletecust = new Scene(pane4, 400, 200);

                                primaryStage.setTitle("Delete Customer Information");
                                primaryStage.setScene(deletecust);
                                primaryStage.show();
                                
                                backwards.setOnAction((ActionEvent eventback) -> {
                                    primaryStage.setScene(man);
                                    primaryStage.setTitle("Manager Menu");
                                    primaryStage.show();
                                });
                                
                                DeletethisCustomer.setOnAction((ActionEvent eventdelete) -> {
                                  Customer cust = new Customer(usernInput.getText(),passwInput.getText(),100);
                                        try {
                                            x.deleteCustomer(cust, manager);
                                        } catch (Exception ex) {
                                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                                        } 
                                        Alert alert = new Alert(AlertType.INFORMATION);
                                        alert.setTitle("Customer Deleted");
                                        alert.setHeaderText(null);
                                        alert.setContentText("Customer with username " + usernInput.getText() + " and password " + passwInput.getText() + " deleted from list");
                                        alert.showAndWait();
                                             });
             });
                         }
             else try {
                 if(roleInput.getText().equals(c) && x.verifyCustomer(cx) == true){
                     //open window for customer
                     
                     GridPane pane2 = new GridPane();
                     pane2.setPadding(new Insets(10, 10, 10, 10));
                     pane2.setHgap(10);
                     pane2.setVgap(8);
                     
                     Button logoutButton = new Button("Log out");
                     GridPane.setConstraints(logoutButton, 2, 3);
                     
                     Button depositmoney = new Button("Deposit Money");
                     GridPane.setConstraints(depositmoney, 1, 1);
                     
                     Button withdrawmoney = new Button("Withdraw Money");
                     GridPane.setConstraints(withdrawmoney, 2, 1);
                     
                     Button getbalance = new Button("Retrieve Balance");
                     GridPane.setConstraints(getbalance, 1, 2);
                     
                     Button onlinepurchase = new Button("Make online purchase");
                     GridPane.setConstraints(onlinepurchase, 2, 2);
                     
                     pane2.getChildren().addAll(logoutButton, depositmoney, withdrawmoney, getbalance, onlinepurchase);
                     
                     Scene customer = new Scene(pane2,400,300);
                     primaryStage.setTitle("Customer Menu");
                     primaryStage.setScene(customer);
                     primaryStage.show();
                     
                     logoutButton.setOnAction(e -> primaryStage.setScene(scene));
                     
                     depositmoney.setOnAction((ActionEvent eventdepositmoney) -> {
                         GridPane panedeposit = new GridPane();
                         panedeposit.setPadding(new Insets(10, 10, 10, 10));
                         panedeposit.setHgap(10);
                         panedeposit.setVgap(8);
                         
                         //Deposit label
                         Label depositamount = new Label("Deposit Amount:");
                         GridPane.setConstraints(depositamount, 0, 0);
                         
                         //Deposit input
                         TextField depositInput = new TextField();
                         depositInput.setPromptText("Deposit Amount Here");
                         GridPane.setConstraints(depositInput, 1, 0);
                         
                         //Deposit money Button
                         Button DepositCustomer = new Button("Deposit Money");
                         GridPane.setConstraints(DepositCustomer,1,2);
                         
                         Button back = new Button("Go Back");
                         GridPane.setConstraints(back,2,2);
                         
                         panedeposit.getChildren().addAll(depositamount,depositInput,DepositCustomer,back);
                         
                         Scene depositcust = new Scene(panedeposit, 500, 200);
                         
                         primaryStage.setTitle("Deposit Money");
                         primaryStage.setScene(depositcust);
                         primaryStage.show();
                         
                         DepositCustomer.setOnAction((ActionEvent eventdeposit) -> {
                             cx.depositmoney(Integer.parseInt(depositInput.getText()));
                             Alert alert = new Alert(AlertType.INFORMATION);
                             alert.setTitle("Account Balance after Deposit");
                             alert.setHeaderText(null);
                             alert.setContentText("" + cx.getBalance());
                             alert.showAndWait();
                         });
                         
                         back.setOnAction((ActionEvent gback) -> {
                             primaryStage.setScene(customer);
                         });
                     });
                     
                     withdrawmoney.setOnAction((ActionEvent eventwithdrawmoney) -> {
                         
                         GridPane panewithdraw = new GridPane();
                         panewithdraw.setPadding(new Insets(10, 10, 10, 10));
                         panewithdraw.setHgap(10);
                         panewithdraw.setVgap(8);
                         
                         //Deposit label
                         Label withdrawamount = new Label("Withdraw Amount:");
                         GridPane.setConstraints(withdrawamount, 0, 0);
                         
                         //Deposit input
                         TextField WithdrawInput = new TextField();
                         WithdrawInput.setPromptText("Withdraw Amount Here");
                         GridPane.setConstraints(WithdrawInput, 1, 0);
                         
                         //Deposit money Button
                         Button WithdrawCustomer = new Button("Withdraw Money");
                         GridPane.setConstraints(WithdrawCustomer,1,2);
                         
                         Button back = new Button("Go Back");
                         GridPane.setConstraints(back,2,2);
                         
                         panewithdraw.getChildren().addAll(withdrawamount,WithdrawInput,WithdrawCustomer,back);
                         
                         Scene withdrawcust = new Scene(panewithdraw, 500, 200);
                         
                         primaryStage.setTitle("Withdraw Money");
                         primaryStage.setScene(withdrawcust);
                         primaryStage.show();
                         
                         WithdrawCustomer.setOnAction((ActionEvent eventwithdraw) -> {
                             cx.withdrawmoney(Integer.parseInt(WithdrawInput.getText()));
                             Alert alert = new Alert(AlertType.INFORMATION);
                             alert.setTitle("Account Balance after Withdrawal");
                             alert.setHeaderText(null);
                             alert.setContentText("" + cx.getBalance());
                             alert.showAndWait();
                         });
                         
                         back.setOnAction((ActionEvent gback) -> {
                             primaryStage.setScene(customer);
                         });
                     });
                     
                     getbalance.setOnAction((ActionEvent eventgetbalance) -> {
                         Alert alert = new Alert(AlertType.INFORMATION);
                         alert.setTitle("Account Balance");
                         alert.setHeaderText(null);
                         alert.setContentText("" + cx.getBalance());
                         alert.showAndWait();
                     });
                     
                     onlinepurchase.setOnAction((ActionEvent eventpurchase) -> {
                         GridPane panepurchase = new GridPane();
                         panepurchase.setPadding(new Insets(10, 10, 10, 10));
                         panepurchase.setHgap(10);
                         panepurchase.setVgap(8);
                         
                         //purchase label
                         Label purchaseamount = new Label("Purchase Amount:");
                         GridPane.setConstraints(purchaseamount, 0, 0);
                         
                         //purchase input
                         TextField purchaseInput = new TextField();
                         purchaseInput.setPromptText("Larger than 50");
                         GridPane.setConstraints(purchaseInput, 1, 0);
                         
                         //Make Purchase Button
                         Button PurchaseCustomer = new Button("Make Purchase");
                         GridPane.setConstraints(PurchaseCustomer,1,2);
                         
                         Button back = new Button("Go Back");
                         GridPane.setConstraints(back,2,2);
                         
                         panepurchase.getChildren().addAll(purchaseamount,purchaseInput,PurchaseCustomer,back);
                         
                         Scene purchasecust = new Scene(panepurchase, 500, 200);
                         
                         primaryStage.setTitle("Make a Purchase");
                         primaryStage.setScene(purchasecust);
                         primaryStage.show();
                         
                         PurchaseCustomer.setOnAction((ActionEvent eventdeposit) -> {
                             cx.additionalFeePurchase(Integer.parseInt(purchaseInput.getText()));
                             Alert alert = new Alert(AlertType.INFORMATION);
                             alert.setTitle("Account Balance after Online Purchase");
                             alert.setHeaderText(null);
                             alert.setContentText("" + cx.getBalance());
                             alert.showAndWait();
                         });
                         
                         back.setOnAction((ActionEvent gback) -> {
                             primaryStage.setScene(customer);
                         });
                     });
                     
                 }   } catch (Exception ex) {
                 Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
             }      
    
         });  
    /**
     * @param args the command line arguments
     */
    }   
    public static void main(String[] args) {
        launch(args);
    }
}   

