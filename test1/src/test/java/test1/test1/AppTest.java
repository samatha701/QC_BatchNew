package test1.test1;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/**
 * Unit test for simple App.
 */
public class AppTest 
{

	@Test(priority = 4)
	public static void execute()
    {
    	System.out.println("test1 executino completed ");
    }
	
	@BeforeClass(alwaysRun = true)
	public void setup() throws IOException {
	}
	
}
