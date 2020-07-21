package tests;

import com.relevantcodes.extentreports.LogStatus;

public class PTICalculation extends QCStore{
	
	
	
	public static void Calculation()
	{
		Biw_NoofWeeks=Aprop.getProperty("Bi_Weeeks");
		Biw_NoofMonths=Aprop.getProperty("Bi_Months");
		
		Wek_NoofMonths=Aprop.getProperty("We_Months");
		Wek_NoofWeeks=Aprop.getProperty("We_Weeks");
		
		Biw_NoofMonthsInt=Integer.parseInt(Biw_NoofMonths);
		Biw_NoofWeeksInt=Integer.parseInt(Biw_NoofWeeks);
		
		Wek_NoofMonthsInt=Integer.parseInt(Wek_NoofMonths);
		Wek_StringNoofWeeksInt=Integer.parseInt(Wek_NoofWeeks);
		
		
		 Gross=Integer.parseInt(Income_GrossIncome);
		System.out.println("Gross income is "+ Gross);
		
	if(Income_PayFrequency.equalsIgnoreCase("Bi-Weekly")){
			
		 CalMonthlyIncome=(Gross*Biw_NoofWeeksInt)/Biw_NoofMonthsInt;
		System.out.println("caluculated monthly income is "+CalMonthlyIncome);
		
		
		 PTIamt= (CalMonthlyIncome*22.5)/200;
		System.out.println("calculated PTI Amount is"+PTIamt);
		test.log(LogStatus.PASS, "calculated PTI Amount is"+PTIamt);
		

}
	else if(Income_PayFrequency.equalsIgnoreCase("Weekly")){
		
		 CalMonthlyIncome=(Gross*Wek_StringNoofWeeksInt)/Wek_NoofMonthsInt;
		System.out.println("caluculated monthly income is "+CalMonthlyIncome);
		
		 PTIamt= (CalMonthlyIncome*22.5)/200;
		System.out.println("calculated PTI Amount is"+PTIamt);
		test.log(LogStatus.PASS, "calculated PTI Amount is"+PTIamt);
		

}
	
	else if(Income_PayFrequency.equalsIgnoreCase("Semi-Monthly")){
		
		 CalMonthlyIncome=Gross*2;
		System.out.println("caluculated monthly income is "+CalMonthlyIncome);
		
		 PTIamt= (CalMonthlyIncome*22.5)/200;
		System.out.println("calculated PTI Amount is"+PTIamt);
		test.log(LogStatus.PASS, "calculated PTI Amount is"+PTIamt);
		

}
	
	else if(Income_PayFrequency.equalsIgnoreCase("Monthly")){
		
		 CalMonthlyIncome=Gross;
		System.out.println("caluculated monthly income is "+CalMonthlyIncome);
		
		 PTIamt= (CalMonthlyIncome*22.5)/100;
		System.out.println("calculated PTI Amount is"+PTIamt);
		test.log(LogStatus.PASS, "calculated PTI Amount is"+PTIamt);
		

}
	
		
		
		
	
	
	
	}}
