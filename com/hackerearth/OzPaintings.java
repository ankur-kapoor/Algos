package com.hackerearth;

import java.util.Scanner;

public class OzPaintings
{
    private static void solve( int W, int R, int G )
    {
        long p = 0;
        
        if( W >= 3)
        {
            p += W/3;
            W = W%3;
        }
        
        if( R >= 3)
        {
            p += R/3;
            R = R%3;
        }
        
        if( G >= 3)
        {
            p += G/3;
            G = G%3;
        }
        
        while( W > 0 && R > 0 && G > 0 )
        {
            p++;
            W--;
            G--;
            R--;
        }
        
        System.out.println(p);
    }
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        for( int i =0; i < T; i++)
        {
            int W = in.nextInt();
            int R = in.nextInt();
            int G = in.nextInt();
            
            solve( W, R, G );
        }
        
        in.close();
        //System.out.println(cnt) ;
    }
}
