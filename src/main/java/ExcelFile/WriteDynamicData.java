package ExcelFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDynamicData {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		FileOutputStream file= new FileOutputStream(System.getProperty("user.dir") +"\\testData\\StudentDetails.xlsx");
		XSSFWorkbook workbook= new XSSFWorkbook();
		XSSFSheet sheetname=workbook.createSheet("Sheet1");
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of rows: ");
		int rows=sc.nextInt();
		
		System.out.println("Enter the number of Cells: ");
		int cells=sc.nextInt();

		for(int r=0; r<=rows;r++)
		{
			XSSFRow currentRow=sheetname.createRow(r);
			System.out.println("Enter the student details in Row: "+r);
			
			for(int c=0; c<cells; c++)
			{
				XSSFCell currentcell=currentRow.createCell(c);
				System.out.println("Enter the student details Cell: " +c);
				currentcell.setCellValue(sc.next());
			}
		}
		
		workbook.write(file);
		workbook.close();
		file.close();
		
		System.out.println("File Created succssfully....!");
	}

}
