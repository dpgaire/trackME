package com.dpgv1.trackme;

import com.dpgv1.trackme.BLL.LoginBll;
import com.dpgv1.trackme.BLL.RegisterBll;
import com.dpgv1.trackme.model.User;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LoginTest {
    @Test
    public void testLogin(){
        LoginBll loginBLL=new LoginBll();
        boolean result=loginBLL.checkUser("dpgaire123","dpgaire");
        assertEquals(true, result);

    }

    @Test
    public void testRegister(){
        RegisterBll registerBll=new RegisterBll();
        User user = new User( "12345","sss","aa0","cccccc","123" );
        boolean result=registerBll.RegisterBll(user);
        assertEquals(true, result);

    }


}
