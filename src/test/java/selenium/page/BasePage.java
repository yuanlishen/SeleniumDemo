package selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    //创建driver对象
    public static WebDriver driver;

    //使用父类写一个find方法；
    public WebElement findElement(By by){
        return findElement(by,5);
    }
//    特殊情况不需要等待元素，比如上传文件,出现这种情况的时候，我们需要显示等待它的内容
    public WebElement findElement(By by,int timeout){
        //添加日志，查看在点击哪一步报的错
        System.out.println(by);
        if (timeout>0){
            waitClickable(by,timeout);
            //日志
            System.out.println("clickable");
        }
        return HomePage.driver.findElement(by);
    }

    //等待元素可以被点击
    public void waitClickable(By by,int timeout){
        new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(by));
    }
    public void waitClickable(By by){
        //等待元素出现
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(by));
        //等待元素可以被点击
        new WebDriverWait(driver,5).until(ExpectedConditions.elementToBeClickable(by));
    }

    public void quit() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
