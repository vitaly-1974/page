package selenium1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject1 {
	protected WebDriver driver;
	
	public PageObject1(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}