package ExcelSheetDataProvider;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] main(String[] args) throws IOException {
		
		String filelocation = "excel file path..";
		
		XSSFWorkbook wbook = new XSSFWorkbook(filelocation);
		
		XSSFSheet sheet = wbook.getSheetAt(0);
		
		int lastrownum = sheet.getLastRowNum();//last value expect header
		int physicalnumrow = sheet.getPhysicalNumberOfRows(); //cover the all data value including header
		short lastcellnum = sheet.getRow(0).getLastCellNum();
		
		String[][] data = new String[lastrownum][lastcellnum];
		
		for (int i = 1; i <=lastrownum; i++) {
			XSSFRow row = sheet.getRow(i);
			
			for (int j = 0; j < lastcellnum; j++) {
				XSSFCell cell = row.getCell(j);//column 
				
				DataFormatter dft = new DataFormatter();
				String value = dft.formatCellValue(cell); //its allow all format like number,string everything is allow dataformatter
				
				//String value = cell.getStringCellValue(); //its only allow string value
				//System.out.println(value);
				data[i-1][j] = value;
			} 
		}

		return data;
	}

}
