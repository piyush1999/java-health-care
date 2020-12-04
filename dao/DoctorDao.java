package sanjeevani.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import sanjeevani.dbutil.DBConnection;
import sanjeevani.pojo.DoctorListPojo;
import sanjeevani.pojo.DoctorPojo;

public class DoctorDao {

    private static PreparedStatement ps, ps1, ps2, ps3, ps4;
    private static Statement st, st1, st2, st3, st4, st5;

    static {
        try {
            st = DBConnection.getConnection().createStatement();
            st1 = DBConnection.getConnection().createStatement();
            st2 = DBConnection.getConnection().createStatement();
            st3 = DBConnection.getConnection().createStatement();
            st4 = DBConnection.getConnection().createStatement();
            st5 = DBConnection.getConnection().createStatement();

            ps = DBConnection.getConnection().prepareStatement("INSERT INTO USERS VALUES (?,?,?,?,?)");
            ps1 = DBConnection.getConnection().prepareStatement("INSERT INTO DOCTORS VALUES (?,?,?,?,?)");
            ps2 = DBConnection.getConnection().prepareStatement("DELETE FROM USERS WHERE USERID=?");
            //ps3 = DBConnection.getConnection().prepareStatement("DELETE FROM USERS,DOCTORS USING USERS INNER JOIN DOCTORS ON USERS.USERID = DOCTORS.USERID  WHERE USERS.USERID=?");
            ps3 = DBConnection.getConnection().prepareStatement("Update DOCTORS set Active='N' Where USERID=?");
            ps4 = DBConnection.getConnection().prepareStatement("UPDATE DOCTORS ,EMPLOYEES,USERS \n"
                    + "SET \n"
                    + "    EMPLOYEES.ENAME = ?,\n"
                    + "    EMPLOYEES.SAL = ?,\n"
                    + "    USERS.USERNAME = ?,\n"
                    + "    DOCTORS.QUALIFICATION = ?,\n"
                    + "    DOCTORS.SPECIALIST = ?\n"
                    + "Where\n"
                    + "   USERS.USERID=DOCTORS.USERID and EMPLOYEES.EMPID=USERS.EMPID and EMPLOYEES.EMPID= ?");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean updateDoctor(DoctorListPojo doct) throws SQLException {
        ps4.setString(1, doct.getEmpName());
        ps4.setDouble(2, doct.getSal());
        ps4.setString(3, doct.getEmpName());
        ps4.setString(4, doct.getQualification());
        ps4.setString(5, doct.getSpecialist());
        ps4.setString(6, doct.getEmpId());
        return (ps4.executeUpdate()!=0);
    }

    public static HashMap<String, DoctorListPojo> getDoctorDetailsById() throws SQLException {
        ResultSet rs = st5.executeQuery("select USERS.EMPID,USERS.USERNAME,EMPLOYEES.SAL,DOCTORS.DOCTORID,DOCTORS.QUALIFICATION,DOCTORS.SPECIALIST from USERS INNER JOIN DOCTORS on USERS.USERID=DOCTORS.USERID INNER JOIN EMPLOYEES on USERS.EMPID=EMPLOYEES.EMPID WHERE USERS.USERTYPE='Doctor' and DOCTORS.Active='Y'");
        HashMap<String, DoctorListPojo> doctorList = new HashMap<>();
        while (rs.next()) {
            DoctorListPojo doct = new DoctorListPojo();
            doct.setEmpName(rs.getString(2));
            doct.setSal(rs.getDouble(3));
            doct.setDoctorid(rs.getString(4));
            doct.setQualification(rs.getString(5));
            doct.setSpecialist(rs.getString(6));

            doctorList.put(rs.getString(1), doct);
        }
        return doctorList;
    }

    public static ArrayList<String> getAllDoctorId() throws SQLException {
        ResultSet rs = st4.executeQuery("select DOCTORID from DOCTORS");
        ArrayList<String> doctorIds = new ArrayList<>();
        while (rs.next()) {
            doctorIds.add(rs.getString(1));
        }
        return doctorIds;
    }

    public static ArrayList<DoctorListPojo> getAllDoctor() throws SQLException {

        ResultSet rs = st3.executeQuery("SELECT EMPLOYEES.EMPID,EMPLOYEES.ENAME,EMPLOYEES.ROLE,EMPLOYEES.SAL,USERS.USERID,DOCTORS.DOCTORID,DOCTORS.QUALIFICATION,DOCTORS.SPECIALIST FROM\n"
                + " EMPLOYEES INNER JOIN USERS ON EMPLOYEES.EMPID = USERS.EMPID AND EMPLOYEES.ROLE=USERS.USERTYPE INNER JOIN DOCTORS ON USERS.USERID=DOCTORS.USERID WHERE USERS.USERTYPE='Doctor' AND DOCTORS.Active='Y'");
        ArrayList<DoctorListPojo> doctorList = new ArrayList<>();
        while (rs.next()) {
            DoctorListPojo emp = new DoctorListPojo(rs.getString(1), rs.getString(2), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
            doctorList.add(emp);
        }
        return doctorList;
    }

    public static ArrayList<String> getDoctor() throws SQLException {
        ResultSet rs = st.executeQuery("SELECT USERID FROM DOCTORS WHERE Active='Y'");
        ArrayList<String> doctorId = new ArrayList<>();
        while (rs.next()) {
            doctorId.add(rs.getString(1));
        }
        return doctorId;
    }

    public static boolean removeDoctor(String doctorId) throws SQLException {
        ps3.setString(1, doctorId);
        return (ps3.executeUpdate() != 0);
    }

    public static HashMap<String, String> getNonRegisteredDoctor() throws SQLException {
        ResultSet rs = st1.executeQuery("select EMPID,ENAME from EMPLOYEES where ROLE='Doctor' and EMPID not in (select EMPID from USERS where USERTYPE='Doctor')");
        HashMap<String, String> receptionist = new HashMap<>();

        while (rs.next()) {
            String id = rs.getString(1);
            String name = rs.getString(2);
            receptionist.put(id, name);
        }
        return receptionist;
    }

    public static boolean addDoctor(DoctorPojo doctor) throws SQLException {

        ps.setString(1, doctor.getUserId());
        ps.setString(2, doctor.getEmpname());
        ps.setString(3, doctor.getEmpId());
        ps.setString(4, doctor.getPassword());
        ps.setString(5, doctor.getUserType());

        int ans = ps.executeUpdate();
        if (ans > 0) {
            ps1.setString(1, doctor.getUserId());
            ps1.setString(2, doctor.getDoctorId());
            ps1.setString(3, doctor.getQualifications());
            ps1.setString(4, doctor.getSpecialist());
            ps1.setString(5, doctor.getIsActive());
            return (ps1.executeUpdate() != 0);
        } else {
            ps2.setString(1, doctor.getUserId());
            ps2.executeUpdate();
            return false;
        }

    }

    public static String getNewDoctorId() throws SQLException {
        ResultSet rs = st2.executeQuery("select max(DOCTORID) from DOCTORS");
        rs.next();
        String doctorid = rs.getString(1);
//        System.out.println("doctorid ::" + doctorid);
        if (doctorid == null) {
            return "D101";
        }
        int dno = Integer.parseInt(doctorid.substring(1));
        return "D" + (dno + 1);
    }
}
