package ExcelData;

import java.io.IOException;
import java.util.ArrayList;

public class TestSample {

	public static void main(String[] args) throws IOException {
		
		ReadExcelDataDriven d = new ReadExcelDataDriven();
		ArrayList data = d.getData("add profile"); //add profile is in excel 4th row of the excel sheet
		
		System.out.println(data.get(0)); //in excel 4th row 0th cell
		System.out.println(data.get(1)); //in excel 4th row 1st cell
		System.out.println(data.get(2)); //in excel 4th row 2nd cell
		System.out.println(data.get(3)); //in excel 4th row 3rd cell
//ex:driver.findelement(by.id("jgh").sendkeys(data.get(0));  --particular value send to sendkeys
	}

}
