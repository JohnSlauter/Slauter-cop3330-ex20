package org.example;

/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution
 *  Copyright 2021 John Slauter
 */

import java.util.Scanner;

public class App 
{

    private static final double Illinois_tax = 0.08;

    private static final double Wisconsin_tax = 0.05;

    private static final double Eau_Claire_tax = 0.005;

    private static final double Dunn_tax = 0.004;


    public static void main( String[] args )
    {

        Scanner s = new Scanner(System.in);

        double subtotal, tax = 0.0;

        String output_text = new String(), temp;

        System.out.print("What is the order amount? ");

        subtotal = ceiling(s.nextDouble());

        s.nextLine();

        System.out.print("What state do you live in? ");

        temp = s.nextLine();

        if(temp.equalsIgnoreCase("Wisconsin")){

            System.out.print("What county do you live in? ");

            temp = s.nextLine();

            tax += ceiling(Wisconsin_tax * subtotal);

            if(temp.equalsIgnoreCase("Eau Claire")){

                tax += ceiling(Eau_Claire_tax * subtotal);

            }

            else if(temp.equalsIgnoreCase("Dunn")){

                tax += ceiling(Dunn_tax * subtotal);

            }

        }

        else if(temp.equalsIgnoreCase("Illinois")){

            tax += ceiling(Illinois_tax * subtotal);

        }

        if(tax > 0.0){

            output_text = "The tax is $" + tax + ".\n";

            subtotal += tax;

        }

        output_text = output_text.concat("The total is $" + subtotal + ".");

        System.out.print(output_text);

        s.close();

    }

    private static double ceiling(double num){

        int temp = (int)(num*100);

        if((num*1000)%(temp*10) > 0){

            return ((double)(temp+1))/100;

        }

        return ((double)temp)/100;

    }

}
