package com.demo.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.demo.Base.base;
import com.demo.utility.Log;

public class testsample extends base {
	@Test
	/*public void random() {
	Random randomGenerator = new Random();
	int randomInt = randomGenerator.nextInt(100000000);
	System.out.print(randomInt);

}*/
	public static void random() throws Exception {
		launchApp();
		screenshotsample screenshot=new screenshotsample();
		screenshot.takeSnapShot();
		
	  }




}
