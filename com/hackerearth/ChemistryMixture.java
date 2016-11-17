package com.hackerearth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ChemistryMixture
{
   
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for( int i =0; i < T; i++)
        {
            long m = in.nextLong();
            int n1 = in.nextInt();
            int n2 = in.nextInt();
            
            final Map<Long,Long> am = new HashMap<>();
            for( int j =0; j < n1; j++ )
            {
                long t = in.nextLong();
                am.put( t, t );
            }
            
            final Map<Long,Long> wa = new HashMap<>();
            for( int j =0; j < n2; j++ )
            {
                long t = in.nextLong();
                wa.put( t, t );
            }
            
            List<Long> res = new ArrayList<>();
            long sum = 0;
            String g = Long.toBinaryString( m );
            long rem = 0;
            final Map<Long,Long> remList = new HashMap<>();
            for( int k =0; k < g.length(); k++ )
            {
                if((m & 1<<k) != 0)
                {
                    long t = (long)Math.pow( 2, k );
                    if( am.containsKey( t ) )
                    {
                        res.add( t );
                        am.remove( t );
                        sum += t;
                    }
                    
                    rem += t;
                    
                    if( wa.containsKey( rem ))
                    {
                        remList.put( rem, rem );
                    }
                }
            }
            
            if( sum == m || remList.containsKey( m-sum ) )
            {
                System.out.println( "YES");
                for( int k=0;k < res.size(); k++ )
                {
                    System.out.print( res.get( k ) + " " );
                }
                System.out.println("");
            }
            else
            {
                System.out.println( "NO");
            }
        }
        
        //System.out.println( res );
        
        in.close();
        //System.out.println(cnt) ;
    }
}
