//
// A Simple Calculator
// S.Newall
// Version 2 (14/10/2021)
//
package plop;

import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Currency;
import java.util.Locale;


public class Calculator {

    public static void main(String[] args)   {
        
        Scanner input = new Scanner(System.in);
        try { 
        	
        // Set locale and currency format to UK/GBP
        Locale locale = Locale.UK;
        Currency curr = Currency.getInstance(locale);

        double value1;
        double value2;
        double total;
        char operator;
        
        boolean flag = false;
        
        // Set decimal points
        DecimalFormat df = new DecimalFormat("0.00");

        // User input
        System.out.print("Enter first value:    ");
        value1 = input.nextDouble();

        System.out.print("Enter second value:    ");
        value2 = input.nextDouble();
        

        // Build operator functions
        System.out.print("Enter an operator (+, -, *, /, %):  ");
        operator = input.next().charAt(0);
        switch(operator)    {
            case '+': total = value1 + value2;
                break;
            case '-': total = value1 - value2;
                break;    
            case '*': total = value1 * value2;
                break;
            case '/': total = value1 / value2;
                break;
            case '%': total = value1 % value2;
            	break;
        default: System.out.printf("Error! Enter the correct operator"); // Error clause
            return;
        }
        //Print calculated results and display currency format
        System.out.printf("Calculated Result:	");
        System.out.println(curr.getSymbol() + df.format(total));
        
        //Determine if calculated result is more or less than 100
        if (total <100) {
        	System.out.print("Total is less than 100");
        }
        else if (total >100){
        	System.out.print("Total is more than 100");
        }
        
        //Detect duplicate values
        if (value1 == value2) {
        	System.out.printf("%nDuplicate values detected");
        } else {
        	System.out.printf("%n");
        }
        
        //Determine if calculated total is a prime number or not
        for (int i = 2; i <= total /2; ++i) {
        	// condition for non-prime number
        	if (total % i == 0) {
        		flag  = true;
        		break;
        	}
        }
        
        //Print if calculated total is a prime number or not
        if (!flag)
        	System.out.println(total + " is a prime number");
        else
        	System.out.println(total + " is not a prime number");
        
    } finally {
    	input.close(); // Close resource leak
    }
  } 
}