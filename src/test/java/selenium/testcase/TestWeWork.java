package selenium.testcase;


import org.junit.AfterClass;
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
       //数据清理
//        String phone="18718760789";
//        homePage.toContact().delete(phone);
   }

    @Test
    public void testAdd(){
        String phone="18718760789";
        homePage.toMemberAdd().add(phone,phone,phone);
    }

    @Test
    public void testDelete(){

        String phone="18818760789";
        homePage.toMemberAdd().add(phone,phone,phone).delete(phone);
    }
    @Test
    public void deleteCurrentPage() throws InterruptedException {
        homePage.toContact().deleteCurrentPage();
    }
    @Test
    public void importFromFile(){
        homePage.toContact().importFromFile("/Users/zhaohan/Downloads/通讯录批量导入模板.xlsx");
    }

    @AfterClass
    public static void afterAll() throws InterruptedException {
        homePage.quit();
    }
}
