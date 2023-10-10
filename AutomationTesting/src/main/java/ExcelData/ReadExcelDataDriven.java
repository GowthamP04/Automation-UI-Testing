package ExcelData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelDataDriven {

	public ArrayList<String> getData(String testcaseName) throws IOException {
		
		ArrayList<String> a = new ArrayList<String>();
		
		//common steps are all the excelsheet
		FileInputStream file = new FileInputStream("excel file path..");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		int sheets = workbook.getNumberOfSheets();
		
		for(int i=0 ;i<sheets; i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata")) { //--testdata is a sheet name
				XSSFSheet sheet = workbook.getSheetAt(i);
				
				//identify testcases column by scanning the entire 1st row
				Iterator<Row> rows =sheet.iterator();//sheet is collection of rows
				Row firstrow = rows.next();
				
				Iterator<Cell> ce=firstrow.cellIterator();//row is collection of cell
				int k=0;
				int column = 0;
				
				while(ce.hasNext()) {
					Cell value =ce.next();
					if(value.getStringCellValue().equalsIgnoreCase("testcase")) {//testcase is a firstcell value
						column = k;
					}
				}
				//once column is identified then scan testcase column to identify purchase testcase row
				while(rows.hasNext()) {
					Row r = rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName)) {
						//after u grab purchase testcase row pull all the data of that row into test
						Iterator<Cell> cv = r.cellIterator();
						while(cv.hasNext()) {
							
							Cell c = cv.next();
							if(c.getCellType()==CellType.STRING) //in excel its only display as string value
							{
								a.add(c.getStringCellValue());
							}else {
								
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));//its only display as numeric value
							}
							
						}
					}
				}
				
			}
		}
		
		return a;
	}
	public static void main(String[] args) throws IOException {
		}
	}