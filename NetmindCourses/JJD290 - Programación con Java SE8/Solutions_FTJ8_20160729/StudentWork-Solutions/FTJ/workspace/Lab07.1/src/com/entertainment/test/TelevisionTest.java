package com.entertainment.test;
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
 * Lab - Packages
 *
 * This class is the main class, i.e., where the application starts.
 * 
 * It tests to make sure that it can still create and operate on
 * com.entertainment.Television objects.
 */

class TelevisionTest
{
   public static void main(String[] args)
   {
      if (args.length == 0)
      {
         System.out.println("Usage: java TelevisionTest <brand1> <brand2> ...");
         System.exit(-1);  //  exit
      }
      
      // create an array to hold args.length Television objects
      Television[] tvArray = new Television[args.length];
      
      // for each command line argument, create a Television object
      // and add it to the array
      int i = 0;
      for (String curArg : args)
      {
         // each Television has a brand from the command line and a volume of 10
         tvArray[i++] = new Television(curArg, 10);
      }
      
      // iterate over the array and print each Television object's data
      for (Television curTV : tvArray)
      {
         System.out.println(curTV);
      }
   }
}
