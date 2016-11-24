/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2004-13 LearningPatterns Inc.
 */

/*
 * Lab - Inheritance
 *
 * The ColorTelevision class, a subclass of Television.
 *
 * It adds an instance variable, with accessors
 *  
 * It also provides some constructors.
 */

package com.entertainment;

public class ColorTelevision
extends Television
{
   // INSTANCE VARIABLES
   private int colorTint;
   
   
   // CONSTRUCTORS
   public ColorTelevision()
   {
      super();	
   }
   
   public ColorTelevision(int colorTintIn)
   {
      super();
      this.setColorTint(colorTintIn);
   }
   
   public ColorTelevision(String brandIn, int volumeIn)
   {
      // pass brand, volume to superclass ctor
      super(brandIn, volumeIn);
   }
   
   public ColorTelevision(String brandIn, int volumeIn, int colorTintIn)
   {
      // pass brand, volume to superclass ctor
      super(brandIn, volumeIn);

      // deal with colorTint here
      this.setColorTint(colorTintIn);
   }
   
   
   // ACCESSOR METHODS
   public void setColorTint(int colorTintIn)
   {
      colorTint = colorTintIn;
   }
   
   public int getColorTint()
   {
      return colorTint;
   }
   
}
