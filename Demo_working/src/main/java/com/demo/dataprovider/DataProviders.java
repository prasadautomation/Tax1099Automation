package com.demo.dataprovider;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.demo.utility.Log;
import com.demo.utility.NewExcelLibrary;

public class DataProviders {

	NewExcelLibrary obj = new NewExcelLibrary();

	//Class --> LoginPageTest,HomePageTest Test Case--> loginTest, wishListTest, orderHistoryandDetailsTest

		@DataProvider(name = "credentials")
		public Object[][] getCredentials() {
			// Totals rows count
			int rows = obj.getRowCount("Credential");
			// Total Columns
			int column = obj.getColumnCount("Credential");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("Credential", j, i + 2);
				}
			}
			return data;
		}
		
		
	//	@DataProvider(name="RandomEIN")
	//	public void 
		
		@DataProvider(name = "newlogin")
		public Object[][] newlogin() {
			// Totals rows count
			int rows = obj.getRowCount("LoginNoData");
			// Total Columns
			int column = obj.getColumnCount("LoginNoData");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("LoginNoData", j, i + 2);
				}
			}
			return data;
		}

	/*
	 * @DataProvider(name = "addPayerein") 
	 * public Object[][] getAddPayerein() { //
	 * Totals rows count HashMap<String, String> hashMap = new HashMap<String,
	 * String>();
	 * 
	 * int rows = obj.getRowCount("AddPayerein"); // Total Columns int column =
	 * obj.getColumnCount("AddPayerein"); int actRows = rows - 1;
	 * 
	 * 
	 * for (int i = 0; i < actRows; i++) { for (int j = 0; j < column; j++) {
	 * hashMap.put(obj.getCellData("AddPayerein", j, 1),
	 * obj.getCellData("AddPayerein", j, i + 2)); } }
	 * Log.info("========================>"+hashMap.toString()); return new
	 * Object[][] { {hashMap} }; 
	 * // return data; }
	 */
		@DataProvider(name = "addPayerein")
		public Object[][] getAddPayerein() {

			// Totals rows count
			int rows = obj.getRowCount("AddPayerein");
			// Total Columns
			int column = obj.getColumnCount("AddPayerein");
			int actRows = rows - 1;
			//Created an object of array to store data
			Object[][] data = new Object[actRows][1];
			
			for (int i = 0; i < actRows; i++) {
				Map<String, String> hashMap = new HashMap<>();
				for (int j = 0; j < column; j++) {
					System.out.println(obj.getCellData("AddPayerein", j, i + 2));
					
					hashMap.put(obj.getCellData("AddPayerein", j, 1),
							obj.getCellData("AddPayerein", j, i + 2));
				}
				data[i][0]=hashMap;
			}
			return data;
		}
		@DataProvider(name = "addrecipientrandombusinessein")
		public Object[][] getAddRecipientbusinessein() {

			// Totals rows count
			int rows = obj.getRowCount("AddRecipientEin");
			// Total Columns
			int column = obj.getColumnCount("AddRecipientEin");
			int actRows = rows - 1;
			//Created an object of array to store data
			Object[][] data = new Object[actRows][1];
			
			for (int i = 0; i < actRows; i++) {
				Map<String, String> hashMap = new HashMap<>();
				for (int j = 0; j < column; j++) {
					System.out.println(obj.getCellData("AddRecipientEin", j, i + 2));
					hashMap.put(obj.getCellData("AddRecipientEin", j, 1),
							obj.getCellData("AddRecipientEin", j, i + 2));
				}
				data[i][0]=hashMap;
			}
			return data;
		}
		
		@DataProvider(name = "addpayerrandombusinessein")
		public Object[][] getAddPayerbusinessein() {

			// Totals rows count
			int rows = obj.getRowCount("Addpayerrandombusinessein");
			// Total Columns
			int column = obj.getColumnCount("Addpayerrandombusinessein");
			int actRows = rows - 1;
			//Created an object of array to store data
			Object[][] data = new Object[actRows][1];
			
			for (int i = 0; i < actRows; i++) {
				Map<String, String> hashMap = new HashMap<>();
				for (int j = 0; j < column; j++) {
					System.out.println(obj.getCellData("Addpayerrandombusinessein", j, i + 2));
					hashMap.put(obj.getCellData("Addpayerrandombusinessein", j, 1),
							obj.getCellData("Addpayerrandombusinessein", j, i + 2));
				}
				data[i][0]=hashMap;
			}
			return data;
		}
		
	

		@DataProvider(name = "addpayernonusein")
		public Object[][] getAddPayerNonUsEin() {

			// Totals rows count
			int rows = obj.getRowCount("AddPayerNonUsEin");
			// Total Columns
			int column = obj.getColumnCount("AddPayerNonUsEin");
			int actRows = rows - 1;
			//Created an object of array to store data
			Object[][] data = new Object[actRows][1];
			
			for (int i = 0; i < actRows; i++) {
				Map<String, String> hashMap = new HashMap<>();
				for (int j = 0; j < column; j++) {
					System.out.println(obj.getCellData("AddPayerNonUsEin", j, i + 2));
					hashMap.put(obj.getCellData("AddPayerNonUsEin", j, 1),
							obj.getCellData("AddPayerNonUsEin", j, i + 2));
				}
				data[i][0]=hashMap;
			}
			return data;
		}
	

		@DataProvider(name = "addPayerssn")
		public Object[][] getAddPayerssn() {
			// Totals rows count
			HashMap<String, String> hashMap = new HashMap<String, String>();

			int rows = obj.getRowCount("AddPayerssn");
			// Total Columns
			int column = obj.getColumnCount("AddPayerssn");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					hashMap.put(obj.getCellData("AddPayerssn", j, 1),
							obj.getCellData("AddPayerssn", j, i + 2));				}
			}
			return data;
		}
		@DataProvider(name = "misc2019formTestdata")
		public Object[][] getmisc2019formTestdata() {
			// Totals rows count
			HashMap<String, String> hashMap = new HashMap<String, String>();

			int rows = obj.getRowCount("MISC2019formTestdata");
			// Total Columns
			int column = obj.getColumnCount("MISC2019formTestdata");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					hashMap.put(obj.getCellData("MISC2019formTestdata", j, 1),
							obj.getCellData("MISC2019formTestdata", j, i + 2));
				}
			}
			return data;
}
}