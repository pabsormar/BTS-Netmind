/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2004-13 LearningPatterns Inc.
 */

/*
 * Lab - Using Static Members
 *
 * This class is the main class, i.e., where the application starts.
 *
 * It instantiates two Television objects by using constructors.
 * Then it uses the toString method to display their data.
 */

class TelevisionTest
{
   public static void main(String[] args)
   {
      // instantiate a default Television
      Television firstTV = new Television();
      // Try to set the volume greater than max
      firstTV.setVolume(110);
      
      // instantiate a Television with specified values
      // Try to set the volume less than min
      Television secondTV = new Television("Zenith", -3);

      // display the values using the convenient toString() method
      System.out.println(firstTV);
      System.out.println(secondTV);

      // Set to a valid volume
      firstTV.setVolume(50);
      System.out.println(firstTV);
   }
}
