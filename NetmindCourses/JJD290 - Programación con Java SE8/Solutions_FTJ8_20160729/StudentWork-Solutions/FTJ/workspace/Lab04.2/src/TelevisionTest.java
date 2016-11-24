/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2004-13 LearningPatterns Inc.
 */

/*
 * Lab - Adding Constructors to a Class
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
      
      // instantiate a Television with specified values
      Television secondTV = new Television("Zenith", 17);

      // display the values using the convenient toString() method
      System.out.println(firstTV);
      System.out.println(secondTV);
   }
}
