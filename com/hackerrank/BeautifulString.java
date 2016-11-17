package com.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/hourrank-8/challenges/beautiful-binary-string
 * @author ankurkap
 *
 */

public class BeautifulString
{
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String S = in.next();
        List<Integer> li = new ArrayList<>();
        String p = "010";
        int m = 0;
        boolean isContiguous = false;
        for( int i =0; i <= N-3; )
        {
            String s = S.substring( i, i+3 );
            
            if( p.equals( s ) )
            {
                li.add( i );
                i += 2;
                
                if( !isContiguous )
                {
                    m++;
                }
                
                isContiguous = !isContiguous;
            }
            else
            {
                i++;
                isContiguous = false;
            }
        }
        
        System.out.println(m) ;
    }
}
