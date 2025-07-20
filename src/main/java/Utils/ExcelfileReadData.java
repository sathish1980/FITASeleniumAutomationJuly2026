package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class ExcelfileReadData {
	
	static String filepath=System.getProperty("user.dir")+"\\Input\\MakeMytrip.xlsx";
	static Object[][] value;
	public static Object[][] ReadData() throws IOException
	{
		File F = new File(filepath);
		FileInputStream Fs = new FileInputStream(F);
		XSSFWorkbook workbook = new XSSFWorkbook(Fs);
		Sheet sheet = workbook.getSheet("ValidData");
		int totalRows = sheet.getPhysicalNumberOfRows();
		Row row1 = sheet.getRow(1);
		int totalcoumns = row1.getLastCellNum();
		value = new Object[totalRows][totalcoumns];
		for(int i=0;i<totalRows;i++)
		{
			Row row = sheet.getRow(i);
			int totalcolumn = row.getLastCellNum();
			for(int j=0;j<totalcolumn;j++)
			{
				Cell eachcell = row.getCell(j);
				value[i][j]=GetCellValue(eachcell);
				//System.out.println(eachcell.getStringCellValue());
			}
			
		}
		return value;
		
	}
	
	public static Object GetCellValue(Cell cellVal)
	{
		if(cellVal.getCellType().toString()=="STRING")
		{
			return cellVal.getStringCellValue();
		}
		else
		{
			DataFormatter data =  new DataFormatter();
			return data.formatCellValue(cellVal);
			//return cellVal.getNumericCellValue();
		}
	}
	/*public static void main(String[] args) throws IOException
	{
		ExcelfileReadData E = new ExcelfileReadData();
		E.ReadData();
	}*/

}
