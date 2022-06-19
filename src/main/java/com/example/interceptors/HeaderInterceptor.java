package com.example.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;


public class HeaderInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       // response.addHeader("test","header test");

        String value=request.getHeader("Authorization");
        response.setHeader("WWW-Authenticate", "Basic");
        if (value == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        if (!value.startsWith("Basic ")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        String username = "", password = "";
        try {
            String base64EncodedCred = value.split(" ")[1];
            String decodedCreds = new String(Base64.getDecoder().decode(base64EncodedCred));
            username = decodedCreds.split(":")[0];
            password = decodedCreds.split(":")[1];
        } catch (Exception ex) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        if(!username.equals("zeynep") || !password.equals("12345")){
           response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
           return false; // controllere ulasma
        }else{
            return true; // controllere ulas

        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
