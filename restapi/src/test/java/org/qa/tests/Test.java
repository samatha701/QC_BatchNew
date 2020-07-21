package org.qa.tests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.qa.base.Testbase;
import org.testng.annotations.BeforeMethod;


public class Test extends Testbase{

	Testbase testbase;
	String url="https://reqres.in/api/users";
	
	
	
	
	@BeforeMethod
	public void start() throws ClientProtocolException, IOException
	{
		testbase=new Testbase();
		testbase.get(url);
	}
	
	@org.testng.annotations.Test
	public void start1() throws ClientProtocolException, IOException
	{
		testbase=new Testbase();
		testbase.get(url);
	}
	
	
	
	
	
}
