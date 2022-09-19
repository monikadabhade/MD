package utility;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetExcelData
{
	public static String getData(int row,int cell) throws EncryptedDocumentException, IOException
	{
		int r=row;
		int c=cell;
		String path="C:\\Users\\admin\\Desktop\\Book 1.xlsx";
		FileInputStream file=new FileInputStream(path);
		String value=WorkbookFactory.create(file).getSheet("Sheet3").getRow(r).getCell(c).getStringCellValue();
		return value;
		
	}
	
	
	
	
	
	
	
	
	
	
	public static void getAllData(int row,int cell) throws EncryptedDocumentException, IOException
	{
		int r=row;
		int c=cell;
		String path="C:\\Users\\admin\\Desktop\\Book 1.xlsx";
		FileInputStream file=new FileInputStream(path);
		String value;
		Double value2;
		try
		{
		value=WorkbookFactory.create(file).getSheet("Sheet3").getRow(r).getCell(c).getStringCellValue();
		System.out.println(value);
		}
		catch(IllegalStateException e)
		{
			value2=WorkbookFactory.create(file).getSheet("Sheet3").getRow(r).getCell(c).getNumericCellValue();
			System.out.println(value2);
		}
		
		
	}
	
		
}
