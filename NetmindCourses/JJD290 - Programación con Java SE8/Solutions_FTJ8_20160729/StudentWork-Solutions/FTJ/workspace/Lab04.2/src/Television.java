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
 * The Television class - now it enforces encapsulation
 * and provides constructors for ease of instantiation.
 */

class Television
{
   // INSTANCE VARIABLES
   private String brand;     // the brand name
   private int volume;       // the volume
   
   
   // CONSTRUCTORS
   Television()
   {
      // call "detailed" constructor with default values
      this("RCA", 10);
   }
   
   Television(String brandIn)
   {
      // call "detailed" constructor with supplied brand and default volume
      this(brandIn, 10);
   }
   
   Television(int volumeIn)
   {
      // call "detailed" constructor with default brand and supplied volume
      this("RCA", volumeIn);
   }
   
   Television(String brandIn, int volumeIn)
   {
      // call setter methods to actually set the data
      this.setBrand(brandIn);
      this.setVolume(volumeIn);
   }
   
   
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
