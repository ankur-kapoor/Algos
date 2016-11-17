package com.hackerrank;

class foodFactory 
{
    public Food getFood( String val )
    {
        if( "Fastfood".equals( val  ))
        {
            return new FastFood();
        }
        else if( "Fruits".equals( val  ))
        {
            return new Fruits();
        }
        else
        {
            return null;
        }
    }
}

abstract class Food 
{
    public abstract void serveFood();
}

class Fruits extends Food
{
    @Override
    public void serveFood()
    {
        System.out.println("I'm serving Fruits");
    }
}

class FastFood extends Food
{
    @Override
    public void serveFood()
    {
        System.out.println("I'm serving FastFood");
    }
}