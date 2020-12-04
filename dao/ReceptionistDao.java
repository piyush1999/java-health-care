package sanjeevani.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import sanjeevani.dbutil.DBConnection;
import sanjeevani.pojo.EmpPojo;
import sanjeevani.pojo.UserPojo;

public class ReceptionistDao {

    private static PreparedStatement ps, ps1, ps2;
    private static Statement st, st1, st2;

    static {
        try {
            st = DBConnection.getConnection().createStatement();
            st1 = DBConnection.getConnection().createStatement();
            st2 = DBConnection.getConnection().createStatement();

            ps = DBConnection.getConnection().prepareStatement("INSERT INTO USERS VALUES (?,?,?,?,?)");
            ps1 = DBConnection.getConnection().prepareStatement("DELETE FROM USERS WHERE USERID=?");
            ps2 = DBConnection.getConnection().prepareStatement("UPDATE EMPLOYEES,\n"
                    + "    USERS \n"
                    + "SET \n"
                    + "    EMPLOYEES.ENAME = ?,\n"
                    + "    EMPLOYEES.SAL = ?,\n"
                    + "    USERS.USERNAME = ?\n"
                    + "where \n"
                    + "    EMPLOYEES.EMPID=USERS.EMPID and EMPLOYEES.EMPID=?");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<EmpPojo> getAllReceptionist() throws SQLException {

        ResultSet rs = st1.executeQuery("select USERS.USERID,EMPLOYEES.ENAME,EMPLOYEES.EMPID,EMPLOYEES.SAL from EMPLOYEES inner Join USERS on EMPLOYEES.EMPID=USERS.EMPID where USERS.USERTYPE='Receptionist'");
        ArrayList<EmpPojo> employeesList = new ArrayList<>();
        while (rs.next()) {
            EmpPojo emp = new EmpPojo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
            employeesList.add(emp);
        }
        return employeesList;
    }

    public static boolean removeReceptionist(String receptionistId) throws SQLException {
        ps1.setString(1, receptionistId);
        return (ps1.executeUpdate() != 0);
    }

    public static ArrayList<String> getReceptionist() throws SQLException {
        ResultSet rs = st.executeQuery("SELECT USERID FROM USERS WHERE USERTYPE='Receptionist'");
        ArrayList<String> receptionistId = new ArrayList<>();
        while (rs.next()) {
            receptionistId.add(rs.getString(1));
        }
        return receptionistId;
    }

    public static boolean updateRecept(EmpPojo emp) throws SQLException {
        ps2.setString(1, emp.getEmpname());
        ps2.setDouble(2, emp.getSal());
        ps2.setString(3, emp.getEmpname());
        ps2.setString(4, emp.getEmpid());
        return (ps2.executeUpdate() != 0);
    }

    public static HashMap<String, EmpPojo> getReceptById() throws SQLException {
        ResultSet rs = st2.executeQuery("SELECT EMPLOYEES.EMPID,EMPLOYEES.ENAME,EMPLOYEES.SAL FROM EMPLOYEES INNER JOIN USERS ON EMPLOYEES.EMPID=USERS.EMPID WHERE ROLE='Receptionist'");
        HashMap<String, EmpPojo> receptionistList = new HashMap<>();
        while (rs.next()) {
            EmpPojo emp = new EmpPojo();
            emp.setEmpname(rs.getString(2));
            emp.setSal(rs.getDouble(3));
            receptionistList.put(rs.getString(1), emp);
        }
        return receptionistList;
    }

    public static boolean addUsers(UserPojo users) throws SQLException {

        ps.setString(1, users.getUserId());
        ps.setString(2, users.getEmpname());
        ps.setString(3, users.getEmpId());
        ps.setString(4, users.getPassword());
        ps.setString(5, users.getUserType());

        return (ps.executeUpdate() != 0);
    }
}
