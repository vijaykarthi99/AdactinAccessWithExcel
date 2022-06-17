package com.ada;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataUtils {

	@DataProvider(name="login")
	//execute particular set of data indices= {1}
		public Object[][] getData() throws IOException {
			
			Object[][] excelData = HotelBook.getExcelData();
//	data[0][0]= "vijy";
//	data[0][1]= "vijy";
//
//	data[1][0]= "123";
//	data[1][1]= "12324252353523";
	return excelData;
		}
}
