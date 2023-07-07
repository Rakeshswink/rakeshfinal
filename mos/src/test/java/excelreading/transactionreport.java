package excelreading;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.collect.Table.Cell;

public class transactionreport {

	@Test
	  @Parameters({"url","path"})
	  public void f(String url,String path) throws InterruptedException, IOException 
	  {
		
	String columnName;
	int counter=0;
	
	 
		 File file = new File("D:/test.xlsx");
		 Thread.sleep(3000);
	     FileInputStream fis = new FileInputStream(file);

	    XSSFWorkbook wb = new XSSFWorkbook(fis);

        //understanding purpose

	    // int sheet=wb.getNumberOfSheets();
	     //System.out.println(sheet);
	    // XSSFSheet sht=wb.getSheetAt(0);
	    // XSSFRow row=sht.getRow(0);
	    // XSSFCell cle=row.getCell(1);
	    // String value = cle.getStringCellValue();
	     //System.out.println(value);
	    List<String> listexpected=new ArrayList<String>();
	    listexpected.add("Name");
	    listexpected.add("age");
	    listexpected.add("pincode");
	   
	    int expectedsize= listexpected.size();
	   
	    List<String> listactual=new ArrayList<String>();  
	    XSSFSheet sht= wb.getSheetAt(0);
	    int count= sht.getRow(0).getLastCellNum();
	    
	 
	    
	    
	    //here i have added one by one manualy need to enhance
	   XSSFCell cell1 = sht.getRow(0).getCell(0);
       String   column1 = cell1.getStringCellValue();
       listactual.add(0, column1);
       
       XSSFCell cell2 = sht.getRow(0).getCell(1);
       String   column2 = cell2.getStringCellValue();
       listactual.add(1, column2);
       
       XSSFCell cell3 = sht.getRow(0).getCell(2);
       String   column3 = cell3.getStringCellValue();
       listactual.add(2, column3);
       int listactualsize=listactual.size();
     
     
    
    
    if(listexpected.equals(listactual)&&(listactualsize==expectedsize))
    {
       System.out.println("Testcase passed");
       System.out.println(listactual);
      System.out.println("actual size"+listactualsize);
       System.out.println(listexpected);
       System.out.println("expected size"+expectedsize);
   
    }
    else
    {
    	System.out.println("Testcases failed");
    	 System.out.println(listactual);
        System.out.println("actual size"+listactualsize);
         System.out.println(listexpected);
         System.out.println("expected size"+expectedsize);
    	Assert.fail();
    }
       
   }
}


