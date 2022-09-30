package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilize {
	
	public static int getRowCount(String sheetname) throws EncryptedDocumentException, InvalidFormatException, IOException{
		int rc=0;
		FileInputStream fis=new FileInputStream("C:\\Users\\Sony\\git\\actitime\\data\\ExcelTest.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		rc= wb.getSheet(sheetname).getLastRowNum();
		return rc;
		
	}

public static String getCellValue(String sheetname,int r,int c) throws EncryptedDocumentException, InvalidFormatException, IOException  {
	String v="";
	FileInputStream fis=new FileInputStream("C:\\Users\\Sony\\git\\actitime\\data\\ExcelTest.xlsx");
//	FileInputStream fis=new FileInputStream("F:\\workspace-eclipse\\Ravi eclipse workspace\\POM\\data\\ExcelTest.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	 Cell cellvalue = wb.getSheet(sheetname).getRow(r).getCell(c);
	 v=cellvalue.toString();
	 
		 return v;
}
	
	
	}


