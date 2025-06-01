package ExcelFile;


import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writeDataExcel {

	public static void main(String[] args) throws IOException {

		FileOutputStream file= new FileOutputStream(System.getProperty("user.dir") +"\\testData\\FamillyDetails.xlsx");
		XSSFWorkbook workbook= new XSSFWorkbook();
		XSSFSheet sheetname=workbook.createSheet("Sheet1");
		XSSFRow row1 = sheetname.createRow(0);
			row1.createCell(0).setCellValue("Sachin Mehetre");
			row1.createCell(1).setCellValue(37);
			row1.createCell(2).setCellValue("Father");
		
		XSSFRow row2 = sheetname.createRow(1);
			row2.createCell(0).setCellValue("Trupti Mehetre");
			row2.createCell(1).setCellValue(27);
			row2.createCell(2).setCellValue("Mother");
			
		XSSFRow row3 = sheetname.createRow(2);
			row3.createCell(0).setCellValue("Sachit Mehetre");
			row3.createCell(1).setCellValue(2.5);
			row3.createCell(2).setCellValue("Son");
			
			workbook.write(file);
			workbook.close();
			file.close();
		System.out.println("File Created succssfully....!");
	}

}
