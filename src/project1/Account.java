/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author amc3n2
 */
public class Account {
   
 
    
    double balance;
    double amount;
    protected int firstdate;
    protected int seconddate;
    protected Calendar cal1 = new GregorianCalendar();
    protected Calendar cal2 = new GregorianCalendar();
    protected boolean dateflag = false;
    protected double rate;

    public Account(double balance) 
    {
        this.balance = balance;
    }
    
    void menu() throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int input;
        do
        {
        System.out.println("Enter 1 to deposit.");
        System.out.println("Enter 2 to Withdraw.");
        System.out.println("Enter 3 to Check Balance.");
        System.out.println("Enter 4 to exit.");
        input = 0;
        input = sc.nextInt();
    
            switch (input) {
                case 1:
                     

            if (dateflag == true)

            {

                    getDate2();

                    getInterest();

                    deposit();

            }

            else

            {

                    getDate1();

                    deposit();

            }
                    break;
                case 2:
                               

            if (dateflag == true)

            {

                    getDate2();

                    getInterest();

                    withdraw();

            }

            else

            {

                    getDate1();

                    withdraw();

            }
                    break;
                case 3:
                    if (dateflag == true)

            {

                    getDate2();

                    getInterest();

                    display();

            }

            else

            {

                    getDate1();

                    display();

            }
                    break;
                default:          
                    break;
            }
        }while(!(input >= 4 || input <= 0));
    }
      
    private void getDate1() throws IOException 

        {

            System.out.print("Enter todays date(mm/dd/yyyy): ");

            BufferedReader br;

             br = new BufferedReader(new InputStreamReader(System.in));

             String inputText = br.readLine();

            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

            ParsePosition pos = new ParsePosition(0);

             Date date = formatter.parse(inputText, pos);
            
             cal1.setTime(date);

             firstdate = cal1.get(Calendar.DAY_OF_YEAR);

             dateflag = true;

        }


private void getDate2() throws IOException 

          {   
    
               System.out.print("Enter todays date(mm/dd/yyyy): ");

                BufferedReader br;

                br = new BufferedReader(new InputStreamReader(System.in));

                String inputText = br.readLine();

                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

                ParsePosition pos = new ParsePosition(0);

                Date date= new Date();

                date = formatter.parse(inputText, pos);

 

                cal2.setTime(date);

 

                seconddate = cal2.get(Calendar.DAY_OF_YEAR);

 

                                if (firstdate > seconddate) {

                                                System.out.println("You must enter a future date.");

                                                getDate2();

                                }

 

                }
    
    private void getInterest() 

        {

            int datediff = seconddate - firstdate;

            rate = .10/365;

            double ratetime = Math.pow(1+rate,datediff);

            balance = balance * ratetime;

            firstdate = seconddate;

        }

    
    int deposit() 
        {
        System.out.print("Enter amount to deposit:");
        Scanner sc = new Scanner(System.in);
	amount = sc.nextDouble();
            if (amount < 0) 
            {
            System.out.println("Invalid Amount");
            return 1;
            }
            balance = balance + amount;
            return 0;
	}
    
    int withdraw() 
        {
        System.out.println("Your Balance= " + balance);
        System.out.print("Enter amount to withdraw:");
        Scanner sc = new Scanner(System.in);
	amount = sc.nextDouble();
            if (balance < amount) 
            {
            System.out.println("Not sufficient balance.");
            return 1;
            }
            if (amount < 0) 
            {
            System.out.println("Invalid Amount");
            return 1;
            }
            balance = balance - amount;
            return 0;
	}
    void display() {
       System.out.println("Balance:" + balance);

	}
    
}
 