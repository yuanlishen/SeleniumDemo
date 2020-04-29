package selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ContactPage extends BasePage{
    //添加成员
    public ContactPage add(String username,String id,String phone){
        //由于继承BasePage，所以直接findelement就可以了
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
            waitClickable(By.linkText("编辑"),3);
        }catch (Exception e){
            System.out.println("not found");
            return this;
        }
        findElement(By.linkText("删除")).click();
        findElement(By.linkText("确认")).click();
//        findElement(By.id("clearMemberSearchInput")).click();
        return this;
    }
    //通讯录页，删除一页成员
    public ContactPage deleteCurrentPage(){
        //第一种方法，直接点击全选复选框
//        findElement(By.cssSelector(".ww_checkbox")).click();
        //逐个勾选
        waitClickable(By.cssSelector(".ww_checkbox"));
        List<WebElement> elements = driver.findElements(By.cssSelector(".ww_checkbox"));
        for(int i=1;i<elements.size();i++){
            System.out.println(i);
            elements.get(i).click();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //点击删除
//        Thread.sleep(5000);

        findElement(By.linkText("删除")).click();
        findElement(By.linkText("确认")).click();
        return this;
    }


    //上传文件
    public void importFromFile(String path){
        findElement(By.partialLinkText("批量导入/导出")).click();
        findElement(By.linkText("文件导入")).click();
        //0：表示不做任何等待，找到它就可以，直到可以被点击；
        findElement(By.id("js_upload_file_input"),0).sendKeys(path);
        findElement(By.id("submit_csv")).click();;
        findElement(By.linkText("完成")).click();
    }
    //成员列表
    public ContactPage toMemberAdd(){
        return new ContactPage();
    }
}
