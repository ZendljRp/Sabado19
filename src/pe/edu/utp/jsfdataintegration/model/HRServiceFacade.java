package pe.edu.utp.jsfdataintegration.model;

import javax.sql.DataSource;
import javax.faces.bean.ManagedBean;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by PT116-ORACLE on 19/03/2016.
 */

@ManagedBean(name = "hrServiceFacadeBean", eager = true)
public class HRServiceFacade {
    private Connection connection;

    public Connection getConnection(){
        return connection;
    }

    public void setConnection(Connection connection){
        this.connection = connection;
    }

    public HRServiceFacade(){
        try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("jdbc/MySQLDataSource");
            connection = ds.getConnection();
        }catch (NamingException | SQLException e){
            e.printStackTrace();
        }
    }

    public EmployeeEntity getEmployeesEntity(){
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setConnection(this.connection);
        return employeeEntity;
    }


}
