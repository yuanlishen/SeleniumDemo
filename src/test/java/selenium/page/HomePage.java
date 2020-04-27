package selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage{


    public HomePage LoginWithCookid(){
        String url="https://work.weixin.qq.com";
        driver = new ChromeDriver();
        //隐式等待
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        driver.findElement(By.linkText("企业登录")).click();
        //获取登录后的cookie
        System.out.println(driver.manage().getCookies());
        //使用selenium里的api可以直接操作cookie
        driver.manage().addCookie(new Cookie("wwrtx.refid", "362258521979134"));
        driver.manage().addCookie(new Cookie("wwrtx.sid", "EXDSKwfUnOa-MriysMelJgvdzGKjTLGOFBfrWSZP_e8uWSnqiNFksQ3FtutbixIG"));
        //刷新当前页面 navigate：可以做导航，可以前进可以后退可以刷新.
        driver.navigate().refresh();
        return this;
    }

    //通讯录
    public ContactPage toContact(){
        findElement(By.linkText("通讯录")).click();
        return new ContactPage();
    }

    //添加成员
    public ContactPage toMemberAdd(){
        //隐式等待
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try{
//            waitClickable(By.id("clearMemberSearchInput"));
//            waitClickable(By.linkText("删除"));
            waitClickable(By.linkText("添加成员"));
        }catch (Exception e){
            System.out.println("not found");
        }
        findElement(By.linkText("添加成员")).click();
        return new ContactPage();
    }

    //通讯录添加成员
}
