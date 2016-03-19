package pe.edu.utp.jsfdataintegration.model;

import javax.faces.bean.ManagedBean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PT116-ORACLE on 19/03/2016.
 */

@ManagedBean(name = "employeeEntityBean", eager = true)

public class EmployeeEntity {
    private Connection connection;

    public void setConnection(Connection connection){
        this.connection = connection;
    }

    public List<Employee> getEmployees(){
        String sql = "SELECT * FROM employees ORDER BY first_name ASC";
        List<Employee> list = new ArrayList<>();

        if(connection == null){
            return null;
        }

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs == null){
                return null;
            }
            while(rs.next()){
                Employee empl = new Employee();
                empl.setFirstName(rs.getString("first_name"));
                empl.setLastName(rs.getString("last_name"));
                list.add(empl);
            }
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public int getEmployeesCount(){
        return (this.getEmployees() == null) ? 0 : this.getEmployees().size();
    }

}
