package com.topcoder;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author ankurkap
 *
 */
public class Quacking
{
    public int quack( String s )
    {
        if( null == s || s.length() == 0)
        {
            return -1;
        }
        final String S = "quack";
        final char[] str = s.toCharArray();
        
        if( str[0] != 'q')return -1;
        
        final List<String> l = new ArrayList<>(); 
        
        int res =0;
        for( int i =0; i < s.length(); i++ )
        {
            if( l.isEmpty() )
            {
                l.add( String.valueOf( str[i] ) );
            }
            else
            {
                boolean flip = false;
                int m = l.size();
                for( int k = 0; k < m; k++ )
                {
                    String t = l.get( k ) + str[i];
                    
                    if( S.startsWith( t ))
                    {
                        if( S.equals( t ))
                        {
                            l.remove( k );
                        }
                        else
                        {
                            l.set( k, t );
                        }
                        flip = true;
                        
                        break;
                    }
                }
                
                if( !flip )
                {
                    l.add( String.valueOf( str[i] ) );
                }
            }
            
            if( l.size() > res )
            {
                res = l.size();
            }
        }
        
        if( l.size() > 0 ) return -1;
        
        return res;
    }
    
    
   /* public static void main( String[] args )
    {
        final Quacking c = new Quacking();
        
        System.out.println( "Quacking =  " + c.quack( "quackqauckquack" )   );
    }*/
}
