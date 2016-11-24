/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2004-13 LearningPatterns Inc.
 */
 
/*
 * Lab - Encapsulation
 *
 * This class is the main class, i.e., where the application starts.
 *
 * It instantiates two Television objects, calls the setter methods
 * to set the instance variables, and uses the toString method to display them.
 */

class TelevisionTest
{
   public static void main(String[] args)
   {
      // instantiate two Televisions
      Television firstTV = new Television();
      Television secondTV = new Television();

      // assign values to the brands and volumes via setter methods
      firstTV.setBrand("Hitachi");
      firstTV.setVolume(10);

      secondTV.setBrand("Sony");
      secondTV.setVolume(40);

      // display the values using the convenient toString() method
      System.out.println(firstTV);              // implicit toString call
      System.out.println(secondTV.toString());  // explicit toString call
   }
}
