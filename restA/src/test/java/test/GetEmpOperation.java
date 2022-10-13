package test;

import api.AddEmp;
import api.DelEmp;
import api.GetEmp;
import api.PostLogin;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.UserLogin;
import testdata.employeeDetails;

public class GetEmpOperation {

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
    public void triggerGetEmp() {
        employeeDetails empidobj = new employeeDetails();

        Response EmployeeResponse = GetEmp.getEmpcall("/employees/"+empidobj.triggerEmpId()+"");
    }

    @Test
    public void triggerGetEmpNegEmpId(){
        Response EmployeeResponse = GetEmp.getNegEmpIdcall("/employees/EMP327000223");
    }

    @Test
    public void triggerGetEmpNegToken(){
        Response EmployeeResponse = GetEmp.getNegEmpTokencall("/employees/EMP327000223");

    }
}
