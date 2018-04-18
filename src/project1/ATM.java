/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author ztmvf2
 */
public class ATM {
    Scanner sc = new Scanner(System.in);
    boolean alreadyExecuted;
    Account[] accounts = new Account[3];
    
    public static void main(String[] args) throws IOException 
    {
    ATM atm = new ATM();
    atm.menu();
    }
   
    
//    public void account(double balance)
//    {
//    balance = 100;    
//    }
//    
    public void menu() throws IOException
    {   
        ATM atm = new ATM();
        int input;
        do
        {
            System.out.println("1. Populate Accounts");
            System.out.println("2. Select Accounts");
            System.out.println("3. Exit");
            input = sc.nextInt();
            
            if(input == 1)
            {
                if(!alreadyExecuted)
                {
                    atm.populate();
                    alreadyExecuted = true;
                }
                else
                System.out.println("\nAccounts already populated");
            }
            else if(input == 2)
            {
            atm.select();
            }
            else if(input == 3)
            {
            System.exit(0);
            }
            else if (input > 3 || input < 1)
            {
            System.out.println("\nPlease enter a valid number.\n");    
            }
        }
        while(input != 3);
    }
    
    public void populate()
        {
        ATM atm = new ATM();

            for(int i = 0; i < accounts.length; i++)
            {
                accounts [i] = new Account(100);
            }
        }
    public void select() throws IOException
        {
        int input;
        do
        {
            System.out.println("Enter account number: ");
            input = sc.nextInt();
            
            if(input >= 4 || input <= 0){
                System.out.println("Please enter numbers 1 2 or 3");
            }
            
        }while (!((input - 1) >= 0) || !((input - 1) < accounts.length));
        accounts[input - 1].menu();
       
        
        }
}
