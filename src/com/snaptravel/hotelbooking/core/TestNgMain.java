/**
 *
 */
/**
 * @author mgarg
 *
 */
package com.snaptravel.hotelbooking.core;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class TestNgMain {

	public static void main(String[] args){

		List<String> file  = new ArrayList<String>();
		//file.add("./testng_smoke.xml");
		file.add("./testng.xml");
		TestNG testng = new TestNG();
		testng.setTestSuites(file);
		testng.run();
	}

}
