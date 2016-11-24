package com.entertainment;
/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2004-13 LearningPatterns Inc.
 */

/*
 * Lab - Using Exceptions
 *
 * The Television class - now it enforces encapsulation
 * and provides constructors for ease of instantiation.
 *
 * It also validates brand and volume data and supports muting.
 *
 * It uses class constants for minimum and maximum volume, and default values
 *
 * It is now using a VolumeControl object to control all volume-related functionality.
 * and implements the com.entertainment.Volume interface.
 *
 * It throws an exception whenever an invalid brand or volume is passed in.
 */

public class Television implements Volume
{
   // CLASS VARIABLES
   public static final int MIN_VOLUME=0;
   public static final int MAX_VOLUME=100;

   public static final String DEFAULT_BRAND = "RCA";
   public static final int DEFAULT_VOLUME = 10;

   public static final String[] VALID_BRANDS =
      {"Sony", "Zenith", "Hitachi", "RCA"};

   // INSTANCE VARIABLES
   private String brand;     // the brand name
   private int volume;       // the volume
   
   // for muting behavior
   private int oldVolume;
   private boolean isMuted;
   
   // CONSTRUCTORS
   public Television()
   {
      // call "detailed" constructor with default values
      this(DEFAULT_BRAND, DEFAULT_VOLUME);
   }
   
   public Television(String brandIn)
   {
      // call "detailed" constructor with supplied brand and default volume
      this(brandIn, DEFAULT_VOLUME);
   }
   
   public Television(int volumeIn)
   {
      // call "detailed" constructor with default brand and supplied volume
      this(DEFAULT_BRAND, volumeIn);
   }
   

   public Television(String brandIn, int volumeIn)
   {
      // call setter methods to actually set the data
	  this.setVolume(volumeIn);
      try {
		this.setBrand(brandIn);
      } catch (Exception e) {
    	  System.out.println("Invalid brand in ctor - using default");
    	  brand = DEFAULT_BRAND;
      }
   }
   
   
   // BEHAVIORAL METHODS
   public void mute()
   {
      if (!this.isMuted())   // not currently muted
      {
         // store current volume in m_oldVolume
         oldVolume = this.getVolume();
         
         // set volume to zero
         this.setVolume(0);
      }
      else              // currently muted
      {
         // restore volume from m_oldVolume value
         this.setVolume(oldVolume);
      }
      
      // toggle muted flag
      isMuted = !isMuted;
   }
   
   // ACCESSOR METHODS
   public void setBrand(String brandIn)
   throws Exception
   {
      if (Television.isValidBrand(brandIn))
      {
         brand = brandIn;
      }
      else
      {
         throw new Exception(
            "'" + brandIn + "' is invalid - must be Sony, Zenith, Hitachi, or RCA");
      }

   }
   
   public String getBrand()
   {
      return brand;
   }
   
   public void setVolume(int volumeIn)
    {
	int new_volume = Math.min(volumeIn,Television.MAX_VOLUME);
	volume = Math.max(new_volume,Television.MIN_VOLUME);
   }
   
   public int getVolume()
   {
      return volume;
   }

   public boolean isMuted()
   {
      return isMuted;
   }

   // returns a string representation of this class instance
   @Override
   public String toString()
   {
   	   // We format the volume as a string, and include a special value for muted.
   	   // See ColorTelevision for simple formatting of integers.
	   return String.format("Television: brand= %s,  volume= %s", getBrand(), isMuted ? "<muted>" : getVolume());
   }

   // PRIVATE METHODS
   private static boolean isValidBrand(String brandIn)
   {
      // declare return value
      boolean isValid = false;
      
      // iterate over VALID_BRANDS, looking for a match
      for (String curBrand : VALID_BRANDS)
      {
	  if (brandIn.equals(curBrand))
         {
            isValid = true;  // got a match
            break;           // terminate search
         }
      }
      
      return isValid;
   }

}
