package selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ApachePOI {
	
	static HSSFSheet sheet;
	static HSSFWorkbook wb = new HSSFWorkbook();
	
	public ApachePOI(){
		
	}
	
	public static void main( String args[] ) throws IOException{
		//FileInputStream fis = new FileInputStream(new File("C:\\Users\\a69753\\Documents\\quoteIssueTemplate.xls"));
		sheet = wb.createSheet("testSheet");
		//wb = new HSSFWorkbook(fis);
		sheet =  wb.getSheetAt(0);
		
		writeSheet();
		//printSheet();
		save();

	}
	
	public static void writeSheet(){
		SeleniumExtractor se = new SeleniumExtractor();
		se.cycleFileDifferences();
		se.baseLineFileDifferences();

		
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("baseLine Differences");
		cell = row.createCell(1);
		cell.setCellValue("cycle Differences");
		
//		for (int i = 1; i < 11; i++) {
//			row = sheet.createRow(i);
//		}

		

		int rowNum = 2;
		int colNum = 1;
		for (String string: se.cycleDifferences) {
			if(!string.isEmpty()){
				cell = sheet.getRow(rowNum).getCell(colNum);
				cell.setCellValue(string);
				System.out.println(string);
				rowNum++;
			}
		}
		
		rowNum = 2;
		colNum = 0;
		for (String string: se.baseDifferences) {
			if(!string.isEmpty()){
				row = sheet.getRow(rowNum);
				cell = row.getCell(colNum);
				cell.setCellValue(string);
				System.out.println(string);
				rowNum++;
			}
		}
	}
	
	
	

	public static void printSheet(){
		
		FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
		for(Row row : sheet ){
			for(Cell cell: row){
				switch(formulaEvaluator.evaluateInCell(cell).getCellType())
				{
				case Cell.CELL_TYPE_NUMERIC:
					System.out.print(cell.getNumericCellValue() + "\t\t");
					break;
					
				case Cell.CELL_TYPE_STRING:
					System.out.print(cell.getStringCellValue() + "\t\t");
					break;	
				}
			}
			System.out.println("");
		}
		System.out.println("Finished");
	}
	
	public static void save() throws IOException{
//		FileOutputStream fileOut = new FileOutputStream (new File("C:\\Users\\a69753\\Documents\\quoteIssueTemplateCopy.xls"));
//		wb.write(fileOut);
//		fileOut.close();
		FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\a69753\\Documents\\quoteIssueTest.xls"));
		wb.write(fos);
		fos.close();
	}


}
