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

public class FizzBuzz
{
    
    private static void solve( int N )
    {
        for( int i = 1; i <= N; i++ )
        {
            if( i % 15 == 0 )
            {
                System.out.println( "FizzBuzz" );
            }
            else if( i % 5 == 0)
            {
                System.out.println( "Buzz" );
            }
            else if( i % 3 == 0 )
            {
                System.out.println( "Fizz" );
            }
            else
            {
                System.out.println(i);
            }
        }
    }
    
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        in.nextLine();
        String strN = in.nextLine();
        String[] strArr = strN.split( " " );
        
        for( int k=0; k < T ; k++ )
        {
            solve( Integer.parseInt( strArr[k] ) );
        }
        
        in.close();
        //System.out.println(cnt) ;
    }
}
