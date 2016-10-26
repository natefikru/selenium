package selenium;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ScreenShot {
	public static void main(String[]args) throws IOException
	{
		WebDriver thd= new FirefoxDriver();
		thd.get("C:\\Users\\a70985\\Desktop\\Jagadeesh\\secondSample.html");
		WebElement thdBody=thd.findElement(By.xpath("//tbody[@class= 'u2d_tbody']"));

		
		List <WebElement>  baseLineTrs=  thdBody.findElements(By.xpath("//tr[@class='u2d_x_del']"));
		//int tr=baseLineTrs.size();
		for (WebElement baseLineTr: baseLineTrs )
		{
			WebElement td_code=baseLineTr.findElement(By.xpath("//td[@class='u2d_code']"));
			File screenShot= ((TakesScreenshot)thd).getScreenshotAs(OutputType.FILE);
			BufferedImage fullImage= ImageIO.read(screenShot);
			org.openqa.selenium.Point point= td_code.getLocation();
			int elewidth=td_code.getSize().getWidth();
			int eleheight=td_code.getSize().getHeight();
			BufferedImage eleScreenshot= fullImage.getSubimage(point.getX(), point.getY(), elewidth, eleheight);
			ImageIO.write(eleScreenshot,"png", screenShot );
			File screenshotLocation=new File("C:\\Users\\a70985\\Desktop\\Jagadeesh\\screen.png");
			FileUtils.copyFile(screenShot,screenshotLocation);
			//System.out.println("screenshot taken");
			
			
			
		}
	}

}
