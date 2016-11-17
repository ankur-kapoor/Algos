package com.hackerearth;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * https://www.hackerearth.com/june-easy-16/algorithm/benny-and-shopping/
  * @author ankurkap
 *
 */

public class BinnyIntrestingNumbers
{
    
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        final int[] a = new int[1000000];
        a[1] = 1;
        a[2] = 1;
        a[3] = 1;
        a[4] = -1;
        for( int k=0; k < T ; k++ )
        {
            long X = in.nextLong();
            
            if( X < 10000000 && a[(int)X] == 1 )
            {
                System.out.println( "Yes");
            }
            else if( X < 10000000 && a[(int)X] == -1 )
            {
                System.out.println( "No");
            }
            else
            {
                long maxX = (long)Math.sqrt( X );
                
                int sumI = 1;
                for( long i =2; i <= maxX; i++ )
                {
                    if( X%i == 0L && isIntersting( i, a ))
                    {
                        sumI++;
                    }
                }
                
                if( (sumI % 2) != 0 )
                {
                    if( X < 10000000)
                    {
                        a[(int)X] = 1;
                    }
                    
                    System.out.println( "Yes" );
                }
                else
                {
                    if( X < 10000000)
                    {
                        a[(int)X] = -1;
                    }
                    System.out.println( "No" );
                }
            }
        }
        
        in.close();
    }
    
    private static boolean isIntersting( long X, int[] a )
    {
        if( a[(int)X] == 1 )
        {
            return true;
        }
        else if( a[(int)X] == -1)
        {
            return false;
        }
        
        final BigInteger b = BigInteger.valueOf( X );
        
        if( b.isProbablePrime( 1 ))
        {
            a[(int)X] = 1;
            return true;
        }
        else
        {
            long maxX = (long)Math.sqrt( X );
            int sumI = 1;
            for( long i =2; i <= maxX; i++ )
            {
                if( X%i == 0 && isIntersting( i, a ))
                {
                    sumI++;
                }
            }
            
            if( (sumI % 2) != 0 )
            {
                a[(int)X] = 1;
                return true;
            }
            else
            {
                a[(int)X] = -1;
                return false;
            }                
        }
        
    }
}
