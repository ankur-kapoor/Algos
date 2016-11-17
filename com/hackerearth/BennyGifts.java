package com.hackerearth;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://www.hackerearth.com/march-easy-16/algorithm/benny-and-gifts-marcheasy-3/
  * @author ankurkap
 *
 */

public class BennyGifts
{
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        
        if( null == S || S.trim().length() == 0 )
        {
            System.out.println( 0 );
        }
        else
        {
            S = S.trim();
            int N = S.length();
            
            final Set<Pair> set = new HashSet<>();
            char[] chArr = S.toCharArray();
            
            set.add( new Pair(0,0) );
            int cnt =0;
            int X = 0;
            int Y = 0;
            for( int i =0; i< N; i++ )
            {
                char ch = chArr[i];
                
                if( ch == 'R')
                {
                    Y++;
                }
                else if( ch =='L')
                {
                    Y--;
                }
                else if( ch == 'U')
                {
                    X--;
                }
                else if( ch == 'D')
                {
                    X++;
                }
                
                if( !set.add( new Pair(X, Y) ) )
                {
                    cnt++;
                }
            }
            
            System.out.println( cnt );
        }
        
        in.close();
    }
    
    
    static class Pair
    {
        Integer X;
        Integer Y;
        
        Pair( int x, int y )
        {
            X = x;
            Y = y;
        }
        
        @Override
        public boolean equals( Object o)
        {
            final Pair p = (Pair)o;
            
            return (X == p.X && Y== p.Y);
        }
        
        @Override
        public int hashCode()
        {
            return X.hashCode()*-2 + Y.hashCode()*2;
        }
    }
}
