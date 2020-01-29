package com.dpgv1.trackme;

import com.dpgv1.trackme.BLL.LoginBLL;

import org.junit.Test;

public class LoginTest {
    @Test
    public void testLogin(){
        LoginBLL loginBLL=new LoginBLL("dpgaire","123");
        boolean result=loginBLL.chekUser();
        assertEquals()


    }

}
