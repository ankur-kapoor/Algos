package com.hackerearth;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *https://www.hackerearth.com/quintype-backend-hiring-challenge/problems/cbe772895d0245cfbd4ee14ce288aee3/
 * @author ankurkap
 *
 */

public class OzDivisors
{
    
    private static int MOD = 1000000007;
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int res = 1;
        final Set<Integer> s = new HashSet<>();
        s.add( 1 );
        Integer pr = 1;
        for( int k=0; k < N ; k++ )
        {
            int num = in.nextInt();
            if(s.add( num ))
            {
                res = (res%MOD + 1)%MOD;
            }
            res = (res + getProductCount( num, s ))%MOD;
            pr = (pr*num) % Integer.MAX_VALUE ;
        }
        
        if( !s.contains( pr ))
        {
            res = (res%MOD + 1)%MOD;
        }
            
        System.out.println( res );
        in.close();
        //System.out.println(cnt) ;
    }
    
    private static int getProductCount( int num, final Set<Integer> s )
    {
        int sqrt = (int)Math.sqrt( num );
        
        int c =0;
        for( int i = 2; i <= sqrt; i++ )
        {
            if( num%i == 0 && s.add( i ) )
            {
                c = (c%MOD+1)%MOD;
            }
        }
        
        return c;
    }
}
