package sanjeevani.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import sanjeevani.dbutil.DBConnection;
import sanjeevani.pojo.EmpPojo;

public class EmployeeDao {

    private static PreparedStatement ps, ps1, ps2, ps3;
    private static Statement st, st1,st2,st3,st4,st5;

    static {
        try {
            st = DBConnection.getConnection().createStatement();
            st1 = DBConnection.getConnection().createStatement();
            st2 = DBConnection.getConnection().createStatement();   
            st3 = DBConnection.getConnection().createStatement();
            st4 = DBConnection.getConnection().createStatement();
            st5 = DBConnection.getConnection().createStatement();
          
            ps = DBConnection.getConnection().prepareStatement("INSERT INTO EMPLOYEES VALUES (?,?,?,?)");
            //ps1 = DBConnection.getConnection().prepareStatement("SELECT * FROM EMPLOYEES WHERE EMPID=?");
            ps2 = DBConnection.getConnection().prepareStatement("DELETE FROM EMPLOYEES WHERE EMPID=?");
            ps3 = DBConnection.getConnection().prepareStatement("UPDATE EMPLOYEES SET ENAME=?,ROLE=?,SAL=? WHERE EMPID=?");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
    public static HashMap<String,EmpPojo>getEmpListById()throws SQLException{
        ResultSet rs =st4.executeQuery("select EMPID,ENAME,SAL from EMPLOYEES");
        HashMap<String,EmpPojo> empListById =new HashMap<>();
        
        while(rs.next()){
            String id=rs.getString(1);
            String name =rs.getString(2);
            double sal=rs.getDouble(3);
            EmpPojo emp=new EmpPojo();
            emp.setEmpname(name);
            emp.setSal(sal);
            empListById.put(id,emp);
            
        }
        return empListById;
    }
    
    public static HashMap<String,String> getNonRegisteredReceptionist()throws SQLException{
        ResultSet rs =st3.executeQuery("select EMPID,ENAME from EMPLOYEES where ROLE='Receptionist' and EMPID not in (select EMPID from USERS where USERTYPE='Receptionist')");
        HashMap<String,String> receptionist =new HashMap<>();
        
        while(rs.next()){
            String id=rs.getString(1);
            String name =rs.getString(2);
            receptionist.put(id, name);
        }
        return receptionist;
    }

    public static ArrayList<String> getAllEmpId() throws SQLException {
        
        ResultSet rs = st2.executeQuery("select EMPID from EMPLOYEES ");
        ArrayList<String> employees = new ArrayList<>();
        while (rs.next()) {
            String empId = rs.getString(1);
            employees.add(empId);
        }
        return employees;
    }
    
    public static boolean updateEmployee(EmpPojo emp) throws SQLException {

        ps3.setString(1, emp.getEmpname());
        ps3.setString(2, emp.getJob());
        ps3.setDouble(3, emp.getSal());
        ps3.setString(4, emp.getEmpid());

        return (ps3.executeUpdate()!= 0);
    }

    public static boolean removeEmpDetailsById(String empId) throws SQLException {
        ps2.setString(1, empId);

        return (ps2.executeUpdate() != 0);
    }

    public static HashMap<String, String> getEmpDetailsById() throws SQLException {

        HashMap<String,String> employeesList = new HashMap<>();
        ResultSet rs = st5.executeQuery("SELECT EMPID,ENAME FROM EMPLOYEES");
        while (rs.next()) { 
            employeesList.put(rs.getString(1),rs.getString(2));
        }
        System.out.println("employeesList At DB:" + employeesList);
        return employeesList;
    }

    public static String getNewEmpId() throws SQLException {
        ResultSet rs = st.executeQuery("select max(EMPID) from EMPLOYEES");
        if (rs.next()) {
            String empid = rs.getString(1);
            int eno = Integer.parseInt(empid.substring(1));
            return "E" + (eno + 1);
        } else {
            return "E101";
        }
    }

    public static ArrayList<EmpPojo> getAllData() throws SQLException {

        ResultSet rs = st1.executeQuery("select * from EMPLOYEES");
        ArrayList<EmpPojo> employeesList = new ArrayList<EmpPojo>();
        while (rs.next()) {
            EmpPojo emp = new EmpPojo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
            employeesList.add(emp);
        }
        return employeesList;
    }

    public static boolean addEmployee(EmpPojo emp) throws SQLException {
        ps.setString(1, emp.getEmpid());
        ps.setString(2, emp.getEmpname());
        ps.setString(3, emp.getJob());
        ps.setDouble(4, emp.getSal());

        return (ps.executeUpdate() != 0);

    }

}
