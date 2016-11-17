package com.hackerearth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MicroArray
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int Q = in.nextInt();
        
        final ArrayList<Integer> a = new ArrayList<>();
        final Map<Integer,Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for( int i =0; i < N; i++)
        {
            a.add( in.nextInt() );
            map.put( i+1, a.get( i ) );
            
            if( max < a.get( i ) )
            {
                max = a.get( i );
            }
        }
        
        for( int i =0; i < Q; i++)
        {
            int O = in.nextInt();
            
            if( O == 0 )
            {
                int x = in.nextInt();
                int y = in.nextInt();
                
                a.set( x-1, y );
                map.put( x, y );
                
                if( y > max )
                {
                    max = y;
                }
            }
            else if ( O == 1)
            {
                int v = in.nextInt();
                
                if( v > max )
                {
                    System.out.println( -1 );
                }
                else
                {
                    for( int j =1; j <= N; j++ )
                    {
                        if( map.get( j ) >= v )
                        {
                            System.out.println( j);
                            break;
                        }
                    }
                }   
            }
        }
        
        in.close();
        //System.out.println(cnt) ;
    }
}
