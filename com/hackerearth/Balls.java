package com.hackerearth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *A square pyramid of balls consists of square layers of balls stacked on top of each other. The i th (1-based indexing )layer from the top consists of exactly i2 balls. Image

You have received one such beautiful square pyramid on your birthday, with each layer having a unique color. However, being the clumsy doofus you are, you knocked it over and lost some(maybe all) balls of some(maybe all) layers. You quickly gather the balls and try to reconstruct a square pyramid(maybe of a different height) by using all the recovered balls and replacing the missing balls by new ones from the nearby shop(remember, all layers had unique colors, so you couldn't use balls from one layer in another). Find the minimum number of balls you shall have to purchase.

Input:

You are given an integer N, the number of layers having at-least one recovered ball.

Then N space separated integers follow in the next line, with A[i] representing the number of recovered balls in the ith such layer

Output:

Print the required value.

Constraints:

1 ≤ N ≤ 1,000,000

1 ≤ A[i] ≤ 1,000,000,000

SAMPLE INPUT 
5
1 2 3 4 5
SAMPLE OUTPUT 
40
 * @author ankurkap
 *
 */

public class Balls
{
    
    private static void solve( int N, final long[] a )
    {
        long sum =0;
        
        for( long i = 1, p=0; p < N; i++ )
        {
            long i2 = i*i;
            
            if( i2 < a[(int)p])
            {
                sum += i2;
            }
            else
            {
                sum += i2 - a[(int)p];
                p++;
            }
        }
        
        System.out.println( sum );
    }
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        in.nextLine();
        String strN = in.nextLine();
        String[] strArr = strN.split( " " );
        final long[] a = new long[N];
        for( int k=0; k < N ; k++ )
        {
            a[k]= Long.parseLong( strArr[k] );
        }
        
        Arrays.sort( a );
        solve( N, a);
        in.close();
        //System.out.println(cnt) ;
    }
}
