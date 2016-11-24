package com.entertainment.test;

import com.entertainment.ColorTelevision;
import com.entertainment.PortableTelevision;
import com.entertainment.Television;

/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2004-13 LearningPatterns Inc.
 */

/*
 * Lab - Polymorphism
 *
 * This class is the main class, i.e., where the application starts.
 * 
 * It demonstrates polymorphism by creating a Television array,
 * adding a Television, a ColorTelevision, and a PortableTelevision to it,
 * and calling toString on each one.
 */

class TelevisionTest
{
   public static void main(String[] args)
   {
	      // create the 3 television objects
	      Television tv = new Television("Zenith", 17);
	      ColorTelevision ctv = new ColorTelevision("Hitachi", Television.MIN_VOLUME, 9);
	      PortableTelevision ptv = new PortableTelevision("Sony", Television.DEFAULT_VOLUME, 19);
	      
	      // create the Television array to hold them
	      Television[] tvArray = {tv, ctv, ptv};  // shortcut notation to initialize an array
	      
	      // iterate over the array, printing the data in each element
	      for (Television curTV : tvArray)
	      {
	         System.out.println(curTV);  // toString automatically called
	      }
   }
}
