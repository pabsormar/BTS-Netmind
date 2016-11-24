/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2004-13 LearningPatterns Inc.
 */

/*
 * Lab 10.1 - Using Exceptions
 *
 * This class is the main class, i.e., where the application starts.
 * 
 * It tries to apply invalid data to Television objects and
 * shows how the exceptions are handled.
 */

package com.entertainment.test;

import com.entertainment.*;

class TelevisionTest
{
   public static void main(String[] args)
   {
		Television tv = new Television("whatever", 10);  // Exception will be caught in constructor
		System.out.println(tv);
       ColorTelevision ctv = new ColorTelevision("Sonny", 139, 3);       // Exception caught in Television constructor
       System.out.println(ctv);
       PortableTelevision ptv = new PortableTelevision("Zenit", -9, 5);  // Exception caught in Television constructor
       System.out.println(ptv);
		
		try {
			System.out.println("Setting Brand");
			tv.setBrand("whatever");  // Should throw exception
		} catch (Exception e) {
			e.printStackTrace();
		}   
   }
}