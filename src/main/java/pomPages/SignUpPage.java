package pomPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
  //Declaration
  @FindBy(id="First Name")
  private WebElement firstNameTF;
  @FindBy(id="Last Name")
  private WebElement lastNameTF;
  @FindBy(xpath="//div[@id='Gender']/decendant::label/span[2]")
  private List<WebElement> genderRadioButton;
  @FindBy(id="Phone Number")
  private WebElement phoneNumberTf;
  @FindBy(id="Email Address")
  private WebElement emailAddressTf;
  @FindBy(id="Password")
  private WebElement passwordTF;
  @FindBy(id="Confirm Password")
  private WebElement confirmPasswordTF;
  @FindBy(id="terms and Conditions")
  private WebElement termsAndConditionsCB;
  @FindBy(id="Register")
  private WebElement registerButton;
  
  //initialization
  public SignUpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
}
  //utilization
  public void createUserAccount(String firstName,String lastName, String expectedGender, CharSequence phonenumber, String email, String password) {
	  firstNameTF.sendKeys(firstName);
	  lastNameTF.sendKeys(lastName);
	  
	  for(WebElement element: genderRadioButton) {
		  String gender=element.getText();
		  if(gender.equals(expectedGender)) {
			  element.click();
			  break;
		  }
	  }
	  phoneNumberTf.sendKeys(phonenumber);
	  emailAddressTf.sendKeys(email);
	  passwordTF.sendKeys(password);
	  confirmPasswordTF.sendKeys(password);
	  termsAndConditionsCB.click();
	  registerButton.click();
	  
  }
  }