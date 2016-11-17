package com.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/hourrank-6/challenges/bear-and-workbook
 * @author ankurkap
 *
 */

public class HR7_3
{
    
    private static void usingDfs( final ArrayList<Integer> a, int in, final ArrayList<Integer> paths, final Map<String,ArrayList<Integer>> res, String key )
    {
        if( !res.containsKey( key ))
        {
            res.put( key, new ArrayList<Integer>(paths));
        }
        
        for( int i = in; i < a.size(); i++ )
        {
            paths.add( a.get( i ) );
            key = getKey( paths );
            usingDfs( a, i+1, paths, res, key );
            paths.remove( paths.size()-1 );
        }
    }
    
    private static String getKey( ArrayList<Integer> a )
    {
        StringBuilder st = new StringBuilder();
        
        for( int num : a )
        {
            st.append( num );
        }
        
        return st.toString();
    }
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        for( int i = 0; i < T; i++ )
        {
            int N = in.nextInt();
            ArrayList<Integer> a = new ArrayList<>();
            for( int k=0; k < N ; k++ )
            {
                a.add( k+1 );
            }
            
            final Map<String,ArrayList<Integer>> resMap = new LinkedHashMap<>();

            usingDfs( a, 0, new ArrayList<Integer>(), resMap, "" );

            System.out.println( resMap.size()-1);
        }
        
        in.close();
        //System.out.println(cnt) ;
    }
}
