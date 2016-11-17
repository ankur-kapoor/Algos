package com.hackerearth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ChemistryMixture2
{
   
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for( int t =0; t < T; t++)
        {
            long m = in.nextLong();
            int n1 = in.nextInt();
            int n2 = in.nextInt();
            
            long[] a = new long[n1];
            for( int i =0; i < n1; i++)
            {
                a[i] = in.nextLong();
            }
            
            Arrays.sort( a );
            
            long[] b = new long[n2];
            for( int i = 0; i < n2; i++ )
            {
                b[i] = in.nextLong();
            }
            
            boolean solved = false;
            List<Long> bestres = new ArrayList<>();
            long best_sum = -1;
            
            for( int bit = 0; bit < (1<<n2); bit++ )
            {
                long s = 0;
                
                for( int i =0; i < n2; i++ )
                {
                    if( (bit & (1<<i)) != 0 )
                    {
                        s += b[i];
                    }
                }
                
                long total = m - s;
                List<Long> res = new ArrayList<>();
                
                for( int i = n1-1; i >=0; i-- )
                {
                    if( a[i] <= total )
                    {
                        res.add( 0,a[i] );
                        total -= a[i];
                        
                        if( total == 0 )break; 
                    }
                }
                
                if( total == 0 )
                {
                    long curSum = m -s;
                    
                    if( curSum > best_sum )
                    {
                        best_sum = curSum;
                        bestres = res;
                        solved = true;
                    }
                }
            }
            
            if( solved )
            {
                System.out.println("YES");
                for( int i =0; i < bestres.size();i++)
                {
                    System.out.print( bestres.get( i ) + " ");
                }
                System.out.println("");
            }
            else
            {
                System.out.println("NO");
            }
        }
        
        //System.out.println( res );
        
        in.close();
        //System.out.println(cnt) ;
    }
}
