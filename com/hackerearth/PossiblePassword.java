package com.hackerearth;

import java.util.Scanner;

public class PossiblePassword
{
   
    private static void solve( String S, String P )
    {
        if( null == P || null == S )
        {
            System.out.println( "Impossible");
            return;
        }
        
        if( "" == P.trim() || "" == S.trim() )
        {
            System.out.println( "Impossible");
            return;
        }
        
        P = P.trim();
        S = S.trim();
        
        //P = P.toLowerCase();
        //S = S.toLowerCase();
        
        if( P.length() != (2*S.length()))
        {
            System.out.println( "Impossible");
            return;
        }
        
        int t = P.indexOf( S );
        if( t ==  -1 )
        {
            System.out.println( "Impossible");
            return;
        }
        
        int e = t+ S.length();
        
        String P1 = t > 0 ? P.substring( 0, t ) : "";
        String P2 = e < P.length() ? P.substring( e, P.length() ) : "";
        
        String newP = P1+P2;
        
        newP = newP.trim();
        
        if( newP.equals( S ))
        {
            System.out.println( "Possible");
        }
        else
        {
            System.out.println( "Impossible");
        }
    }
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        for( int i=0; i < T; i++ )
        {
            String S = in.next();
            String P = in.next();
            
            solve( S, P );
            
        }
        
        in.close();
    }
    
}
