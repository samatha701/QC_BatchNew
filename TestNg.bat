set projectLocation=D:\QC_Batch\QC_ILP
cd %projectLocation%

java org.testng.TestNG %projectLocation%\testng.xml
pause