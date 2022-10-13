package test;



import api.AddEmp;
import api.PostLogin;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pojo.EmpAddress;
import pojo.EmpPojo;
import pojo.UserLogin;

public class AddEmpOperation {

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
    public void triggerAddEmp()
    {
        EmpPojo addEmpdetails = new EmpPojo();
        EmpAddress addEmpAddress  = new EmpAddress();
        addEmpdetails.setFirstName("Hirok");
        addEmpdetails.setLastName("majumder");
        addEmpdetails.setDesignation("QE");
        addEmpAddress.setCountry("India");
        addEmpAddress.setState("West Bengal");
        addEmpAddress.setDistrict("Kolkata");
        addEmpAddress.setPincode(700034);
        addEmpdetails.setYearsOfExperience(5);
        addEmpdetails.setAddress(addEmpAddress);

        Response EmployeeResponse= AddEmp.addEmpcall(addEmpdetails,"/employees");
        JsonPath jsonPathEvaluator = EmployeeResponse.jsonPath();
        String token = jsonPathEvaluator.getString("employeeId");

    }


    @Test
    public void triggerAddEmpNegToken()
    {
        EmpPojo addEmpdetails = new EmpPojo();
        EmpAddress addEmpAddress  = new EmpAddress();
        addEmpdetails.setFirstName("JIKO");
        addEmpdetails.setLastName("SEN");
        addEmpdetails.setDesignation("QE");
        addEmpAddress.setCountry("India");
        addEmpAddress.setState("West Bengal");
        addEmpAddress.setDistrict("Kolkata");
        addEmpAddress.setPincode(700034);
        addEmpdetails.setYearsOfExperience(5);
        addEmpdetails.setAddress(addEmpAddress);

        Response EmployeeResponse= AddEmp.addNegTokenEmpcall(addEmpdetails,"/employees");



    }

}