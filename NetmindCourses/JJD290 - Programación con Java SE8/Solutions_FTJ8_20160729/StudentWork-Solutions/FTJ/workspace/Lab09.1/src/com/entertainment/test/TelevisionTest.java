/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2004-13 LearningPatterns Inc.
 */

/*
 * Lab - Interfaces
 *
 * This class is the main class, i.e., where the application starts.
 * 
 * It demonstrates polymorphism and interface types by creating a
 * Volume (interface type) array, adding a Television, a ColorTelevision,
 * a PortableTelevision, and a Radio to it, and calling toString on each one.
 *
 * Even though Radio and Television (and its subclasses) are not
 * inheritance-related, they both fulfill the Volume "role."
 */

package com.entertainment.test;

import com.entertainment.*;

class TelevisionTest
{
   public static void main(String[] args)
   {
      // create the 3 television objects
      Television tv = new Television("Zenith", 17);
      ColorTelevision ctv = new ColorTelevision("Hitachi", Television.MIN_VOLUME, 9);
      PortableTelevision ptv = new PortableTelevision("Sony", Television.DEFAULT_VOLUME, 19);
      
      // create a Radio
      Radio r = new Radio(5);
      
      // create the Volume array to hold them
      Volume[] volArray = {tv, ctv, ptv, r};  // shortcut notation to initialize an array
      
      // iterate over the array, just accessing it through the implemented interface Volume
      for (Volume curVol : volArray)
      {
    	  // double the volume of each element - just as a demonstration
         curVol.setVolume(curVol.getVolume() * 2);
         System.out.println(curVol.getVolume());  // print out the volume
      }
   }
}