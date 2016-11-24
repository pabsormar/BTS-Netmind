/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2004-13 LearningPatterns Inc.
 */

/*
 * Lab - Formatted output
 *
 * This class is the main class, i.e., where the application starts.
 * 
 * Creates a number of televisions, then just outputs them.  
 * Goal is to test Television.toString()
 */

package com.entertainment.test;

import com.entertainment.*;

class TelevisionTest
{
	public static void main(String[] args)
	{
		// Create some television instances
		Television tv1 = new Television("Sony", 10);
		Television tv2 = new ColorTelevision("RCA", 20, 500);
		Television tv3 = new PortableTelevision("Hitachi", 25, 75);
		
		tv1.mute();
		
		System.out.println(tv1);
		System.out.println(tv2);
		System.out.println(tv3);
	}
}