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
	static HSSFWorkbook wb;
	
	public static void main( String args[] ) throws IOException{
		FileInputStream fis = new FileInputStream(new File("C:\\Users\\a69753\\Documents\\comparisonTest.xls"));
		wb = new HSSFWorkbook(fis);
		sheet =  wb.getSheetAt(0);
		
		writeSheet();
		printSheet();
		save();

	}
	
	public static void writeSheet(){
		Row row = sheet.createRow(1);
//		Cell cell = row.createCell(2);
//	    cell.setCellValue("dust");.
		
		row.createCell(0).setCellValue("fast");
		row.createCell(1).setCellValue("dumb");
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
		FileOutputStream fileOut = new FileOutputStream (new File("C:\\Users\\a69753\\Documents\\comparisonTestOutput.xls"));
		wb.write(fileOut);
		fileOut.close();
	}


}
