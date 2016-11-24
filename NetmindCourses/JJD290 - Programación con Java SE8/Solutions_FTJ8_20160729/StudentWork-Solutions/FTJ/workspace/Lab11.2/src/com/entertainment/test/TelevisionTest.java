/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2004-13 LearningPatterns Inc.
 */

/*
 * Lab - Using Set and List
 *
 * This class is the main class, i.e., where the application starts.
 * 
 * Creates a set and a list, and populates them with televisions (some are duplicates)
 * Examines the behavior of each collection
 */

package com.entertainment.test;

import java.util.ArrayList;
import java.util.HashSet;

import com.entertainment.*;

class TelevisionTest
{
	public static void main(String[] args)
	{
		// Create some television instances
		try {
			Television tv1 = new Television("Sony", 10);
			Television tv2 = new Television("RCA", 5);

			// Add the instances into a list
			ArrayList<Television> list1 = new ArrayList<Television>();
			list1.add(tv1);
			list1.add(tv1);
			list1.add(tv2);
			list1.add(tv2);
			System.out.println("list1 size = " + list1.size());

			// Add the instances into a set
			HashSet<Television> set1 = new HashSet<Television>();
			set1.add(tv1);
			set1.add(tv1);
			set1.add(tv2);
			set1.add(tv2);
			System.out.println("set1 size = " + set1.size());

			// Create a set from a list containing duplicates
			HashSet<Television> set2 = new HashSet<Television>(list1);
			System.out.println("list1 size = " + list1.size());
			System.out.println("set2 size = " + set2.size());

		} catch (Exception e) {
			e.printStackTrace();
		}   
	}
}