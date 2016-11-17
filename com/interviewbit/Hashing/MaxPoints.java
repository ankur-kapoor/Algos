package com.interviewbit.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */

public class MaxPoints
{
    
    public int maxPoints( ArrayList<Integer> a, ArrayList<Integer> b )
    {
        if ( a.size() == 0 )
            return 0;
        if ( a.size() == 1 )
            return 1;
        int result = 0;
        for ( int i = 0; i < a.size(); i++ )
        {
            HashMap<Double, Integer> hm = new HashMap<Double, Integer>();
            int samex = 1;
            int samep = 0;
            for ( int j = 0; j < a.size(); j++ )
            {
                if ( j != i )
                {
                    if ( ( a.get( j ) == a.get( i ) ) && ( b.get( j ) == b.get( i ) ) )
                    {
                        samep++;
                    }
                    if ( a.get( j ) == a.get( i ) )
                    {
                        samex++;
                        continue;
                    }

                    double k = (double)( b.get( j ) - b.get( i ) ) / (double)( a.get( j ) - a.get( i ) );
                    if ( hm.containsKey( k ) )
                    {
                        hm.put( k, hm.get( k ) + 1 );
                    }
                    else
                    {
                        hm.put( k, 2 );
                    }
                    result = Math.max( result, hm.get( k ) + samep );
                }
            }
            result = Math.max( result, samex );
        }
        return result;
    }
    
    private double getSlope( Point p1, Point p2 )
    {
        if( p2.x- p1.x == 0) return Double.MAX_VALUE; 
        return ( p2.y - p1.y)/(p2.x- p1.x);
    }
    
    public static void main( String[] args )
    {
        Point p = new Point(0,0);
        Point p2 = new Point(-1,-1);
        Point p3 = new Point(2,2);
        
        Point[] pArr = {p,p2,p3};
        //System.out.println( " ColorFul = "+ t.colorful( 230 ) );
        MaxPoints m = new MaxPoints();
        //System.out.println( " 2D Points = " + m.maxPoints( pArr )  );
    }
}

class Point {
         int x;
         int y;
         Point() { x = 0; y = 0; }
         Point(int a, int b) { x = a; y = b; }
     }