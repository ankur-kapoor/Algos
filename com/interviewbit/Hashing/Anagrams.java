package com.interviewbit.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *For Given Number N find if its COLORFUL number or not

Return 0/1

COLORFUL number:

A number can be broken into different sub-sequence parts. 
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245. 
And this number is a COLORFUL number, since product of every digit of a sub-sequence are different
Example:

N = 23
2 3 23
2 -> 2
3 -> 3
23 -> 6
this number is a COLORFUL number since product of every digit of a sub-sequence are different. 

Output : 1
 */

public class Anagrams
{
    public ArrayList<ArrayList<Integer>> groupAnagrams( List<String> strs) 
    {
        final Map<Integer, ArrayList<Integer>> valMap = new HashMap<>();
        
        int i = 1;
        for( String s : strs )
        {
            int hash = 0;
            for( int j =0; j < s.length(); j++ )
            {
                hash = (hash + String.valueOf( s.charAt( j ) ).hashCode())% Integer.MAX_VALUE;
            }
            
            final ArrayList<Integer> list;
            if( valMap.containsKey( hash ))
            {
                list = valMap.get( hash );
            }
            else
            {
                list = new ArrayList<>();
                valMap.put( hash, list );
            }
            
            list.add( i++ );
        }
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>( valMap.values());
        
        return res;
    }
    
    
    public static void main( String[] args )
    {
        Anagrams t = new Anagrams();
        
        String[] strArr = {"cat","dog","god","tca"};
        ArrayList<String> ai = new ArrayList<>( Arrays.asList( strArr ));
        
        System.out.println( " Anagrams = "+ t.groupAnagrams( ai ) );
    }
}
