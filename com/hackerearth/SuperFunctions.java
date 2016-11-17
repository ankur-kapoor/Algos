package com.hackerearth;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *Reference - https://www.hackerearth.com/may-easy-16/algorithm/super-functions/
 * @author ankurkap
 *
 */

public class SuperFunctions
{
    private static long mod = 1000000007;
    private static Map<String, Long> gcdMap = new HashMap<>();
    
    private static long gcd(long a, long b) 
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
    
    private static long phi( long n )
    {
        double result = n;
        
        for( long p=2; p*p<=n; p++)
        {
            if (n % p == 0)
            {
                while (n % p == 0)
                {
                    n /= p;
                }
                    
                result *= (1.0 - (1.0 / (double) p));
            }
        }
     
        if (n > 1)
        {
            result *= (1.0 - (1.0 / (double) n));
        }
            
        return (long)result;
    }
    
    private static long superPowers( long n )
    {
        long sum =0;
        for( long i = 1; i <= n; i++ )
        {
            long po = (((long)Math.pow( n, i ))%mod);
            
            String s = i+"-"+n;
            
            Long gcd = gcdMap.get( s );
            
            if( null == gcd )
            {
                gcd = gcd( i, n );
                gcdMap.put( s , gcd );
            }
            
            sum = (sum%mod + (po%mod * gcd%mod)%mod)%mod;
        }
        
        return sum;
    }
    
    private static long superExps( long n )
    {
        long sum =0;
        for( long i = 1; i <= n; i++ )
        {
            long ex = ((long)Math.pow( 2, n+i )%mod);
            
            String s = i+"-"+n;
            
            Long gcd = gcdMap.get( s );
            
            if( null == gcd )
            {
                gcd = gcd( i, n );
                gcdMap.put( s , gcd );
            }
            
            sum = (sum + (ex * gcd)%mod)%mod;
        }
        
        return sum;
    }
    
    private static long superPhis( long n )
    {
        long sum = 0;
        
        for( long i = 1; i <= n; i++ )
        {
            long po = ((long)Math.pow( n, i )%mod);
            
            po = phi( po );
            
            String s = i+"-"+n;
            
            Long gcd = gcdMap.get( s );
            
            if( null == gcd )
            {
                gcd = gcd( i, n );
                gcdMap.put( s , gcd );
            }
            
            sum = (sum + (po * gcd)%mod)%mod;
        }
        return sum;
 }
    
    public static void main(String[] args) 
    {
      
        Scanner in = new Scanner(System.in);
        int Q = in.nextInt();
        
        for( int k=0; k < Q ; k++ )
        {
            int t = in.nextInt();
            long n = in.nextLong();
            
            if( t == 1 )
            {
                System.out.println( superPowers( n ) );
            }
            else if( t == 2 )
            {
                System.out.println( superExps( n ) );
            }
            else if( t == 3)
            {
                System.out.println( superPhis( n ) );
            }
        }
        
        in.close();
        //System.out.println(cnt) ;
    }
}
