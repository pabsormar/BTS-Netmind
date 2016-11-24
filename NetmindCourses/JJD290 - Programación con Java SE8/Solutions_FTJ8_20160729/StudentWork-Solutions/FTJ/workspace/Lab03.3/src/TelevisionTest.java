/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2004-13 LearningPatterns Inc.
 */
 
/*
 * Lab - Writing a Class Definition
 *
 * This class is the main class, i.e., where the application starts.
 *
 * It instantiates two Television objects, sets the instance variables,
 * and uses System.out.println to display them.
 */

class TelevisionTest
{
   public static void main(String[] args)
   {
      // instantiate two Televisions
      Television firstTV = new Television();
      Television secondTV = new Television();

      // assign values to the brand using direct access
      // This will not be legal in next lab
      firstTV.brand = "Hitachi";

      // display the values using System.out.println and string concantenation
      System.out.println("Television: brand=" + firstTV.getBrand()  + ", volume=" + firstTV.getVolume());
      System.out.println("Television: brand=" + secondTV.getBrand() + ", volume=" + secondTV.getVolume());
   }
}
