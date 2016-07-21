/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FacebookRequest;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import java.io.IOException;
import java.util.Set;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
/**
 *
 * @author Administrator
 */
public class Facebook {
    private static Pattern FBID_Pattern =  Pattern.compile("(?:a\\.|fbid=|\\/)(\\S\\d*)(?:\\/|&|\\.|[\\r\\n]|$)");
    
    
    public boolean posts_reaction(FacebookAccount myFacebook, String type_reaction){
        
        return true;
    }
    public boolean posts_comment(FacebookAccount myFacebook, String type_reaction){
        
        return true;
    }
    public boolean page_liker(FacebookAccount myFacebook, String type_reaction){
        
        return true;
    }
    public boolean friend_adder(FacebookAccount myFacebook, String type_reaction){
        
        return true;
    }
    public boolean friend_follower(FacebookAccount myFacebook, String type_reaction){
        
        return true;
    }
    public FacebookAccount login(String u, String p) throws IOException{
        FacebookAccount myFacebook = new FacebookAccount();
        WebDriver driver = new HtmlUnitDriver(BrowserVersion.CHROME,true);
        driver.get("https://m.facebook.com/");
        driver.findElement(By.name("email")).sendKeys(u);
        driver.findElement(By.name("pass")).sendKeys(p);
        driver.findElement(By.name("login")).click();
        String HTMLSource = driver.getPageSource();
        Set<Cookie> cookies = driver.manage().getCookies();
        driver.close();

        Document doc = Jsoup.parse(HTMLSource);
        Elements doc_inputs = doc.select("input[name=fb_dtsg]");
        Pattern DTSG_Pattern = Pattern.compile("(\\w{12}\\:\\w{12})");
        if(doc_inputs.isEmpty()) return null;
        String DTSG = doc_inputs.first().attr("value");
        if(!DTSG_Pattern.matcher(DTSG).find()) return null;
        myFacebook.setDTSH(DTSG);
        
        String myCookie = "";
        for(Cookie cookie : cookies)
            myCookie = myCookie + cookie.getName() + "=" + cookie.getValue() + "; ";
        myFacebook.setCookie(myCookie);
        
        //System.out.println(myFacebook.getCookie()+"\n"+myFacebook.getDTSH());
        return myFacebook;
    }
    public static ArrayList<String> getFBIDfromList(String list){
        Matcher FBID_Matcher = FBID_Pattern.matcher(list);
        ArrayList<String> result = new ArrayList<String>();
        String FBID;
        while(FBID_Matcher.find()){
            FBID = FBID_Matcher.group(1);
            if(!FBID.equals("a"))
                result.add(FBID_Matcher.group(1));
        }
        return result;
    }
    
    public static void main(String[] args) {
        Facebook facebook = new Facebook();
        

            System.out.println(1&25);
            System.out.println(2&25);
            System.out.println(3&25);
            System.out.println(4&25);
            System.out.println(5&25);
            
            //System.out.println(facebook.login("eadqeqweq@yahoo.com","87vinh9218"));
            //System.out.println(facebook.login("0948925763","KHOaihdkg3"));

        
    }
}
