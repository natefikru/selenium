package selenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SeleniumMain {
	
	List<String> cycleDifferences = new ArrayList<String>();
	List<String> baseDifferences = new ArrayList<String>();
	

	public static void main(String[] args) {
		WebDriver thd= new FirefoxDriver();
		thd.get("C:\\Users\\a69753\\Documents\\secondSample.html");
		WebElement thdbody=	thd.findElement(By.xpath("//tbody[@class= 'u2d_tbody']"));
		List<WebElement> baseLineTrNumber= thdbody.findElements(By.xpath("//tr[@class='u2d_x_del']"));
		
		SeleniumExtractor se = new SeleniumExtractor();
		
		se.baseLineFileDifferences(baseLineTrNumber);
		se.cycleFileDifferences(thdbody);
	}
		

	
}
		
	


