package com.interviewbit.Maths;

import java.util.ArrayList;

public class Arrange
{
    public void arrange(ArrayList<Integer> a) 
    {
        int n = a.size();
        
        for( int i =0; i < n; i++ )
        {
            int s = a.get( i ) + (a.get( a.get( i )) %n)*n;
            
            a.set( i, s );
        }
        
        for( int i =0; i < n; i++ )
        {
            int s = a.get( i )/n;
            
            a.set( i, s );
        }
    }

        
    public static void main(String[] args )
    {
        Arrange p = new Arrange();
        //System.out.println("Trailing Zeros = " + p.arrange( 4617 ) );
    }
}
