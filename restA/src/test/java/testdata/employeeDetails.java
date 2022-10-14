package testdata;

import api.AddEmp;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojo.EmpAddress;
import pojo.EmpPojo;

public class employeeDetails {
    public String triggerEmpId()
    {
        EmpPojo addEmpdetails = new EmpPojo();
        EmpAddress addEmpAddress  = new EmpAddress();
        addEmpdetails.setFirstName("Srabon");
        addEmpdetails.setLastName("Das");
        addEmpdetails.setDesignation("QE");
        addEmpAddress.setCountry("India");
        addEmpAddress.setState("West Bengal");
        addEmpAddress.setDistrict("Kolkata");
        addEmpAddress.setPincode(700034);
        addEmpdetails.setYearsOfExperience(5);
        addEmpdetails.setAddress(addEmpAddress);

        Response EmployeeResponse= AddEmp.addEmpcall(addEmpdetails,"/employees");
        JsonPath jsonPathEvaluator = EmployeeResponse.jsonPath();
        String empId = jsonPathEvaluator.getString("employeeId");
        return empId;

    }
}
