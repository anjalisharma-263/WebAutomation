package com.purpleAdmin.qa.base;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class Demo
{
	static String path = System.getProperty("user.dir");
	
    public static void main(String args[]) throws IOException
    {
     System.setProperty("webdriver.chrome.driver",path + "/src/main/resources/browserSetup/Win/chromedriver.exe");
     WebDriver driver=new ChromeDriver();
           
        driver.get("http://amc.yourdirectroute.com/");
             WebElement logoImageElement = driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img"));
             Screenshot logoImageScreenshot = new AShot().takeScreenshot(driver, logoImageElement);
       ImageIO.write(logoImageScreenshot.getImage(),"png",new File("C://SeleniumPractice/logos/OrangeHRMlogo.png"));
             File f = new File("C://SeleniumPractice/logos/OrangeHRMlogo.png");
    if(f.exists())
  {
     System.out.println("Image File Captured");
   }
  else
  {
   System.out.println("Image File NOT exist");
  }
          }
}