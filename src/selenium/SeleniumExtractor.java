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
	
	public SeleniumExtractor(){
		initializeDriver();
	}
	
	public void initializeDriver(){
		WebDriver thd= new FirefoxDriver();
		thd.get("C:\\Users\\a69753\\Documents\\secondSample.html");
		this.thdbody =	thd.findElement(By.xpath("//tbody[@class= 'u2d_tbody']"));
		this.baseLineTrNumber= thdbody.findElements(By.xpath("//tr[@class='u2d_x_del']"));
	}
	
	
	public void cycleFileDifferences(){
		
		  //---------------------------------------------CycleFileDifferences-----------------------------//
				
			System.out.println("Differences from Cycle file");
				
			List <WebElement> cycleLineTrNumber= thdbody.findElements(By.xpath("//tr[@class='u2d_x_add']"));
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
						System.out.print(cs);
					}
					String cString = cycleString.toString();
					this.cycleDifferences.add(cString);
				}
				System.out.println("");
			}

		}
	
	public void baseLineFileDifferences(){
		//----------------------------------BaseLineFileDifferences----------------------------------//
    	 
		for (WebElement eachBaseTrNumber:baseLineTrNumber)
	    {
			List<WebElement> tdTagsinBaseTr= eachBaseTrNumber.findElements(By.tagName("td"));
			for (WebElement tdTaginBaseTr: tdTagsinBaseTr)
			{
				
				List<WebElement> spanElements=tdTaginBaseTr.findElements(By.tagName("span"));
				List<String> spanText= new ArrayList<String>();
				
				for (WebElement span:spanElements)
				{
					String difference= span.getText();
					spanText.add(difference);
				}
				
				//int var=spanText.size();
				StringBuilder strng= new StringBuilder();
				for (String s: spanText)
				{
					strng.append(s);
					System.out.print(s);
				}
				String bString = strng.toString();
				this.baseDifferences.add(bString);
			}
			System.out.println("");
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
