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
 * The PortableTelevision class, a subclass of Television.
 *
 * It adds an instance variable, with accessors, and overrides the
 * toString method, adding recharge level info.
 * 
 * It also provides some constructors.
 */

package com.entertainment;

public class PortableTelevision
extends Television
{
   // INSTANCE VARIABLES
   private int rechargeLevel;
   
   
   // CONSTRUCTORS
   public PortableTelevision()
   {
      super();	
   }
   
   public PortableTelevision(int rechargeLevelIn)
   {
      super();
      this.setRechargeLevel(rechargeLevelIn);
   }
   
   public PortableTelevision(String brandIn, int volumeIn)
   {
      // pass brand, volume to superclass ctor
      super(brandIn, volumeIn);
   }
   
   public PortableTelevision(String brandIn, int volumeIn, int rechargeLevelIn)
   {
      // pass brand, volume to superclass ctor
      super(brandIn, volumeIn);
   
      // deal with rechargeLevel here
      this.setRechargeLevel(rechargeLevelIn);
   }
   
   
   // ACCESSOR METHODS
   public void setRechargeLevel(int rechargeLevelIn)
   {
      rechargeLevel = rechargeLevelIn;	
   }
   
   public int getRechargeLevel()
   {
      return rechargeLevel;
   }
   
   // returns a string representation of this class instance
   @Override
   public String toString()
   {
	   return String.format("%s\n PortableTelevision: rechargeLevel= %d", super.toString(), getRechargeLevel());
   }   
}
