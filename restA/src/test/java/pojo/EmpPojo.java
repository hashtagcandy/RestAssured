package  pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmpPojo {
    @JsonProperty
    public String firstName;
    @JsonProperty
    public String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public EmpAddress getAddress() {
        return address;
    }

    public void setAddress(EmpAddress address) {
        this.address = address;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
    @JsonProperty
    public String designation;
    @JsonProperty
    public EmpAddress address;
    @JsonProperty
    public int yearsOfExperience;
}