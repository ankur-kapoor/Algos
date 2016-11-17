package com.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/hourrank-6/challenges/bear-and-workbook
 * @author ankurkap
 *
 */

public class HR7_1
{
    
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String C = in.next();
        
        char[] ch = C.toCharArray();
        
        int cnt = 1;
        char c = ch[0];
        for( int i = 1; i < N; i++ )
        {
            if( c != ch[i])
            {
                cnt++;
            }
            c = ch[i];
        }
        
        System.out.println(cnt) ;
    }
}
