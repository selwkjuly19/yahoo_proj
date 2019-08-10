package Yahoo_Prg;

import org.openqa.selenium.By;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;

import Yahoo_prop.ComposeP;
import Yahoo_prop.LoginP;

public class Compose extends MainClass
{
 public void sendmail() throws Exception
 {
	 Thread.sleep(5000);
	 driver.findElement(By.xpath(ComposeP.xcompose)).click();
	 Thread.sleep(5000);
	 try
	 {
		 if(driver.findElement(By.id(ComposeP.ito)).isDisplayed())
		 {
			 log=ext.createTest("passTest");
			 log.log(Status.PASS, "Compose is working");
			 takescreenshot(imagepath+"compose.png");
			 log.addScreenCaptureFromPath(imagepath+"compose.png");
			 
			 driver.findElement(By.id(ComposeP.ito)).sendKeys("abcd@gmail.com");
			 driver.findElement(By.id(ComposeP.isub)).sendKeys("testmail");
			 driver.findElement(By.id(ComposeP.ibody)).sendKeys("This is sample message in the body");
			 driver.findElement(By.xpath(ComposeP.xsend)).click();
			 Thread.sleep(5000);
		 }
	 }
	 catch(Exception e)
	 {
		 log=ext.createTest("failTest");
		 log.log(Status.FAIL, "Compose NOT working");
		 takescreenshot(imagepath+"compose.png");
		 log.addScreenCaptureFromPath(imagepath+"compose.png");
	 }	
 }
 public void close()
 {
	 driver.findElement(By.linkText(LoginP.lsignout)).click();
	 driver.close();
 }
}
