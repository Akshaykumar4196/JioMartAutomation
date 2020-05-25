package testScripts.search;

import org.testng.annotations.Test;
import pages.SearchPage;
import pages.SignInPage;
import testScripts.BaseTest;

public class SEA_TC_02 extends BaseTest {


    @Test
    public void SEA_TC_02(){

        SignInPage sin = new SignInPage(driver);
        sin.signIn("SGN_TC_02");
        SearchPage sep = new SearchPage(driver);
        sep.searchProduct("SER_TC_01");
        sep.listOfProducts();

    }



}
