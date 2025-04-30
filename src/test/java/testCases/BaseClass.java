package testCases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.security.DrbgParameters.Capability;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class BaseClass {

	public static WebDriver driver;	
	public Logger logger;
	public Properties p;
	@BeforeClass
	@Parameters({"os","browser"})
	public void Setup(String os,String br ) throws IOException {
		
		//loading config.properties
		
		FileReader file= new FileReader(".//src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		
		logger=LogManager.getLogger(this.getClass());
	
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			
			DesiredCapabilities capbilities= new DesiredCapabilities();
			//os
			if(os.equalsIgnoreCase("windows")) {
				
				capbilities.setPlatform(Platform.WIN10);
			}
			else if(os.equalsIgnoreCase("mac")) {
				capbilities.setPlatform(Platform.MAC);
			}else {
				System.out.println("No matching os");
				return;
			}
			//broswer
			switch(br.toLowerCase()) {
			case "chrome":capbilities.setBrowserName("chrome");break;			
			case "edge":capbilities.setBrowserName("MicrosoftEdge");break;			
			default:System.out.println("No matching broswer"); return;
			}
			driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capbilities);
			
		}
				
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
		
		switch(br.toLowerCase())
		{
	    case "chrome":driver = new ChromeDriver();
	        break;
	    case "edge": driver = new EdgeDriver();
	        break;
	    default: System.out.println("Invalid browser name");
	        return;
	     }
		}
		
		driver.manage().deleteAllCookies();							
		driver.get(p.getProperty("appURL1"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
	}
		
	
	public String randomString() {
		
		String generatedString=RandomStringUtils.randomAlphanumeric(5);
		return generatedString;
		
	}
	 
	public String randomNumaric() {
	String genaratenumaric=	RandomStringUtils.randomNumeric(10);	
	return genaratenumaric;
	
	}
	
	public String randomAlphaNumaric() {
		String generatedString=RandomStringUtils.randomAlphanumeric(5);		
		String genaratenumaric=	RandomStringUtils.randomNumeric(10);		
		return (generatedString+"@"+genaratenumaric);
	}
	public String captureScreen(String tname) throws IOException {
	    String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

	    TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	    File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

	    String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
	    File targetFile = new File(targetFilePath);

	    sourceFile.renameTo(targetFile);

	    return targetFilePath;
	}

	
	@AfterClass
	public void TearDown() {
		
		if (driver != null) {
		    driver.close();
		}

	}
}
