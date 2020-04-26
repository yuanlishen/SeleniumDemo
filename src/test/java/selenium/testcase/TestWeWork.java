package selenium.testcase;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.page.HomePage;

import java.util.concurrent.TimeUnit;

public class TestWeWork {

    public static HomePage homePage;
    @BeforeClass
    public static void beforeAll(){
       homePage = new HomePage();
       homePage.LoginWithCookid();
   }

    @Test
    public void TestStart(){

        String phone="18718760789";
        homePage.toMemberAdd().add(phone,phone,phone);
    }
}
