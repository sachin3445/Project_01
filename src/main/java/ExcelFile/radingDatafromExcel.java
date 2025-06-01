package ExcelFile;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class radingDatafromExcel {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file= new FileInputStream(System.getProperty("user.dir") +"\\testData\\EmployeeDetails.xlsx");
		XSSFWorkbook workbook= new XSSFWorkbook(file);
		XSSFSheet sheetname=workbook.getSheet("Sheet1");
		int totalRows=sheetname.getLastRowNum();
		int totalCells=sheetname.getRow(1).getLastCellNum();
		
		System.out.println("Total number of rows: "+totalRows);
		System.out.println("Total number of cells: "+totalCells);
		
		for(int r=0; r<=totalRows; r++)
		{
			XSSFRow currentRow=sheetname.getRow(r);
			
			for(int c = 0; c<totalCells; c++)
			{
				XSSFCell cell=currentRow.getCell(c);
				System.out.print(cell.toString()+"\t");
			}
			System.out.println();
		}
		
		
		workbook.close();
		file.close();
	}

}
