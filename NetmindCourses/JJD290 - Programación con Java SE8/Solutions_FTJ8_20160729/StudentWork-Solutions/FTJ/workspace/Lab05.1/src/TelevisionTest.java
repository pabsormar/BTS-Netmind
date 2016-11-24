/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2004-13 LearningPatterns Inc.
 */

/*
 * Lab - Data Validation
 *
 * This class is the main class, i.e., where the application starts.
 *
 * It instantiates a Television object and tests its data validation.
 * It also tests its muting behavior.
 */

class TelevisionTest
{
   public static void main(String[] args)
   {
      // instantiate a Television with valid data
      Television tv = new Television("Hitachi", 17);
      System.out.println("Brand/Volume should be Hitachi/17");
      System.out.println(tv);
      
      // test its data validation
      tv.setVolume(-3);
      System.out.println("Brand/Volume should be Hitachi/0 (new vol < min)");
      System.out.println(tv);
      
      tv.setBrand("whatever");
      System.out.println("Brand/Volume should be Hitachi/0 (set invalid brand)");
      System.out.println(tv);
      
      // instantiate a Television with invalid data
      Television ctv = new Television("whatever", -3);
      System.out.println("Brand/Volume should be RCA/0 (invalid brand, vol<min in constructor)");
      System.out.println(ctv);
      
      // test tv's muting behavior
      tv.setVolume(50); // Set to valid volume
      System.out.println("Brand/Volume should be Hitachi/50 (reset volume)");
      System.out.println(tv);
      tv.mute();
      System.out.println("Brand/Volume should be Hitachi/<muted>");
      System.out.println(tv);  // volume should be zero
      
      tv.mute();
      System.out.println("Brand/Volume should be Hitachi/50 - unmuted");
      System.out.println(tv);  // volume should be restored to 50
   }
}
