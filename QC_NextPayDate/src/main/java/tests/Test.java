package tests;

import com.relevantcodes.extentreports.LogStatus;

public class Test {

	public static void test()
	{
		
		try {
			for(int i=0;i<5-1;i++)
			{
				//interest_page[i]="1";
				String s[] = new String [20];
				s[1]="1";
				s[1]="2";
				s[i]="1";
				
				System.out.println(s[i]);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	
	
	
	public static void main(String args[])
	{
		test();
	}
}
