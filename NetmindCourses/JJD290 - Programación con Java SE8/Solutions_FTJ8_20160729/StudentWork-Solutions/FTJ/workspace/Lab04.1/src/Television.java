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
 * The Television class - now it enforces encapsulation.
 */

class Television
{
   // INSTANCE VARIABLES
   private String brand;     // the brand name
   private int volume;       // the volume
   
   
   // ACCESSOR METHODS
   public void setBrand(String brandIn)
   {
      brand = brandIn;
   }
   
   public String getBrand()
   {
      return brand;
   }
   
   public void setVolume(int volumeIn)
   {
      volume = volumeIn;
   }
   
   public int getVolume()
   {
      return volume;
   }
   
   // returns a string representation of this class instance
   public String toString()
   {
      return "Television: brand=" + this.getBrand() + ", volume=" + this.getVolume();
   }
}
