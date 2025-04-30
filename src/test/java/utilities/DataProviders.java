package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider 
	    @DataProvider(name="LoginData")
	    public String [][] getData() throws IOException
	    {
	        String path =".\\testData\\Opencart_Login_Data.xlsx"; //taking x1 file from testData

	        ExcelUtilits xlutil =new ExcelUtilits(path); //creating an object for XLUtility

	        int totalrows=xlutil.getRowCount("sheet1");
	        int totalcols=xlutil.getCellcount("sheet1", 1);

	        String logindata[][]=new String[totalrows][totalcols]; //created for two dimension array which can store data from x1 sheet

	        for(int i=1;i<=totalrows;i++) //1     //read the data from x1 storing in two demensional array
	        {
	            for(int j=0;j<totalcols;j++) //0     // i is rows j is col
	            {
	                logindata[i-1][j]= xlutil.getCellData("sheet1",i, j);  //1,0
	            }
	        }

	        return logindata; //returning two dimension array
	    }
	}


