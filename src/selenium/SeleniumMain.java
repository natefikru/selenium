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
		
		SeleniumExtractor se = new SeleniumExtractor();
		
		se.baseLineFileDifferences();
		se.cycleFileDifferences();
		se.printStringList();
	}
		

	
}
		
	


