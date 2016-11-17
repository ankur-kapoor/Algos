package com.hackerearth;

import java.util.Arrays;
import java.util.Scanner;

/**
 *You are given the following recurrences,

F(n) = a * F(n - 1) + b * G(n - 2) for n >= 2

G(n) = c * G(n - 1) + d * F(n - 2) for n >=2

H(n) = e * F(n) + f * G(n) for n >= 0

Input

First line contains the following 10 numbers in order : a, b, c, d, e, f, F[0], F[1], G[0], G[1].

Next line contains a single integer Q, the number of queries. The following Q lines contain a single query integer each: n

Output

For each query parameter n, output the sum H[0] + H[1] +......+ H[n] modulo 1,000,000,007 in a separate line.

Constraints

1 <= Q <= 1,000,000

All other input parameters lie in the range [0, 1,000,000,000]

SAMPLE INPUT 
1 2 3 4 5 6 1 2 3 4
2
2 
3
SAMPLE OUTPUT 
193
609
reference - https://www.hackerearth.com/april-easy-16/algorithm/aprileasy-easy-linear-recurrences/editorial/ 

 * @author ankurkap
 *
 */

public class LinearRecurrences2
{
    private static long a,b,c,d,e,f,F0,F1,G0,G1,H0,H1;
    private static long [][][]M = new long[20][5][5];
    private static int MOD = 1000000007;
    private static long[] B = new long[5];
    private static void seedData()
    {
        H0 = ((e*F0)%MOD + (f*G0)%MOD)%MOD;
        H1 = ((e*F1)%MOD + (f*G1)%MOD)%MOD;
        
        M[0][0][0] = a;
        M[0][0][3] = b;
        M[0][1][0] = 1;
        M[0][2][1] = d;
        M[0][2][2] = c;
        M[0][3][2] = 1;
        M[0][4][0] = (e * a) % MOD;
        M[0][4][1] = (f * d) % MOD;
        M[0][4][2] = (f * c) % MOD;
        M[0][4][3] = (e * b) % MOD;
        M[0][4][4] = 1;
        
        for( int i =1; i < 20; i++ )
        {
            matrixMultiply( M[i-1], M[i-1], M[i] );
        }
    }
    
    private static void matrixMultiply( long[][] A, long[][] B, long[][] C )
    {
        for( int i = 0; i < 5; i++ )
        {
            for( int j = 0; j < 5; j++ )
            {
                for( int k = 0; k < 5; k++ )
                {
                    C[i][j] = (C[i][j] + (A[i][k] * B[k][j])%MOD)%MOD;  
                }
            }
        }
    }
    
    private static void solve( int n )
    {
        if(n == 0)
        {
            System.out.println( H0 );
            return;
        }
        
        n = n-1;
        B[0] = F1;
        B[1] = F0;
        B[2] = G1;
        B[3] = G0;
        B[4] = (H0 + H1) % MOD;
        
        for( int i =0; i < 20; i++ )
        {
            if((n &(1<<i)) != 0)
            {
                matrixMultiply( M[i], B, B ); 
            }
        }
        
        System.out.println( B[4] );
    }
    
    private static void matrixMultiply( long[][] A, long[] B, long[] C )
    {
        long[] temp = new long[5];
        for( int i = 0; i < 5; i++ )
        {
            for( int j = 0; j < 5; j++ )
            {
                temp[i] = (temp[i] + (A[i][j]*B[j])%MOD)%MOD;
            }
        }
        
        for( int i = 0; i < 5; i++ )
        {
            C[i] = temp[i];
        }
    }
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        String S = in.nextLine();
        
        final String[] st = S.split( " " );
        a = Long.parseLong( st[0] );
        b = Long.parseLong( st[1] );
        c = Long.parseLong( st[2] );
        d = Long.parseLong( st[3] );
        e = Long.parseLong( st[4] );
        f = Long.parseLong( st[5] );
        F0 = Long.parseLong( st[6] );
        F1 = Long.parseLong( st[7] );
        G0 = Long.parseLong( st[8] );
        G1 = Long.parseLong( st[9] );
        
        seedData();
        int Q = in.nextInt();
        
        for( int k=0; k < Q; k++ )
        {
            int q = in.nextInt();
            solve( q );
        }
        
        in.close();
        //System.out.println(cnt) ;
    }
}
