package yahoo_suite;

import java.io.FileInputStream;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Yahoo_Prg.Compose;
import Yahoo_Prg.Inbox;
import Yahoo_Prg.Login;
import Yahoo_Prg.MainClass;

public class ReTest extends MainClass
{
  	
  @Test	
  @Parameters({"browser"})
  public void retesting(String str) throws Exception
  {
	  if(str.matches("firefox"))
	  {
		  System.setProperty("webdriver.gecko.driver","D:\\Sel_wk_july\\myproj\\geckodriver.exe");
		  driver=new FirefoxDriver();
	  }
	  if(str.matches("chrome"))
	  {
		  System.setProperty("webdriver.chrome.driver","D:\\Sel_wk_july\\myproj\\chromedriver.exe");
		   driver=new ChromeDriver();
	  }
	  FileInputStream fin = new FileInputStream("D:\\sel_dec18\\testcases.xlsx");  // get the excel file
	  XSSFWorkbook wb=new XSSFWorkbook(fin);   // workbook in the file
	  XSSFSheet ws=wb.getSheet("retest");     // get sheet1 in the workbook
		String classname,methodname;
		Row row;
		for(int r=1;r<=ws.getLastRowNum();r++)   //for all the rows in the sheet
		{
			row=ws.getRow(r);
			if(row.getCell(5).getStringCellValue().matches("yes"))
			{
				classname=row.getCell(3).getStringCellValue();
				methodname=row.getCell(4).getStringCellValue();
				Class c=Class.forName(classname);  //load the sample class into memory
				Method m=c.getMethod(methodname,null);  //get method in the class
				Object obj=c.newInstance();   //create object for the class
				m.invoke(obj, null);  // invoke the method
			}
		}
		fin.close();
  }
}
