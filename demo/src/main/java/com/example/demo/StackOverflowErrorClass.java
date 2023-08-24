package com.example.demo;

public class StackOverflowErrorClass {
	 static int i = 0;
	  
    // Method to print numbers
    public static int printNumber(int x)
    {
  
        i = i + 2;
        System.out.println(i);
        return i + printNumber(i + 2);
    }
  
    public static void main(String[] args)
    {
        // Recursive call without any
        // terminating condition
        StackOverflowErrorClass.printNumber(i);
    }
}
