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
 * The Television class.  Right now it only has data.
 */

class Television
{
   // INSTANCE VARIABLES
   String brand = "RCA";     // the brand name (with initializer)
   int    volume;            // the volume (with no initializer)

   // ACCESSOR METHODS
   public String getBrand()
   {
      return brand;
   }
   
   public int getVolume()
   {
      return volume;
   }

}
