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
 * The Television class - now it enforces encapsulation
 * and provides constructors for ease of instantiation.
 *
 * It also validates brand and volume data and supports muting.
 *
 * It uses class constants for minimum and maximum volume, and default values
 */

class Television
{
   // CLASS VARIABLES
   public static final int MIN_VOLUME=0;
   public static final int MAX_VOLUME=100;

   public static final String DEFAULT_BRAND = "RCA";
   public static final int DEFAULT_VOLUME = 10;

   // INSTANCE VARIABLES
   private String brand;     // the brand name
   private int volume;       // the volume
   
   // for muting behavior
   private int oldVolume;
   private boolean isMuted;
   
   
   // CONSTRUCTORS
   Television()
   {
      // call "detailed" constructor with default values
      this(DEFAULT_BRAND, DEFAULT_VOLUME);
   }
   
   Television(String brandIn)
   {
      // call "detailed" constructor with supplied brand and default volume
      this(brandIn, DEFAULT_VOLUME);
   }
   
   Television(int volumeIn)
   {
      // call "detailed" constructor with default brand and supplied volume
      this(DEFAULT_BRAND, volumeIn);
   }
   
   Television(String brandIn, int volumeIn)
   {
      // call setter methods to actually set the data
      this.setBrand(brandIn);
      this.setVolume(volumeIn);

      if (getBrand() == null) {
	  setBrand(DEFAULT_BRAND);
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
   {
      if (brandIn.equals("Sony") ||
          brandIn.equals("Zenith") ||
          brandIn.equals("Hitachi") ||
          brandIn.equals("RCA"))
      {
         brand = brandIn;
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
   public String toString()
   {
      // display <muted> instead of 0 if the tv is currently muted
      String volumeDisplayMessage;
      
      if (!this.isMuted())  // not currently muted
      {
         volumeDisplayMessage = String.valueOf(this.getVolume());
      }
      else
      {
         volumeDisplayMessage = "<muted>";
      }
      
      return "Television: brand=" + this.getBrand() + ", volume=" + volumeDisplayMessage;
   }
}
