package Util;

import org.testng.annotations.DataProvider;

public class DataUtil {
	@DataProvider(name = "Login" ) //, parallel = true  ) //,indices = {0}) -- particular data execution. if we enter the 0 index 1st index value is execute only
	public String[][] getData() {
		String[][] data = new String[2][2];
		data[0][0] = "koushik350@gmail.com";
		data[0][1] = "Pass123$";
		
		data[1][0] = "koushik1@letcode.in";
		data[1][1] = "Pass123$";
		
		return data;
	}
}
