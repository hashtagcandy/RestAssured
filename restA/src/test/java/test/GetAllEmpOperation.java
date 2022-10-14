package test;

import api.GetAllEmp;
import api.GetEmp;
import api.PostLogin;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.UserLogin;
import testdata.employeeDetails;

public class GetAllEmpOperation {
    public String triggerToken()
    {
        UserLogin loginPostRequestPayload=new UserLogin();
        loginPostRequestPayload.setEmail("soumadeep.roy@gds.ey.com");
        loginPostRequestPayload.setPassword("12345678");

        Response postResponse= PostLogin.postApiCall(loginPostRequestPayload,"/login");



        JsonPath jsonPathEvaluator = postResponse.jsonPath();
        String token = jsonPathEvaluator.getString("token");
        return token;
        //System.out.println("the access  token " + jsonPathEvaluator.get("token"));

    }
    @Test
    public void triggerGetAllEmp() {


        Response EmployeeResponse = GetAllEmp.getAllEmpcall("/employees");

    }

}
