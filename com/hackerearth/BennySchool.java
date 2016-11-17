package com.hackerearth;

import java.util.Scanner;

/**
 * https://www.hackerearth.com/june-easy-16/algorithm/benny-and-her-school-reports/
  * @author ankurkap
 *
 */

public class BennySchool
{
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        for( int i=0; i < T ; i++ )
        {
            final int N = in.nextInt();
            final int M = in.nextInt();
            final int X = in.nextInt();
            
            long marksSum = 1L * (N+1) * X;
            for( int j =0; j < N; j++ )
            {
                marksSum -= (1L*in.nextInt());
            }
            
            long R = Math.max( 1L, marksSum );
            
            if( R > (M*1L) )
            {
                System.out.println( "Impossible" );
            }
            else
            {
                System.out.println( R );
            }
        }
        
        in.close();
    }
}
