package commonUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import baseClass.BaseClass;

public class XLFFile extends BaseClass {
	public static FileInputStream file;
	public static FileOutputStream fout;
	public static XSSFWorkbook work;;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRow(String xlfile, String xlsheet) throws IOException
	{
		file=new FileInputStream(xlfile);
		
		work= new XSSFWorkbook(file);
		sheet=work.getSheet(xlsheet);
		int rowCount=sheet.getLastRowNum();
		return rowCount;
	}
	public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException
	{
		getRow(xlfile, xlsheet);
		row=sheet.getRow(rownum);
		int cellCount=row.getLastCellNum();
		return cellCount;
	}
	public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		getCellCount(xlfile,xlsheet,rownum);
		cell=row.getCell(colnum);
		String data;
		try
		{
				DataFormatter formatter=new DataFormatter();
				String CellData=formatter.formatCellValue(cell);
				return CellData;
		}
		catch(Exception e)
		{
			data=" ";
		}
		return data;
		
	}
	public static  void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		getCellData(xlfile,xlsheet,rownum,colnum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fout=new FileOutputStream(xlfile);
		work.write(fout);
		
		
	}
	 public static boolean isAltertPresent()
	 {
		 try {
		 driver.switchTo().alert();
		 return true;
		 }
		 catch(Exception e)
		 {
			 return false;
		 }
	 }
	

}
