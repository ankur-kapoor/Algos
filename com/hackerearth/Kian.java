package com.hackerearth;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *The great Kian is looking for a smart prime minister. He's looking for a guy who can solve the OLP (Old Legendary Problem). OLP is an old problem (obviously) that no one was able to solve it yet (like P=NP).

But still, you want to be the prime minister really bad. So here's the problem:

Given the sequence a1, a2, ..., an find the three values a1 + a4 + a7 + ..., a2 + a5 + a8 + ... and a3 + a6 + a9 + ... (these summations go on while the indexes are valid).

Input

The first line of input contains a single integer n (1 ≤ n ≤ 105).

The second line contains n integers a1, a2, ..., an separated by space (1 ≤ ai ≤ 109).

Output

Print three values in one line (the answers).

SAMPLE INPUT 
5
1 2 3 4 5

SAMPLE OUTPUT 
5 7 3 
Time Limit: 1 sec(s) for each input file.
Memory Limit:   256 MB
Source Limit:   1024 KB
 * @author ankurkap
 *
 */

public class Kian
{
    
    private static void solve( ArrayList<Integer> A )
    {
        int n = A.size();
        
        long[] res = new long[3];
        
        for( int i = 0; i < n; i++ )
        {
            res[i%3] += (long)A.get( i );
        }
        
        for( int i =0; i < 3; i++ )
        {
            System.out.print( res[i] + " ");
        }
        
    }
    
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        in.nextLine();
        
        String strN = in.nextLine();
        String[] strArr = strN.split( " " );
        final ArrayList<Integer> a = new ArrayList<>();
        for( int k=0; k < T ; k++ )
        {
            a.add( Integer.valueOf( strArr[k] ) );
        }
        
        solve( a );
        
        in.close();
        //System.out.println(cnt) ;
    }
}
