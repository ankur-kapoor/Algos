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

 * @author ankurkap
 *
 */

public class LinearRecurrences
{
    private static long a,b,c,d,e,f,sum;
    private static int prevF,prevG,prevH;
    private static Long[] F = new Long[10000];
    private static Long[] G = new Long[10000];
    private static Long[] H = new Long[10000];
    private static Long[] SUM = new Long[10000];
    
    private static int MOD = 1000000007;
    
    private static long F( int n )
    {
        if( n < 0 )
        {
            return 0;
        }
        
        if( n < F.length && F[n] != null )
        {
            return F[n]%MOD;
        }
        
        if( n >= F.length )
        {
            Long[] temp = Arrays.copyOf( F, 2*n );
            F = temp;
        }
        
        for( int i = prevF+1; i <=n; i++ )
        {
            F[i] = ((a*F[i-1]%MOD)%MOD + (b*G[i-2]%MOD)%MOD)%MOD;
        }
        
        prevF = n;
        return F[n];
    }
    
    private static long G( int n )
    {
        if( n < 0)
        {
            return 0;
        }
        
        if( n < G.length && G[n] != null )
        {
            return G[n]%MOD;
        }
        
        if( n >= G.length )
        {
            Long[] temp = Arrays.copyOf( G, 2*n );
            G = temp;
        }
        
        for( int i = prevG+1; i <=n; i++ )
        {
            G[i] = ((c*G[i-1]%MOD)%MOD + (d * F[i-2])%MOD)%MOD;
        }
        
        prevG = n;
        
        return G[n];
    }
    
    private static long H( int n )
    {
        if( n < 0)
        {
            return 0;
        }
        
        if( n < SUM.length && SUM[n] != null )
        {
            return SUM[n] % MOD;
        }
        
        if( n >= SUM.length )
        {
            Long[] temp = Arrays.copyOf( SUM, 2*n );
            SUM = temp;
        }
        
        if( n >= H.length )
        {
            Long[] temp = Arrays.copyOf( H, 2*n );
            H = temp;
        }
        
        
        for( int i = prevH +1; i <=n; i++ )
        {
            H[i] = ((e*F(i))%MOD + (f*G(i))%MOD)%MOD;
            sum  = (sum%MOD + H[i])%MOD;
            SUM[i] = sum;
        }
        
        prevH = n;
        sum = SUM[n];
        return SUM[n];
    }
    
    
    private static void solve( int n )
    {
        System.out.println( H( n ));
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
        F[0] = Long.parseLong( st[6] );
        F[1] = Long.parseLong( st[7] );
        G[0] = Long.parseLong( st[8] );
        G[1] = Long.parseLong( st[9] );
        prevF = 1;
        prevG = 1;
        prevH = -1;
        sum = 0;
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
