package com.operation.service;

import org.springframework.stereotype.Component;




@Component
public class APIOperationService {
	
	public String getTriangleType(int side1,int side2,int side3)
	{
		   String triangleType="";
		    if(side1==side2 && side2==side3)
		    {
		    	triangleType= "equilateral";
		    	
		    }
		    else if(side1==side2|| side2==side3|| side1==side3)
		    	triangleType= "isosceles";
		    else
		    {
		    	triangleType="scalene";	
		    }
		    return triangleType;

	}
	
	public static long fib(long n) {
		if (n == 1)
			return 0;
		if (n == 2)
			return 1;

		return fib(n - 1) + fib(n - 2);
	}
	public String reverseWordInMyString(String str)
	   {
		/* The split() method of String class splits
		 * a string in several strings based on the
		 * delimiter passed as an argument to it
		 */
		String[] words = str.split(" ");
		String reversedString = "";
		for (int i = 0; i < words.length; i++)
	        {
	           String word = words[i]; 
	           String reverseWord = "";
	           for (int j = word.length()-1; j >= 0; j--) 
		   {
			/* The charAt() function returns the character
			 * at the given position in a string
			 */
			reverseWord = reverseWord + word.charAt(j);
		   }
		   reversedString = reversedString + reverseWord + " ";
		}

		return reversedString.trim();
	   }
}
