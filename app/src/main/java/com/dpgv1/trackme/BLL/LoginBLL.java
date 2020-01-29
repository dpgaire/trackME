package com.dpgv1.trackme.BLL;

//public class LoginBLL {
//    Boolean  isSucess=false;
//    public boolean chekUser(String username,String password){
//
//        Login login=new Login(username,password);
//        UserAPI userapi= Url.getInstance().create(UserAPI.class);
//
//        Call<LoginSignUpResponse> usersCall = userapi.registerUser();
//
//        try {
//            Response<LoginSignUpResponse> loginResponse = usersCall.execute();
//            if (loginResponse.isSuccessful() &&
//                    loginResponse.body().getStatus().equals("Login success!")) {
//
//                Url.token += loginResponse.body().getToken();
//                // Url.Cookie = imageResponseResponse.headers().get("Set-Cookie");
//                isSuccess = true;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return isSuccess;
//    }
//    }
//}
