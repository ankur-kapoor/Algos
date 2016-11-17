package com.hackerearth;

import java.util.Scanner;

public class RodCutting
{
   
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        for( int i=0; i < T; i++ )
        {
            int n = in.nextInt();
            
            int res = 0;
            
            while( n != 1 )
            {
                if( n%2 != 0 )
                {
                    n--;
                    res++;
                }
                
                n = n/2;
            }
            
            System.out.println( res );
        }
        
        in.close();
    }
    
}
