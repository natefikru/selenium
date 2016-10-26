package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Sample {

	public static void main(String[] args) {
		
		
		
			try{
				
				// open the firefox browser
			WebDriver driver= new FirefoxDriver();
			  
			driver.get("C:\\Users\\a70985\\Desktop\\Jagadeesh\\TEST.html");
			// identify any header element
			driver.findElement(By.xpath("//tr[@class='u2d_h_x']"));
			System.out.println("Successfully identified header element");
			// get the total number of changes
			String changes=  driver.findElement(By.xpath("//td[@colspan='3']")).getText();
			System.out.println("Total number of changes"+" ="+ changes);
			// get the html body as driver
			WebElement body=driver.findElement(By.xpath("//tbody[@class= 'u2d_tbody']"));
			//get the size of total tr tags in the html document
			int lineCount= body.findElements(By.tagName("tr")).size();
			System.out.println(lineCount);
			// get the number of total baselines in the html
			int baseLine =	body.findElements(By.xpath("//tr[@class='u2d_x_del']")).size();
			System.out.println("got the size of baseline tr elements");
		    List<WebElement> trTag =body.findElements(By.xpath("//tr[@class='u2d_x_del']"));
		    List<WebElement> trTagCycle = body.findElements(By.xpath("//tr[@class='u2d_x_del']"));
		    System.out.println("saved the tr tags into webElement list");
		    try{
		    for (WebElement we:trTag)
		    {
		    	List<WebElement> tdTags =  	we.findElements(By.tagName("td"));
		    	for (WebElement wetd:tdTags)
		    	{
		    		try
		    		{
		     		String tdTag=wetd.getAttribute("class");
		    		if(tdTag=="u2d_code")
		    		{
		    			
		    			if(	wetd.findElements(By.tagName("span")).size()!=0)
		    			{
		    				List <WebElement> spanElements= wetd.findElements(By.tagName("span"));
		    				
		    			//bElement SpanBaseLine= wetd
		    				for(WebElement spanBaseLine:spanElements)
		    				{
		    					String BaseLineError=spanBaseLine.getText();
		    					System.out.println(BaseLineError);
		    				}
		    			}
		    			else
		    				continue;
		    			
		    			
		    		}
		    		}
		    		catch (Exception e)
		    		{
		    			System.out.println("the tag is not u2d_code");
		    		}
		    		System.out.println(tdTags);
		    		String text=wetd.getText();
		    		System.out.println(text);
		    		
		    		
		    	}
		    			    		
		    }
		    for(WebElement weCycle:trTagCycle)
		    {
		    	List<WebElement>  tdTagCycle= weCycle.findElements(By.tagName("td"));
		    	for  (WebElement cycleTd:tdTagCycle)
		    	{
		    		String tdCycle= cycleTd.getAttribute("class");
		    		System.out.println(tdCycle);
		    		String tdCycleText =cycleTd.getText();
		    		System.out.println(tdCycleText);
		    	}
		    }
			System.out.println("Base Lines" + baseLine);
		    }
		    catch(Exception e)
		    {
		    	System.out.println("Problem in ther for loop");
		    }
			
			
		
			int cycleLine=body.findElements(By.xpath("//tr[@class='u2d_x_add']")).size();
			System.out.println("Number of lines in Cycle quote = "+ cycleLine);
		//		driver.close();
			
			} catch(Exception e)
			{
				System.out.println("Go through the script and make corrections");
				
			}
			
		 
		

	}

}
