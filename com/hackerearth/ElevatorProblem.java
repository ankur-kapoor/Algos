package com.hackerearth;

import java.util.ArrayList;
import java.util.Scanner;

public class ElevatorProblem
{
    public static void main(String[] args) 
    {
        int mod = 1000000007;
        Scanner in = new Scanner(System.in);
        long N = in.nextLong();
        long Q = in.nextLong();
        
        //final Map<Long,Long> divisorMap = new HashMap<>();
        //final Map<Long,Boolean> primeMap = new HashMap<>();
        
        long D =0;
        long remK = 0;
        long prevF = 1;
        for( int t =0; t < Q; t++)
        {
            int type = in.nextInt();
            long F = in.nextLong();
            long K = in.nextLong();
            
            if( type == 1 )
            {
                if( isPrime( F+K ) )
                {
                    remK = (remK+ Math.abs( F-prevF ))%mod;
                    D += K;
                    prevF = F;
                }
            }
            else if( type == 2 )
            {
                
                long  d = (long)allFactors( F+K );
                
                if( d%2 != 0 )
                {
                    remK = (remK+ Math.abs( F-prevF ))%mod;
                    D -= K;
                    prevF = F;
                }
            }
        }
        
        System.out.print( remK + " " + D );
        //System.out.println( res );
        
        in.close();
        //System.out.println(cnt) ;
    }
    
    private static boolean isPrime( long a )
    {
        if( a==1 || a==0 ) 
        {
            return false;
        }
        
        final double as = Math.sqrt( a );
        boolean hasFactor = false;
        for( int i =2; i <= as; i++ )
        {
            if( a% i == 0 )
            {
                hasFactor = true;
            }
        }
        
        return !hasFactor;
    }
    
    private static int allFactors( long a ) 
    {
        final ArrayList<Long> res = new ArrayList<>();
        if( a==1 || a==0 ) 
        {
            return 1;
        }
        
        final double as = Math.sqrt( a );
        res.add( (long)1 );
        for( long i =2; i <= as; i++ )
        {
            if( a% i == 0 )
            {
                res.add( i );
            }
        }
        
        int resSize = res.size();
        for( int i =resSize-1; i >= 0 ; i--)
        {
            long num = a/res.get( i );
            
            if( num != res.get( i ))
            {
                res.add( a/res.get( i ) );
            }
        }
        
        return res.size();
    }
}
