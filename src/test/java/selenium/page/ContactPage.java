package selenium.page;

import org.openqa.selenium.By;

public class ContactPage extends BasePage{
    //添加成员
    public ContactPage add(String username,String id,String phone){
//        HomePage.driver.findElement(By.name("username")).sendKeys(username);
//        HomePage.driver.findElement(By.name("acctid")).sendKeys(id);
//        HomePage.driver.findElement(By.name("mobile")).sendKeys(phone);
//        HomePage.driver.findElement(By.linkText("保存")).click();
        //由于继承BasePase，所以直接findelement就可以了
        findElement(By.name("username")).sendKeys(username);
        findElement(By.name("acctid")).sendKeys(id);
        findElement(By.name("mobile")).sendKeys(phone);
        findElement(By.linkText("保存")).click();
        return this;
    }

    //成员列表
    public ContactPage toMemberAdd(){
        return new ContactPage();
    }
}
