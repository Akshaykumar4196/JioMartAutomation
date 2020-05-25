package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utils.JavaUtils;

import java.security.Key;
import java.util.HashMap;
import java.util.List;

public class SearchPage extends BasePage {


    public SearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "(//input[@class='ais-SearchBox-input'])[1]")
    protected WebElement searchTextBox;

    @FindAll({
            @FindBy(xpath="//div[@class='ais-InfiniteHits']/div/ol/li")
    })
    protected List<WebElement> products;




    HashMap<String,String> secp;

    public void searchProduct(String unique){

        secp = JavaUtils.readExcelData("Search",unique);
        searchTextBox.sendKeys(secp.get("PRODUCT"), Keys.ENTER);

    }

    public void listOfProducts(){
        for(WebElement ele : products){
            System.out.println(ele.getText());
        }
    }

}
