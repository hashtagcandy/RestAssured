package test;

import api.PostLogin;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.UserLogin;

public class LoginPostOperation {
    UserLogin loginPostRequestPayload=new UserLogin();


    @Test
    public void triggerLogin()
    {

        loginPostRequestPayload.setEmail("soumadeep.roy@gds.ey.com");
        loginPostRequestPayload.setPassword("12345678");

        Response postResponse= PostLogin.postApiCall(loginPostRequestPayload,"/login");


    }


    @Test
    public void triggerNegEmailLogin(){
        loginPostRequestPayload.setEmail("invalid@gds.ey.com");
        loginPostRequestPayload.setPassword("12345678");

        Response postResponse= PostLogin.negPostApiCall(loginPostRequestPayload,"/login");


    }

    @Test
    public void triggerNegPassLogin(){
        loginPostRequestPayload.setEmail("soumadeep.roy@gds.ey.com");
        loginPostRequestPayload.setPassword("invalid");

        Response postResponse= PostLogin.negPostApiCall(loginPostRequestPayload,"/login");

    }

}

