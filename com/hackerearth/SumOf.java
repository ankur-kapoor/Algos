package com.hackerearth;

import java.util.Scanner;

/**
 *Write a program that prints the numbers in the given range. But for multiples of three print “Fizz” instead of the number and for the multiples of five print “Buzz”. For numbers which are multiples of both three and five print “FizzBuzz”. Print a new line after each string or number.

Input Format First line will be the number of testcases, T. Next line will have T integers, denoted by N.

Output Format For each testcase, print the number from 1 to N. But follow the rules given in the problem statement.

Constraints

1 <= T <= 10

N is an integer.
 * @author ankurkap
 *
 */

public class SumOf
{
    
    private static void solve( int a, int b )
    {
        System.out.println( a + b);
    }
    
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        in.nextLine();
        
        for( int k=0; k < T ; k++ )
        {
            String strN = in.nextLine();
            String[] strArr = strN.split( " " );
            
            solve( Integer.parseInt( strArr[0] ), Integer.parseInt( strArr[1] ) );
        }
        
        in.close();
        //System.out.println(cnt) ;
    }
}
