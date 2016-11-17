package com.interviewbit.Greedy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Stack;

/**
 * There is a row of seats. Assume that it contains N seats adjacent to each other. There is a group of people who are already seated in that row randomly. i.e. some are sitting together & some are scattered.

An occupied seat is marked with a character 'x' and an unoccupied seat is marked with a dot ('.')

Now your target is to make the whole group sit together i.e. next to each other, without having any vacant seat between them in such a way that the total number of hops or jumps to move them should be minimum.

Example

Here is the row having 15 seats represented by the String (0, 1, 2, 3, ......... , 14) -

          . . . . x . . x x . . . x . .
Now to make them sit together one of approaches is - . . . . . . x x x x . . . . .

Following are the steps to achieve this - 1 - Move the person sitting at 4th index to 6th index -
Number of jumps by him = (6 - 4) = 2

2 - Bring the person sitting at 12th index to 9th index - Number of jumps by him = (12 - 9) = 3

So now the total number of jumps made = ( 2 + 3 ) % MOD = 5 which is the minimum possible jumps to make them seat together.

There are also other ways to make them sit together but the number of jumps will exceed 5 and that will not be minimum.

For example bring them all towards the starting of the row i.e. start placing them from index 0. In that case the total number of jumps will be ( 4 + 6 + 6 + 9 )%MOD = 25 which is very costly and not an optimized way to do this movement
 *
 */
/*
 *  Using Greedy
 */
public class Seats3
{
    public int seats( String seats )
    {
        int n = seats.length();
        int minHops = 0;
        char[] seatArr = seats.toCharArray();
        
        final Deque<CharPoint> dq = new ArrayDeque<>();
        
        int j = 0; 
        int i = 0;
        while( j < n )
        {
            while( j < n && seatArr[j]== '.')
            {
                j++;
            }
            
            if( j == n )break;
            
            for( i = j; j < n && seatArr[j]=='x'; j++ ){}
            
            dq.addLast( new CharPoint( i, j-1 ) );    
        }
        
        
        while( dq.size() > 1 )
        {
            CharPoint left = dq.peekFirst();
            CharPoint right = dq.peekLast();
            
            int leftCnt = left.y - left.x + 1;
            int rightCnt = right.y - right.x + 1;
            
            // Merge the shorter group
            if( leftCnt <= rightCnt )
            {
                left = dq.pollFirst();
                minHops = (minHops + (leftCnt * ( dq.peekFirst().x - left.y - 1))%10000003)%10000003;
                dq.peekFirst().x -= leftCnt;
            }
            else
            {
                right = dq.pollLast();
                minHops = (minHops + (rightCnt * ( right.x - dq.peekLast().y  - 1))%10000003)%10000003;
                dq.peekLast().y += rightCnt; 
            }
        }
            
        return minHops;
    }
    
    public static void main( String[] args )
    {
        int[] ratings = {5,5,2};
        
        final Seats3 c = new Seats3();
        
        
        System.out.println( " Min Hops = " + c.seats( "....x..xx...x.." ) );
    }
}

class CharPoint
{
    int x;
    int y;
    
    CharPoint( int X, int Y )
    {
        x = X;
        y = Y;
    }
}