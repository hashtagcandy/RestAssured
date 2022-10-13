package test;

import api.PostLogin;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.UserLogin;

public class LoginPostOperation {

    @Test
    public void triggerLoginPost()
    {
        UserLogin loginPostRequestPayload=new UserLogin();
        loginPostRequestPayload.setEmail("soumadeep.roy@gds.ey.com");
        loginPostRequestPayload.setPassword("12345678");

        Response postResponse= PostLogin.postApiCall(loginPostRequestPayload,"/login");

    }

}