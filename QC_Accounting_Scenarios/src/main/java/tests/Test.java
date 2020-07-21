package tests;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	/*	String last4cheknum = "8001";
		System.out.println(last4cheknum);
		String i = "8001";
		String s = String.valueOf(i);

		//String s = Integer.toString(i);
		String s1 = "" + i;
		System.out.println("The value of i is: " + i);*/
		
		
		/*for (int j=8001; j<=8007; j++)
		{
		   
		
		   System.out.println(j);
		   System.out.println("pass");
		   
		}*/
		String last4cheknum="8001";
		int last4=Integer.parseInt(last4cheknum);
		String s = String.valueOf(last4cheknum);
		for (int j=last4; j<=last4+5; j++)
		{
		 String last4str=String.valueOf(j);  
		//driver.findElement(By.xpath("//*[@id='checkNbrs0']")).sendKeys(last4str);
		//test.log(LogStatus.PASS, "Check Number Entered is  " + CheckNbr1);
		  System.out.println(last4str);
		   //System.out.println("pass");
		   
		}
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
