package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class ExcelfileReadData {
	
	
	String filepath=System.getProperty("user.dir")+"\\Input\\MakeMytrip.xlsx";
	
	public void ReadData() throws IOException
	{
		File F = new File(filepath);
		FileInputStream Fs = new FileInputStream(F);
		XSSFWorkbook workbook = new XSSFWorkbook(Fs);
		Sheet sheet = workbook.getSheet("ValidData");
		int totalRows = sheet.getPhysicalNumberOfRows();
		for(int i=0;i<totalRows;i++)
		{
			Row row = sheet.getRow(i);
			int totalcolumn = row.getLastCellNum();
			for(int j=0;j<totalcolumn;j++)
			{
				Cell eachcell = row.getCell(j);
				System.out.println(eachcell.getStringCellValue());
			}
			
		}
		
		
	}
	public static void main(String[] args) throws IOException
	{
		ExcelfileReadData E = new ExcelfileReadData();
		E.ReadData();
	}

}
