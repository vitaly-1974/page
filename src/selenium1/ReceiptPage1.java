package selenium1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReceiptPage1 extends PageObject1 {

	@FindBy(tagName = "h1")
	private WebElement header;
	
	public ReceiptPage1(WebDriver driver) {
		super(driver);
	}

	public boolean isInitialized() {
		return header.isDisplayed();
	}

	public String confirmationHeader(){
		return header.getText();
	}

}