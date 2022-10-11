package bodypojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class bdy {
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @JsonProperty("email")
    private String email;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @JsonProperty("password")
    private String password;
}

