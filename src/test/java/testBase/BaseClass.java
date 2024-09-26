package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass(groups= {"sanity","regression","master"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException
	{
		logger=LogManager.getLogger(this.getClass());
		FileReader file=new FileReader("C:\\Java_Eclipse_practise\\Automation_Excerise\\src\\test\\resources\\config.properties");
		p=new Properties();
		p.load(file);
		
		switch (br.toLowerCase())
		{
	       	case "chrome" : driver=new ChromeDriver(); break;
	       	case "edge" : driver=new EdgeDriver(); break;
	       	case "firefox" : driver=new FirefoxDriver(); break;
	       	default : System.out.println("Invalid browser name passed"); return;
		}
		
		driver.get(p.getProperty("appURL"));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"sanity","regression","master"})
	public void teardown()
	{
		driver.quit();
	}
	
	public String Randomstring()
	{
		String randomstring=RandomStringUtils.randomAlphabetic(5);
		return randomstring;
	}
	
	public String Randomnumber()
	{
		String randomnumeric=RandomStringUtils.randomNumeric(5);
		return randomnumeric;
	}
	
	public String RandomAlphanumeric()
	{
		String randomaplanumeric=RandomStringUtils.randomAlphanumeric(10);
		return randomaplanumeric;
	}
	
	public String captureScreen(String tname)
	{
		SimpleDateFormat sd=new SimpleDateFormat();
		Date dt=new Date();
		String timestamp =sd.format(dt);
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String path= System.getProperty("user.dir")+"\\screenshots"+ tname + "_" +timestamp + ".png";
		File targetFile =new File(path);
		src.renameTo(targetFile);
		
		return path;
		
	}

}
