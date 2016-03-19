package pe.edu.utp.jsfdataintegration.model;

import javax.faces.bean.ManagedBean;

/**
 * Created by PT116-ORACLE on 19/03/2016.
 */

@ManagedBean(name = "employeeBean", eager = true)
public class Employee {
    private String firstName;
    private String lastName;

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

    public String getFullName(){
        return getFirstName() + " " + getLastName();
    }
}
