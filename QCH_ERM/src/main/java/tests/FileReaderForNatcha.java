package tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderForNatcha extends QCStore{
	
	public static String st1;
	public static String st2;
	public static String st3;
	public static String st4;
	public static String st5;
	public static String st6;
	public static String st7;
	public static String st8;
	public static String st9;
	public static String st10;	

	public static void main(String[] args) throws IOException {
		//C:\Users\shashidhar.g\Downloads			
		
	//	/html/body/table/tbody/tr/td/table[2]/tbody/tr[4]/td[1]/a
		
		String path="C:/Users/shashidhar.g/Downloads/";
		
		
		  File file = new File(path+NatchaFilename); 
		  
		  BufferedReader br = new BufferedReader(new FileReader(file)); 		  
		  String st=""; 		
		  int lines = 0;
		  while ((st = br.readLine()) != null) {
		   		    
		    if(lines==0){
		    	 st1=st.substring(13, 23);
				  StringBuilder sb = new StringBuilder(st);				
				  sb.insert(3, st1);
				  st1= sb.toString();
				  StringBuilder sb1 = new StringBuilder(st1);
				  sb1.replace(23,33,"");
				  st1= sb1.toString();
				  StringBuilder sb2 = new StringBuilder(st1);
				  sb2.replace(63,89,"WELLS FARGO BANK          ");
				  st1= sb2.toString();			 
				   System.out.println(st1);
				   lines++;
				   continue;
				
		    }
		   		    
		    if(lines==1)
		    {
		    	st2=st;
		    	 System.out.println(st2);
		    	 lines++;
		    	 continue;
	    	
		    }
		    
		    if(lines==2)
		    {
		    	
		    	StringBuilder sb3 = new StringBuilder(st);
		    	  sb3.replace(78,82,"1091");
		    	  st= sb3.toString();
		    	  //System.out.println(st);
		    	  StringBuilder sb4 = new StringBuilder(st);
		    	  sb4.replace(2,3,"6");
		    	  st= sb4.toString();
		    	  st3=st;
		    	 System.out.println(st3);
		    	 lines++;
		    	 continue;
			    			    	
		    }
		    if(lines==3)
		    {
		    	
		    	StringBuilder sb5 = new StringBuilder(st);
		    	  sb5.replace(9,10,"2");
		    	  st= sb5.toString();
		    	  st4=st;
		    	  System.out.println(st4);		    	  		    			    	 
		    	 lines++;
		    	 continue;			    			    	
		    }
		    if(lines==4)
		    {
		    	
		    	StringBuilder sb6 = new StringBuilder(st);
		    	  sb6.replace(20,21,"2");
		    	  st= sb6.toString();
		    	  st5=st;
		    	  System.out.println(st5);
		    	 lines++;
		    	 continue;
			    	//break;
		    	
		    }
		    if(lines==5)
		    {
		    	
		    	st6=st;
		    	 System.out.println(st6);
		    	 lines++;
		    	 continue;
		    	 		    	 		    	
		    }
		    if(lines==6)
		    {
		    	
		    	st7=st;
		    	 System.out.println(st7);
		    	 lines++;
		    	 continue;		    	 		    	 		    	
		    }
		    if(lines==7)
		    {
		    	st8=st;		    	 
		    	 System.out.println(st8);
		    	 lines++;
		    	 continue;		    	 		    	 		    	
		    }
		    if(lines==8)
		    {
		    	
		    	st9=st;
		    	 System.out.println(st9);
		    	 lines++;
		    	 continue;		    	 		    	    	
		    }
		    if(lines==9)
		    {
		    	
		    	st10=st;
		    	 System.out.println(st10);
		    	 lines++;
		    	break;		    	 
		    	 	    	
		    }
		 		
		  }
		  
		  FileWriter writer = new FileWriter(path+NatchaFilename, true);
		writer.write(st1+"\r\n"+st2+"\r\n"+st3+"\r\n"+st4+"\r\n"+st5+"\r\n"+st6+"\r\n"+st7+"\r\n"+st8+"\r\n"+st9+"\r\n"+st10);
		 writer.close();
	}

}

