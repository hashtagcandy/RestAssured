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
        addEmpdetails.setFirstName("xyz");
        addEmpdetails.setLastName("");
        addEmpdetails.setDesignation("");
        addEmpAddress.setCountry("");
        addEmpAddress.setState("");
        addEmpAddress.setDistrict("");
        addEmpAddress.setPincode(2112);
        addEmpdetails.setYearsOfExperience(12);
        addEmpdetails.setAddress(addEmpAddress);

        Response EmployeeResponse= AddEmp.addEmpcall(addEmpdetails,"/employees");


    }

}