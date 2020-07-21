package tests;

public class Payment extends QCStore 
{
	public static void login(String SSN,String csr_url)
	{
		int lastrow=TestData.getLastRow("Payment");
		String SheetName ="Payment";
		for(int row=2;row<=lastrow;row++)
		{
			String RegSSN=TestData.getCellData(SheetName,"SSN",row);
			if(SSN==RegSSN)
			{
				String TxnType =TestData.getCellData(SheetName,"TxnType",row);
				String TenderType= TestData.getCellData(SheetName,"TenderType" , row);
				String PaymentAmount=TestData.getCellData(SheetName,"PaymentAmount",row);
				String TenderAmount=TestData.getCellData(SheetName, "TenderAmount", row);
				
			}
		}
	}
}
