package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelWrite {
	
	public static String GetExcelWrite(String entervalue) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String v="";
		FileInputStream fis=new FileInputStream("F:\\workspace-eclipse\\Ravi eclipse workspace\\POM\\data\\ExcelTest.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		 Cell cellvalue = wb.getSheet("Sheet1").getRow(1).getCell(2);
		  cellvalue.setCellValue(entervalue);
		String path = "F:\\workspace-eclipse\\Ravi eclipse workspace\\POM\\data\\ExcelTest.xlsx";
		FileOutputStream fos = new FileOutputStream(path);
		wb.write(fos);
		System.out.println("entered in the excel sheet");
		return v;
		
	}

	
	}


