package com.hackerearth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 *Write a program that prints the numbers in the given range. But for multiples of three print “Fizz” instead of the number and for the multiples of five print “Buzz”. For numbers which are multiples of both three and five print “FizzBuzz”. Print a new line after each string or number.

Input Format First line will be the number of testcases, T. Next line will have T integers, denoted by N.

Output Format For each testcase, print the number from 1 to N. But follow the rules given in the problem statement.

Constraints

1 <= T <= 10

N is an integer.
 * @author ankurkap
 *
 */

public class Amazon2
{
    
    public static class V
    {
        int m_node;
        List<E> m_edges = new ArrayList<>();
        
        V( int n )
        {
            m_node = n;
        }
       
        public void addEdge( int e, int wt)
        {
            m_edges.add( new E( e, wt ) );
        }
    }
    
    public static class E
    {
        int node;
        int wt;
        
        E( int n, int w)
        {
            node = n;
            wt = w;
        }
    }
    
    
    private static void populate( int v, int e, int wt, final Map<Integer, V> graphMap )
    {
        if( graphMap.containsKey( v ))
        {
            V vg = graphMap.get( v );
            vg.addEdge( e, wt );
        }
        else
        {
            V vg = new V( v );
            vg.addEdge( e, wt );
            graphMap.put( v, vg );
        }
    }
    
    private static void process( Map<Integer, V> graphMap )
    {
        long sum = 0;
        
        for( Entry<Integer, V> e : graphMap.entrySet() )
        {
            int v = e.getKey();
            V vg = e.getValue();
            sum += calSum( vg, 0, graphMap )%1000000007;
        }
        
        System.out.println( sum );
    }
    
    private static int calSum( V vg, int max, Map<Integer, V> graphMap )
    {
        if( null == vg)
        {
            return 0;
        }
        
        int sum = 0;
        for( E e : vg.m_edges )
        {
            max = Math.max( e.wt, max );
            sum = (sum + max + calSum( graphMap.get( e.node ),max, graphMap ))%1000000007;
        }
        
        return sum;
    }
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        for( int i =0; i < T; i++ )
        {
            final Map<Integer, V> graphMap = new HashMap<>();
            int N = in.nextInt();
            in.nextLine();
            for( int j =0; j < N-1; j++ )
            {
                String s = in.nextLine();
                String[] sArr = s.split( " " );
                
                populate( Integer.parseInt( sArr[0] ), Integer.parseInt( sArr[1] ), Integer.parseInt( sArr[2] ), graphMap );
            }
            
            process( graphMap );
        }
        
        in.close();
        //System.out.println(cnt) ;
    }
}
