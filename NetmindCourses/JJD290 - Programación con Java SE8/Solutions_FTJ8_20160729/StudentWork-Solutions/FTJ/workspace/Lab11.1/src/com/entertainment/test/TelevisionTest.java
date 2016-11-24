/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2004-13 LearningPatterns Inc.
 */

/*
 * Lab - Using Collections
 *
 * This class is the main class, i.e., where the application starts.
 * 
 * Searches Catalog class for televisions with a specified brand.
 * Uses Collections API to iterate over the results and print.
 */

package com.entertainment.test;

import java.util.Collection;

import com.entertainment.*;

class TelevisionTest
{
   public static void main(String[] args)
   {
	      String searchBrand = "RCA";
	      // examine command line arguments
	      if (args.length < 1) {
	         System.out.println("No brand passed in as argument - using RCA");
	      } else {
	        searchBrand = args[0];
	      }
	      
	      // do the search
	      Collection<Television> result = Catalog.searchByBrand(searchBrand);
	      
	      // iterate over the collection
	      for (Television tv : result)
	      {
	         // get next element and print it (calls toString)
	         // Through polymorphism, the correct Televison class' (Television, 
	    	 // ColorTelevision, PortableTelevision) toString 
	    	 // will be the one that gets called
	         System.out.println(tv);
	      }
	      
	      
	      /* OPTIONAL 1 - A Summary Report - complete solution
	      
	      // do the search
	      Collection<Television> result_opt1 = Catalog.searchByBrand(searchBrand);
	      
	      // storage for tv counts
	      int tvCount  = 0;
	      int ctvCount = 0;
	      int ptvCount = 0;
	      
	      // iterate over the collection
	      for (Television tv : result_opt1)
	      {
	         // get next element
	         
	         // determine its type
	         if (tv instanceof ColorTelevision)
	         {
	            ctvCount++;
	         }
	         else if (tv instanceof PortableTelevision)
	         {
	            ptvCount++;
	         }
	         else if (tv instanceof Television)
	         {
	            tvCount++;
	         }
	      }
	      
	      // report results
	      System.out.println("For " + searchBrand);
	      System.out.println("There are " + tvCount  + " Televisions");
	      System.out.println("There are " + ctvCount + " ColorTelevisions");
	      System.out.println("There are " + ptvCount + " PortableTelevisions");
	      */
	      
	            
	      /* OPTIONAL 2 - Find the Loudest - complete solution
	      // get the entire catalog
	      Collection<Television> result_opt2 = Catalog.getInventory();
	      
	      // storage for maxVolume and its corresponding Television
	      int maxVolume = 0;
	      Television loudest = null;
	      
	      // iterate over the collection
	      for (Television tv : result_opt2)
	      {
	         // compare current tv volume to the current loudest one
	         int volume = tv.getVolume();
	         if (volume > maxVolume)
	         {
	            maxVolume = volume;
	            loudest = tv;
	         }
	      }
	      
	      // report results
	      System.out.println("The loudest television is " + loudest);
	      */
   
   }
}