package testScripts.signIn;

import org.testng.annotations.Test;
import pages.SignInPage;
import testScripts.BaseTest;

public class SGN_TC_01  extends BaseTest {


    @Test
    public void SGN_TC_01(){

        SignInPage sin = new SignInPage(driver);
        sin.signIn("SGN_TC_01");

    }



}
