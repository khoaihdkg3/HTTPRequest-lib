/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FacebookRequest;
/**
 *
 * @author Administrator
 */
public class FacebookAccount {
    private String Dtsh;
    private String Cookie;
    public String getDTSH(){
        return Dtsh;
    }
    public void setDTSH(String Dtsh){
        this.Dtsh = Dtsh;
    }
    public String getCookie(){
        return Cookie;
    }
    public void setCookie(String Cookie){
        this.Cookie = Cookie;
    }
}
