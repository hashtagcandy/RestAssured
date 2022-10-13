package test;



import api.AddEmp;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.EmpAddress;
import pojo.EmpPojo;

public class AddEmpOperation {

    @Test
    public void triggerAddEmp()
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

        Response EmployeeResponse= AddEmp.addEmpcall(addEmpdetails,"/employees");


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