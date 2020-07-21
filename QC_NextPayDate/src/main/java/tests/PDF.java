package tests;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.EmptyFileException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class PDF extends QCStore{
	
	
		 public static String readPDFInURL() throws EmptyFileException, IOException {
		     
		        // page with example pdf document
			 driver = new InternetExplorerDriver();
		        driver.get("file:///C:/Users/brahmithchary.p/Downloads/SBI.pdf");
		        URL url = new URL(driver.getCurrentUrl());
		        InputStream is = url.openStream();
		        BufferedInputStream fileToParse = new BufferedInputStream(is);
		        PDDocument document = null;
		        
		        boolean flag = false;
				
				PDFTextStripper pdfStripper = null;
				PDDocument pdDoc = null;
				COSDocument cosDoc = null;
				String parsedText = null;
				try {
					String strURL = driver.getCurrentUrl();
					//url = new URL(strURL);
					BufferedInputStream file = new BufferedInputStream(url.openStream());
					/*PDFParser parser = new PDFParser(file);
					
					parser.parse();
					cosDoc = parser.getDocument();
					pdfStripper = new PDFTextStripper();
					pdfStripper.setStartPage(1);
					pdfStripper.setEndPage(1);
					
					pdDoc = new PDDocument(cosDoc);
					parsedText = pdfStripper.getText(pdDoc);*/
				} catch (MalformedURLException e2) {
					System.err.println("URL string could not be parsed "+e2.getMessage());
				} catch (IOException e) {
					System.err.println("Unable to open PDF Parser. " + e.getMessage());
					try {
						if (cosDoc != null)
							cosDoc.close();
						if (pdDoc != null)
							pdDoc.close();
					} catch (Exception e1) {
						e.printStackTrace();
					}
				}
		        
		        
		        
		        try {
		            document = PDDocument.load(fileToParse);
		            String output = new PDFTextStripper().getText(document);
		        } finally {
		            if (document != null) {
		                document.close();
		            }
		            fileToParse.close();
		            is.close();
		        }
		        String output = null;
		        System.out.println(output);
				return output;
		    }
}

