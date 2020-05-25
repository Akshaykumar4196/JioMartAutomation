package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.JavaUtils;

import java.util.HashMap;

public class SignInPage extends BasePage{


    public SignInPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

// Object repo

    @FindBy(xpath = "//a[text()=' Sign In ']")
    protected WebElement signInLink;

    @FindBy(css = "#loginfirst_mobileno")
    protected  WebElement mobileNumberTextField;

    @FindBy(xpath = "//button[text()='USE OTP']")
    protected WebElement useOtpButton;

    @FindBy(xpath = "//div[text()='Please enter valid Mobile Number!']")
    protected WebElement errorMsgForInValidMobNumber;

    @FindBy(id = "reg_email")
    protected WebElement emailField;

    @FindBy(id = "reg_firstname")
    protected WebElement firstNameTxtField;

    @FindBy(id = "reg_lastname")
    protected WebElement lastnameTxtField;

    @FindBy(id = "register_pwd")
    protected WebElement regPassword;

    @FindBy(id = "register_confirm_pwd")
    protected WebElement confirmRegPassword;

    @FindBy(xpath = "//button[text()='verify']")
    protected WebElement verifyButton;


    @FindBy(xpath = "(//span[text()='×'])[2]")
    protected WebElement closePincodeWindow;

// Business Logic

    HashMap<String,String> sp;

    public void signIn(String uniqueValue) {
        sp = JavaUtils.readExcelData("SignIn",uniqueValue);
        genricWait(3);
        try{
            jsClick(driver,closePincodeWindow);

        } catch (Exception e){

            System.out.println("Delivery pin did not appear!");
        }

        signInLink.click();
        genricWait(2);
        mobileNumberTextField.sendKeys(sp.get("MOBILE"));
        jsClick(driver,useOtpButton);
        genricWait(2);
        emailField.sendKeys(generateEmail());
        firstNameTxtField.sendKeys(sp.get("FIRSTNAME"));
        lastnameTxtField.sendKeys(sp.get("LASTNAME"));
        regPassword.sendKeys(sp.get("PASSWORD"));
        confirmRegPassword.sendKeys(sp.get("CONFIRMPASSWORD"));
        genricWait(3);
        setOpt(generatePin());
        genricWait(4);
        verifyButton.click();
        genricWait(4);
    }

// 5432345 = 0,1,2,3,4,5
    public void setOpt(String otp){
        for(int i=0; i<otp.length();i++){
            char pin = otp.charAt(i);
            String finalPin = Character.toString(pin);
            int x = i+1;
            driver.findElement(By.xpath("//div[@class='otp-inputrow']/input["+x+"]")).sendKeys(finalPin);
            genricWait(2);
        }
    }









}
