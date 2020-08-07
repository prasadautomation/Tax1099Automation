package com.demo.dataprovider;

import org.testng.annotations.DataProvider;

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

		@DataProvider(name = "addPayer")
		public Object[][] getAddPayer() {
			// Totals rows count
			int rows = obj.getRowCount("AddPayer");
			// Total Columns
			int column = obj.getColumnCount("AddPayer");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("AddPayer", j, i + 2);
				}
			}
			return data;
		}
		
}
