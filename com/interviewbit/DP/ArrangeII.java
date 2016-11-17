package com.interviewbit.DP;

import java.util.HashMap;
import java.util.Map;


public class ArrangeII
{
    public int arrange( String val, int K )
    {
        if( K > val.length()) return -1;
        
        if( K == val.length()) return 0;
        
        int t = val.substring( K-1 ).length();
        final Map<String,Integer> map = new HashMap<>();
        int min = combine( val, 0, 0, K, t, map, Integer.MAX_VALUE, 0 );
        
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    
    private int combine( String horse, int k, int start, int K, int t, final Map<String,Integer> map, int min, int pathSum )
    {
        if( pathSum >= min )
        {
            return min;
        }
        
        if( k == K-1 && start < horse.length())
        {
            String st = horse.substring( start );
            
            Integer temp = map.get( st );
            
            if( null == temp )
            {
                temp = getProduct( st );
                map.put( st, temp );
            }
            
            pathSum += temp;
            
            return Math.min( pathSum, min );
        }
        
        for( int i =start; i < start + t && i < horse.length(); i++ )
        {
            if( i+1 < horse.length() )
            {
                String st = horse.substring( start, i+1 );
                
                Integer temp = map.get( st );
                
                if( temp == null)
                {
                    temp = getProduct( st );
                    map.put( st, temp );
                }
                
                pathSum += temp;
                
                if( pathSum < min )
                {
                    k++;
                    min = Math.min( combine( horse, k, i+1, K, t+1, map, min, pathSum ), min );
                    k--;
                }
                
                pathSum -= temp;
            }
            else
            {
                break;
            }
        }
        
        return min;
    }
    
    private int getProduct( String s )
    {
        int w = 0;
        int b = 0;
        
        char[] chAr = s.toCharArray();
        
        for( int i=0; i < chAr.length; i++ )
        {
            if( chAr[i] == 'W')w++;
            else if( chAr[i] == 'B')b++;
        }
        
        return w*b;
    }
    
    public static void main( String[] args )
    {
        final ArrangeII ar = new ArrangeII();
        
        System.out.println( ar.arrange( "BWBWWWWBWBBWBWBWBBWBBBWWWBWBWBWWWBWBWBWBBWBW", 19 ) ); 
    }
}
