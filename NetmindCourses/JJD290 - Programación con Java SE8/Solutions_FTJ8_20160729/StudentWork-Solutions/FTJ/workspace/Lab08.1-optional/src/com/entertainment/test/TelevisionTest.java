package com.entertainment.test;
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
 * Lab - Composition
 *
 * This class is the main class, i.e., where the application starts.
 * 
 * It uses tuner related functionality of Television
 */

class TelevisionTest
{
   public static void main(String[] args)
   {
	   Television tv1 = new Television("Sony", Television.MIN_VOLUME);
	   tv1.gotoChannel("ABC");
	   tv1.gotoChannel("CNN");
   }
}
