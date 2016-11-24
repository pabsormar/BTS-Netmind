/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2004-13 LearningPatterns Inc.
 */

/*
 * Lab - Polymorphism
 *
 * The ColorTelevision class, a subclass of Television.
 *
 * It adds an instance variable, with accessors, and overrides the
 * toString method, adding color tint info.
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

   // returns a string representation of this class instance
   @Override
   public String toString()
   {
	   return String.format("%s\n ColorTelevision: colorTint= %d", super.toString(), getColorTint());
   }
   
}
