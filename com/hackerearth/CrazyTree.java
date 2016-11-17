package com.hackerearth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CrazyTree
{
    static int M = 1299709;
    private static final long[][] crazyMap( int L  )
    {
        int pt = (int)Math.pow( 2, L-1 );
        final long[][] sumMap = new long[L][pt];
        L -= 1;
        
        List<Long> a = null;
        while( L >= 0 )
        {
            if( null != a )
            {
                final List<Long> b = new ArrayList<>();
                
                long sum = 0;
                int k =0;
                for( int i = 0; i < a.size(); i+= 2)
                {
                    long t = (a.get( i )%M * a.get( i+1 )%M)%M; 
                    b.add( t );
                    sum = (sum + t)%M;
                    sumMap[L][k++] = sum;
                }
                a=b;
            }
            else
            {
                a = new ArrayList<>();
                long sum =0;
                
                for( int i = 1; i <= pt; i++ )
                {
                    a.add( (long)i%M );
                    sum = (sum%M + i%M)%M;
                    sumMap[L][i-1] = sum;
                }
            }
            L--;
        }
        
        return sumMap;
    }
    
    
    private static long getSum( final long[][]sumMap,int N, int x, int y, int P )
    {
        if( x > y || x < 1 || x > P || y > P )
        {
            return 0;
        }
        
        long ySum = sumMap[N-1][y-1];
        if( x == 1)
        {
            return ySum;
        }
        else
        {
            return ySum - sumMap[N-1][x-2];
        }
    }
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int Q = in.nextInt();
        
        final long[][] sumMap = crazyMap( L );
        int P = (int)Math.pow( 2, L-1 );
        for( int i =0; i < Q; i++)
        {
            int N = in.nextInt();
            int X = in.nextInt();
            int Y = in.nextInt();
            
            System.out.println( getSum( sumMap, N, X, Y, P ));
        }
        
        in.close();
        //System.out.println(cnt) ;
    }
}
