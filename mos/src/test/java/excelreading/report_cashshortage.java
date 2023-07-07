package excelreading;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class report_cashshortage 
{
	
		@Test
		@Parameters({"url","path"})
		public void f(String url,String path) throws InterruptedException, IOException 
		{
			
			
		     File file = new File("D:/CashShortage_Report_19_06_2023_15_21_46.xls");
			 String filelname=file.getName();
			 System.out.println(filelname);
			
			
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
		  listexpected.add("Merchant Info");
		  listexpected.add("Terminal ID");
		  listexpected.add("Org Txn ID");
		  listexpected.add("Transaction ID");
		  listexpected.add("RRN/UTR");
		  listexpected.add("Amount");
		  listexpected.add("Number of Time Status Check");
		  listexpected.add("First Request Date & Time");
		  listexpected.add("Last Request Date & Time");
		  listexpected.add("Status");
		  
		  
		 
		  int expectedsize= listexpected.size();
		 
		  List<String> listactual=new ArrayList<String>();  
		  XSSFSheet sht= wb.getSheetAt(0);
		  int count= sht.getRow(3).getLastCellNum();
		  System.out.println("total row in inputed excel "+count);
		  

		  
		  
		  //here i have added one by one manualy need to enhance
		  XSSFCell cell1 = sht.getRow(3).getCell(0);
			 String   column1 = cell1.getStringCellValue();
			 listactual.add(0, column1);

			 
			 XSSFCell cell2 = sht.getRow(3).getCell(1);
			 String   column2 = cell2.getStringCellValue();
			 listactual.add(1, column2);
			 
			 
			 XSSFCell cell3 = sht.getRow(3).getCell(2);
			 String   column3 = cell3.getStringCellValue();
			 listactual.add(2, column3);


			 XSSFCell cell4 = sht.getRow(3).getCell(3);
			 String   column4 = cell4.getStringCellValue();
			 listactual.add(3, column4);

			 
			 XSSFCell cell5 = sht.getRow(3).getCell(4);
			 String   column5 = cell5.getStringCellValue();
			 listactual.add(4, column5);

			 
			 XSSFCell cell6 = sht.getRow(3).getCell(5);
			 String   column6 = cell6.getStringCellValue();
			 listactual.add(5, column6);

			 
			 
			 XSSFCell cell7 = sht.getRow(3).getCell(6);
			 String   column7 = cell7.getStringCellValue();
			 listactual.add(6, column7);
			 
			 
			 XSSFCell cell8 = sht.getRow(3).getCell(7);
			 String   column8 = cell8.getStringCellValue();
			 listactual.add(7, column8);

			 
			 XSSFCell cell9 = sht.getRow(3).getCell(8);
			 String   column9 = cell9.getStringCellValue();
			 listactual.add(8, column9);

			 
			 XSSFCell cell10 = sht.getRow(3).getCell(9);
			 String   column10 = cell10.getStringCellValue();
			 listactual.add(9, column10);

			 
			int  listactualsize=listactual.size();



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

