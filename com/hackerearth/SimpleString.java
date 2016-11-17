package com.hackerearth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Given a string 
S
S of length 
N
N consisting of only lower-case English alphabets, you will be asked to process 
Q
Q queries over it . In each query you will be given two lower case characters 
X
X and 
Y
Y. Your task is to find out the number of such substrings of the the string 
S
S which have the characters 
X
X and 
Y
Y on either of its end points, both 
X
X...
Y
Y and 
Y
Y...
X
X are considered to be valid. 
Note : Substrings length should be greater than 
1
1. 

Input:
The first line of the input will contain 
N
N , the length of the string. 
Next line will contain as string of length 
N
N. Next line will will contain 
Q
Q , the number of queries. Then 
Q
Q subsequent lines will contain two lowercase characters 
X
X and 
Y
Y separated by a space.

Output:
For each query , output the answer in a separate line.

Constraints:
1
≤
N
≤
10
6
1≤N≤106
1
≤
Q
≤
10
3
1≤Q≤103
Sample Input(Plaintext Link)
 5
aacbb
2
a c
a b
Sample Output(Plaintext Link)
 2
4
 * @author ankurkap
 *
 */
public class SimpleString
{
    private static int countSubArray( final Map<Character, List<Integer>> charMap, char X, char Y)
    {
        final List<Integer> listX = charMap.get( X );
        final List<Integer> listY = charMap.get( Y );
        
        if( listX == null || listY == null )
        {
            return 0;
        }
        
        if( X == Y )
        {
            return listX.size()-1;
        }
        
        int cntX = listX.size();
        int cntY = listY.size();
        
        return (cntX*cntY);
    }
    
    private static Map<Character, List<Integer>> charMapping( String s )
    {
        char[] charr = s.toCharArray();
        final Map<Character, List<Integer>> map = new HashMap<>();
        for( int i=0; i < s.length(); i++ )
        {
            List<Integer> li = map.get(  charr[i] );
            
            if( li == null )
            {
                li = new ArrayList<>();
                map.put( charr[i], li );
            }
            li.add( i );
        }
        
        return map;
    }
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        String S = in.nextLine();
        
        final Map<Character, List<Integer>> charMap = charMapping( S );
       
        int Q = in.nextInt();
        
        in.nextLine();
        for( int k=0; k < Q; k++ )
        {
            String s = in.nextLine();
            String[] st = s.split( " " );
            
            char X = st[0].charAt( 0 );
            char Y = st[1].charAt( 0 );
            
            int cnt  = countSubArray( charMap, X, Y );
            System.out.println( cnt );
        }
        
        in.close();
        //System.out.println(cnt) ;
    }
}
