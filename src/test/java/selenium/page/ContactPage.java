package selenium.page;

import org.openqa.selenium.By;

public class ContactPage extends BasePage{
    //添加成员
    public ContactPage add(String username,String id,String phone){
        //由于继承BasePase，所以直接findelement就可以了
        findElement(By.name("username")).sendKeys(username);
        findElement(By.name("acctid")).sendKeys(id);
        findElement(By.name("mobile")).sendKeys(phone);
        findElement(By.linkText("保存")).click();
        return this;
    }

    //搜索用户，并删除用户
    public ContactPage delete(String keyword){
        //首先清空一下编辑框
        findElement(By.id("memberSearchInput")).clear();
        findElement(By.id("memberSearchInput")).sendKeys(keyword);
        //没找到的情况下，抛一下异常
        try{
//            waitClickable(By.id("clearMemberSearchInput"));
//            waitClickable(By.linkText("删除"));
            waitClickable(By.linkText("编辑"));
        }catch (Exception e){
            System.out.println("not found");
            return this;
        }
        findElement(By.linkText("删除")).click();
        findElement(By.linkText("确认")).click();
//        findElement(By.id("clearMemberSearchInput")).click();
        return this;
    }

    //成员列表
    public ContactPage toMemberAdd(){
        return new ContactPage();
    }
}
