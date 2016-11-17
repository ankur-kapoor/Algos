package com.hackerrank;
abstract class Arithmetic {
    abstract int add(int a,int b);  
}

class Adder extends Arithmetic
{

    @Override
    int add( int a, int b )
    {
        return a+b;
    }
    
}