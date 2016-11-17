package com.topcoder;

public class ColorfulGardenHard
{
    public int count(String garden, String forbid)
    {
        char[] charg = garden.toCharArray();
        
        int[] chars = new int[256];
        for( int i =0; i < charg.length; i++ )
        {
            chars[charg[i]]++;
        }
        
        return 0;
    }
}
