package com.hackerearth;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerearth.com/june-easy-16/algorithm/benny-and-shopping/
  * @author ankurkap
 *
 */

public class BennyOdometer
{
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        for( int k=0; k < T ; k++ )
        {
            long N = in.nextLong();
            
            final List<Integer> nums = new ArrayList<>();
            while( N > 0L )
            {
                int rem = (int)(N%10L);
                if( rem > 3 )
                {
                    rem--;
                }
                nums.add( rem );
                
                N = N/10L;
            }
            
            long res = 0L;
            long t = 1L;
            for( int i=0; i < nums.size(); i++ )
            {
                res += 1L * nums.get( i )*t;
                t = t*9L;
            }
            
            System.out.println( res );
        }
        in.close();
    }
    
}
