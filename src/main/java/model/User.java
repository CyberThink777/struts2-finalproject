package model;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "users")
public class User implements Serializable {

    @Id
    private String username;

    @Column(name = "password")
    private String pass;

    @RequiredStringValidator(key = "error.required", messageParams = "getText('user.username')")
    @StringLengthFieldValidator(maxLength = "32", key = "error.length", messageParams = "getText('user.username')")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @RequiredStringValidator(key = "error.required", messageParams = "getText('user.pass')")
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return username;
    }
}
