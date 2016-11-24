package com.entertainment.test;

import com.entertainment.ColorTelevision;
import com.entertainment.PortableTelevision;
import com.entertainment.Television;

/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2004-13 LearningPatterns Inc.
 */

/*
 * Lab 8.2 - Inheritance
 *
 * This class is the main class, i.e., where the application starts.
 * 
 * It demonstrates inheritance by creating a ColorTelevision
 * and a PortableTelevision and calling methods of each, as 
 * well as methods of Television
 */

class TelevisionTest
{
   public static void main(String[] args)
   {
	   ColorTelevision ctv = new ColorTelevision("Hitachi", Television.MIN_VOLUME, 9);
	   PortableTelevision ptv = new PortableTelevision("Sony", Television.DEFAULT_VOLUME, 19);
	   
	   System.out.println("For a color television, volume : colorTint = " + ctv.getVolume() + " : " + ctv.getColorTint());
	   System.out.println("For a portable television, volume : rechargeLevel = " + ptv.getVolume() + " : " + ptv.getRechargeLevel());
   }
}
