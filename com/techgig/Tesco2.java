package com.techgig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tesco2
{
    public String GetSubString(String input1,String input2)
    {
        if( null == input2 || null == input1 ) return null;
        
        final int[] flag = new int[256];
        
        char[] wordArr = input2.toCharArray();
        
        final Map<Character, List<Integer>> charMap = new HashMap<Character, List<Integer>>();
        
        for( int i=0; i< wordArr.length; i++ )
        {
            char ch = wordArr[i];
            List<Integer> list = charMap.get( ch );
            
            if( null == list)
            {
                list = new ArrayList<Integer>();
            }
            
            list.add( i );
            
            charMap.put( ch, list );
            
            flag[ch]++;
        }
        
        char[] stringArr = input1.toCharArray();
        final int[] pos = new int[input2.length()];
        
        int len =0;
        int maxLen = Integer.MAX_VALUE;
        String resStr = null;
        final int[] counts = new int[256];
        
        for( int i =0; i < input1.length(); i++ )
        {
            char ch = stringArr[i];
            
            if( flag[ch] > 0  )
            {
                if( len < input2.length() && counts[ch] < flag[ch])
                {
                    counts[ch]++;
                    len++;
                }
                final List<Integer> list = charMap.get( ch );
                int minPosIndex = Integer.MAX_VALUE;
                int minIndex = Integer.MAX_VALUE;
                for( final int index : list )
                {
                    if( minPosIndex > pos[index])
                    {
                        minPosIndex = pos[index];
                        minIndex = index;
                    }
                }
                pos[minIndex] = i;
                
                if( len == input2.length())
                {
                    int minI=Integer.MAX_VALUE;
                    int maxI =Integer.MIN_VALUE;
                    for( int j =0; j < pos.length; j++ )
                    {
                        minI = Math.min( pos[j], minI );
                        maxI = Math.max( pos[j], maxI );
                    }
                    
                    if( maxLen > (maxI-minI))
                    {
                        resStr = input1.substring( minI, maxI+1 );
                        maxLen = maxI-minI;
                    }
                }
            }
        }
        
        return resStr;
    }

    public static void main( String[] args )
    {
        //String input1 = "My Name is Franimarkjasldk lasdjktuwioakdsglkjanbvcddfsfunaslalz aslslspdsnkasdsflkasjdlfkdsbcdvdjvhfdaslkfjasdklfjslkfjdslkfjaskddsfrlklkjkrimkjsdlaksjdlksajdlkasjdlkasjdlkasjdlkasjdlkasjdlakjdlkjslcksjdkskfjdsffadsdflsdjflksdjflksdajflkadjsflkjdslkjdljerefhsjndjasdkhsfkjsdkjfnahksldhakshdfksjdfnkdsjbfhkjsdhfkasjdhfkdsjhfkjfhkajdsfhsdfopsaonzzxmlkqtsed";
        //String input2 = "abcdefghijklmnopqrstuvwxyzFad";
        
        String input1 = "My Name is FranimarkM";
        String input2 = "rim";
        
        //String input1 = "this is a test string";
        //String input2 = "tist";
       
        //String input1 = "coobdafceeaxab";
        //String input2 = "abc";
       
        
        final Tesco2 tesco = new Tesco2();
        
        System.out.println(  tesco.GetSubString( input1, input2 ) );
        
        //System.out.println( tes.GetVisibleCount( N, m, input3 ));
    }
}
