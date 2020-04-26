package selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    //创建driver对象
    public static WebDriver driver;

    //使用父类写一个find方法；
    public WebElement findElement(By by){
        return HomePage.driver.findElement(by);
    }
}
