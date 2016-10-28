package selenium;

import java.util.ArrayList;
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
	
	DifferenceObject differenceObject = new DifferenceObject();
	
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
	
	
	public void cycleFileDifferences(){
		
		  //---------------------------------------------CycleFileDifferences-----------------------------//
				
		System.out.println("Differences from Cycle file");
		//System.out.println(cycleLineTrNumber.size());
			
		for (WebElement eachCycleTrNumber:cycleLineTrNumber )
		{
			List<WebElement> tdTagsinCycleTr=eachCycleTrNumber.findElements(By.tagName("td"));
			
			for(WebElement tdTaginCycleTr: tdTagsinCycleTr)
			{
				List<WebElement> cycleSpans=tdTaginCycleTr.findElements(By.tagName("span"));
				List<String>cycleSpanText= new ArrayList<String>();
				for (WebElement cycleSpan: cycleSpans)
				{
					String cycleSpanDifference= cycleSpan.getText();
					cycleSpanText.add(cycleSpanDifference);
					//System.out.println(cycleSpanDifference);
				}
				StringBuilder cycleString= new StringBuilder();
				for (String cs:cycleSpanText)
				{
					cycleString.append(cs);
//					System.out.print(cs);
				}
				String cString = cycleString.toString();
				this.cycleDifferences.add(cString);
			}
			System.out.println("");
		}

	}
	
	public void baseLineFileDifferences(){
		//----------------------------------BaseLineFileDifferences----------------------------------//
		
		System.out.println("Differences from Base file");
    	
		//loops through each cycle block
		for (WebElement eachBaseTrNumber:baseLineTrNumber)
	    {
			
			WebElement lineNumber = eachBaseTrNumber.findElement(By.xpath("//td[@class='u2d_ln u2d_x_del_ln']"));
			System.out.println(lineNumber.getText());
			System.out.println("red");
			System.out.println(eachBaseTrNumber.getText());
			WebElement tdTagsinBaseTr= eachBaseTrNumber.findElement(By.xpath("//td[@class='u2d_code']"));

			List<WebElement> spanElements = tdTagsinBaseTr.findElements(By.tagName("span"));
			List<String> spanText= new ArrayList<String>();
			StringBuilder spanString = new StringBuilder();
			
			//grabs span elements and appends them to a single string.
			for (WebElement span:spanElements)
			{
				String difference= span.getText();
				spanString.append(difference);
			}
			String bString = spanString.toString();
			System.out.println(bString);
			this.baseDifferences.add(bString);
			System.out.println("*************");
			
			
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
