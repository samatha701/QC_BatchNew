package tests;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.relevantcodes.extentreports.LogStatus;

public class Trial {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		
		/*String strDate="26-July-19";
		String store_date[]=strDate.split("-");
		String business_date=store_date[1].trim();
		System.out.println(business_date.toUpperCase()); 
		String ddate=business_date.toUpperCase();
		 //System.out.println();
		 
		int n = 3;		
		String s = ddate;
		System.out.println(s.substring(0,n));
		
		ArrayList<String> list = new ArrayList<>();
		String lista=store_date[0]+""+"-"+s.substring(0,n)+"-"+store_date[2];	      
	    System.out.println(lista);*/
		    String Due_Date = "08/19/2019";
		    
		    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yy");  
		    DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
		    Date DDueDateminus1 = df.parse(Due_Date);
		    String strDate= formatter.format(DDueDateminus1);  
		    System.out.println(strDate); 
		   
		    
		   /* DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");									 
			 Date DDueDateminus1 = df.parse(Due_Date);
			 SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yy");  
			 String strDate= formatter.format(DDueDateminus1);  
			 System.out.println(strDate); */
			 //test.log(LogStatus.PASS, "After AgeStore to Due Date the Date is : " +strDate);
		 
		 
		
		 
		
		 
		 
		 
		//test.log(LogStatus.PASS, "Business date is :"+business_date);


	}

}
