package com.hackerearth;

import java.util.Scanner;

public class LibraryBoy
{
   
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        char[] shelvs = new char[26];
        int res = 0;
        for( int i =0; i < N; i++)
        {
            String s = in.nextLine();
            char ch = s.charAt( 0 );
            
            shelvs[ch - 'a']++;
            
            if( shelvs[ch - 'a'] == 10 )
            {
                shelvs[ch - 'a'] = 0;
                res++;
            }
        }
        
        for( int i =0; i < 26; i++ )
        {
            if( shelvs[i] > 0 )
            {
                res++;
            }
        }
        
        System.out.println( res );
        
        in.close();
        //System.out.println(cnt) ;
    }
}
