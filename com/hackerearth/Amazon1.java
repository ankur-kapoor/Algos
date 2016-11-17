package com.hackerearth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

public class Amazon1
{
    
    private static void solve( final List<Integer> a, final Map<Integer,Long> gcdMap, final Map<String, Integer> gMap )
    {
        for( Integer X : a )
        {
            if( !gcdMap.containsKey( X ))
            {
                long sum = 0; 
                for( int i =1; i <= X; i++ )
                {
                    String t = i +"-"+X;
                    
                    int g;
                    if( gMap.containsKey( t ))
                    {
                        g = gMap.get( t );
                    }
                    else
                    {
                        g = gcd(i,X);
                        gMap.put( t, g );
                    }
                    sum += (long)g;
                }
                gcdMap.put( X, sum );
            }
        }
    }
    
    private static void update( final List<Integer>a, final Map<Integer,Long> gcdMap, final Map<String, Integer> gMap, int X, int Y )
    {
        a.set( X-1, Y );
        
        if(!gcdMap.containsKey( Y ))
        {
            long sum = 0; 
            for( int i =1; i <= Y; i++ )
            {
                String t = i +"-"+Y;
                
                int g;
                if( gMap.containsKey( t ))
                {
                    g = gMap.get( t );
                }
                else
                {
                    g = gcd(i,Y);
                    gMap.put( t, g );
                }
                sum += (long)g;
            }
            gcdMap.put( Y, sum );
        }
    }
    
    private static void compute( final List<Integer>a, final Map<Integer,Long> gcdMap, int X, int Y )
    {
        long sum =0;
        for( int i = X-1; i < Y; i++ )
        {
            sum = (sum + gcdMap.get( a.get( i ) )) % 1000000007 ;
        }
        System.out.println( sum );
    }
    
    private static int gcd(int a, int b) 
    {
        if( a == b ) return a;
        
        while( a > 0 && b > 0 )
        {
            if( a > b )
            {
                a = a - b;
            }
            else
            {
                b = b - a;
            }
        }
        
        return a !=0 ? a :b;
    }
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        in.nextLine();
        String strN = in.nextLine();
        String[] strArr = strN.split( " " );
        final Map<Integer, Long> gcdMap = new HashMap<>();
        final Map<String, Integer> gMap = new HashMap<>();
        final List<Integer> a = new ArrayList<>();
        for( int k=0; k < N ; k++ )
        {
            a.add( Integer.parseInt( strArr[k] ) );
        }
        
        solve( a, gcdMap, gMap );
        
        int Q = in.nextInt();
        
        in.nextLine();
        for( int i = 0; i < Q; i++ )
        {
            String s = in.nextLine();
            String[] sArr = s.split( " " );
            int X = Integer.parseInt( sArr[1] );
            int Y = Integer.parseInt( sArr[2] );
            if( "C".equals( sArr[0] ))
            {
                compute( a, gcdMap, X, Y );
            }
            else if( "U".equals( sArr[0] ))
            {
                update( a, gcdMap, gMap, X, Y );
            }
        }
        
        in.close();
        //System.out.println(cnt) ;
    }
}
