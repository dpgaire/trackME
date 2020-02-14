package com.dpgv1.trackme;

import com.dpgv1.trackme.BLL.LoginBll;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LoginTest {
    @Test
    public void testLogin(){
        LoginBll loginBLL=new LoginBll();
        boolean result=loginBLL.checkUser("dpgaire123","dpgaire");
        assertEquals(true, result);


    }


}
