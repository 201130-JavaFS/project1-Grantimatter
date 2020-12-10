package com.revature.ers.servlet.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class Cookies {
    public static String getCookie(HttpServletRequest req, String cookieName){
        for (Cookie c:req.getCookies()){
            if(c.getName().equalsIgnoreCase(cookieName)){
                return c.getValue();
            }
        }
        return " ";
    }
}
