package selenium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumExtractor {

	List<String> cycleDifferences = new ArrayList<String>();
	List<String> baseDifferences = new ArrayList<String>();
	WebElement thdbody;
	List<WebElement> baseLineTrNumber;
	List <WebElement> cycleLineTrNumber;
	
	DifferenceObject myDifferenceObject = new DifferenceObject();
	
	public SeleniumExtractor(){
		initializeDriver();
	}
	
	public void initializeDriver(){
		WebDriver thd= new FirefoxDriver();
		thd.get("C:\\Users\\a69753\\Documents\\secondSample.html");
		this.thdbody =	thd.findElement(By.xpath("//tbody[@class= 'u2d_tbody']"));
		this.baseLineTrNumber= thdbody.findElements(By.xpath("//tr[@class='u2d_x_del']"));
		this.cycleLineTrNumber= thdbody.findElements(By.xpath("//tr[@class='u2d_x_add']"));
	}
	
	
//	public void cycleFileDifferences(){
//		
//		  //---------------------------------------------CycleFileDifferences-----------------------------//
//				
//		System.out.println("Differences from Cycle file");
//		//System.out.println(cycleLineTrNumber.size());
//			
//		for (WebElement eachCycleTrNumber:cycleLineTrNumber )
//		{
//			List<WebElement> tdTagsinCycleTr=eachCycleTrNumber.findElements(By.tagName("td"));
//			
//			for(WebElement tdTaginCycleTr: tdTagsinCycleTr)
//			{
//				List<WebElement> cycleSpans=tdTaginCycleTr.findElements(By.tagName("span"));
//				List<String>cycleSpanText= new ArrayList<String>();
//				for (WebElement cycleSpan: cycleSpans)
//				{
//					String cycleSpanDifference= cycleSpan.getText();
//					cycleSpanText.add(cycleSpanDifference);
//					//System.out.println(cycleSpanDifference);
//				}
//				StringBuilder cycleString= new StringBuilder();
//				for (String cs:cycleSpanText)
//				{
//					cycleString.append(cs);
////					System.out.print(cs);
//				}
//				String cString = cycleString.toString();
//				this.cycleDifferences.add(cString);
//			}
//			System.out.println("");
//		}
//
//	}
	
	public void cycleFileDifferences(){
		//----------------------------------CycleLineFileDifferences----------------------------------//
		
		System.out.println("Differences from Cycle file");
    	
		//loops through each Cycle block
		for (WebElement eachCycleTrNumber:cycleLineTrNumber)
	    {
			//create hashMap object for line difference
			HashMap<String, String> cycleItemMap = new HashMap<String, String>();
			
			//extract and save entire code line
			System.out.println(eachCycleTrNumber.getText());
			cycleItemMap.put("DESCRIPTION", eachCycleTrNumber.getText());
			
			//extract and save color of text
			System.out.println("+");
			cycleItemMap.put("STATUS", "+");
			
			//extract and save color code line number
			System.out.println(eachCycleTrNumber.getText().substring(0, 3));
			cycleItemMap.put("LINE_NUMBER", eachCycleTrNumber.getText().substring(0, 3));
			
			//extract and save product line item
			System.out.println(eachCycleTrNumber.getText().substring(4, 11));
			cycleItemMap.put("LINE_ITEM_CODE", eachCycleTrNumber.getText().substring(4, 11));
			
//		****TODO Fix span line item function****
			WebElement tdTagInCycleTr = eachCycleTrNumber.findElement(By.xpath("//td[@class='u2d_code']"));
			System.out.println(tdTagInCycleTr.getText());

			List<WebElement> spanElements = tdTagInCycleTr.findElements(By.tagName("span"));
			StringBuilder spanString = new StringBuilder();
			
			//grabs span elements and appends them to a single string.
			for (WebElement span:spanElements)
			{
				System.out.print(span.getText() + "******");
				String difference= span.getText();
				spanString.append(difference);
			}
			String cString = spanString.toString();
			System.out.println(cString);
			this.cycleDifferences.add(cString);
			System.out.println("*************");
			
			myDifferenceObject.cycleList.add(cycleItemMap);
			
	    }
	}
	
	public void baseLineFileDifferences(){
		//----------------------------------BaseLineFileDifferences----------------------------------//
		
		System.out.println("Differences from Base file");
    	
		//loops through each base block
		for (WebElement eachBaseTrNumber:baseLineTrNumber)
	    {
			//create hashMap object for line difference
			HashMap<String, String> baseItemMap = new HashMap<String, String>();
			
			//extract and save entire code line
			System.out.println(eachBaseTrNumber.getText());
			baseItemMap.put("DESCRIPTION", eachBaseTrNumber.getText());
			
			//extract and save color of text
			System.out.println("-");
			baseItemMap.put("STATUS", "-");
			
			//extract and save color code line number
			System.out.println(eachBaseTrNumber.getText().substring(0, 3));
			baseItemMap.put("LINE_NUMBER", eachBaseTrNumber.getText().substring(0, 3));
			
			//extract and save product line item
			System.out.println(eachBaseTrNumber.getText().substring(4, 11));
			baseItemMap.put("LINE_ITEM_CODE", eachBaseTrNumber.getText().substring(4, 11));
			
//		****TODO Fix span line item function****
			WebElement tdTagInBaseTr = eachBaseTrNumber.findElement(By.xpath("//td[@class='u2d_code']"));
			System.out.println(tdTagInBaseTr.getText());

			List<WebElement> spanElements = tdTagInBaseTr.findElements(By.tagName("span"));
			StringBuilder spanString = new StringBuilder();
			
			//grabs span elements and appends them to a single string.
			for (WebElement span:spanElements)
			{
				System.out.print(span.getText() + "******");
				String difference= span.getText();
				spanString.append(difference);
			}
			String bString = spanString.toString();
			System.out.println(bString);
			this.baseDifferences.add(bString);
			System.out.println("*************");
			
			myDifferenceObject.baseList.add(baseItemMap);
			
	    }
	}
		
	
	public void printStringList(){
		int num = 0;
		for(String string: cycleDifferences){
			//System.out.print(num);
			System.out.print(string + "");
			num++;
		}
	}

}
