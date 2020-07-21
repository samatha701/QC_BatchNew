package org.qa.base;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class Testbase {

	
	
	public static void get(String url) throws ClientProtocolException, IOException
	{
	CloseableHttpClient httpclient=	HttpClients.createDefault();
	HttpGet httpget=new HttpGet(url);
	CloseableHttpResponse closeableHttpResposse=httpclient.execute(httpget);
	
	int statuscode=closeableHttpResposse.getStatusLine().getStatusCode();
	System.out.println(statuscode);
	
	String responseString=EntityUtils.toString(closeableHttpResposse.getEntity(), "UTF-8");
	JSONObject jsonobject=new JSONObject(responseString);
	System.out.println(jsonobject);
	
	Header[] header=closeableHttpResposse.getAllHeaders();
	HashMap<String,String> allheader=new HashMap<String,String>();
	for(Header head:header)
	{
		allheader.put(head.getName(), head.getValue());
		
	}
	System.out.println(allheader);
	
	
	
	String name=getValueByJPath(jsonobject,"/per_page");
	System.out.println(name);
	String data1=getValueByJPath(jsonobject,"/data[0]/last_name");
	System.out.println(data1);
	
	
	
	
	
	
	}

	public static String getValueByJPath(JSONObject responsejson, String jpath){
		Object obj = responsejson;
		for(String s : jpath.split("/")) 
			if(!s.isEmpty()) 
				if(!(s.contains("[") || s.contains("]")))
					obj = ((JSONObject) obj).get(s);
				else if(s.contains("[") || s.contains("]"))
					obj = ((JSONArray) ((JSONObject) obj).get(s.split("\\[")[0])).get(Integer.parseInt(s.split("\\[")[1].replace("]", "")));
		return obj.toString();
	}
	
	
	
	public static void main(String args[]) throws ClientProtocolException, IOException
	{
		String url="https://reqres.in/api/users";
		get(url);
	}
	
	
	
	
	
	
}
