package sanjeevani.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import sanjeevani.dbutil.DBConnection;
import sanjeevani.pojo.PatientPojo;

public class PatientDao {

    private static PreparedStatement ps, ps1, ps2, ps3;
    private static Statement st, st1, st2, st3, st4;

    static {
        try {
            st = DBConnection.getConnection().createStatement();
            st1 = DBConnection.getConnection().createStatement();
            st2 = DBConnection.getConnection().createStatement();
//            st3 = DBConnection.getConnection().createStatement();
//            st4 = DBConnection.getConnection().createStatement();
            ps = DBConnection.getConnection().prepareStatement("INSERT INTO PATIENT VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps1 = DBConnection.getConnection().prepareStatement("Update PATIENT set Active='N' where P_ID=?");
//            ps2 = DBConnection.getConnection().prepareStatement("DELETE FROM USERS WHERE USERID=?");
//            ps3 = DBConnection.getConnection().prepareStatement("DELETE FROM USERS,DOCTORS USING USERS INNER JOIN DOCTORS ON USERS.USERID = DOCTORS.USERID  WHERE USERS.USERID=?");
//        
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getPatientIds() throws SQLException {
        ResultSet rs = st2.executeQuery("select P_ID from PATIENT where Active='Y'");
        ArrayList<String> patientId = new ArrayList<>();
        while (rs.next()) {
            patientId.add(rs.getString(1));
        }
        System.out.println("patientId at Dao:"+patientId);
        return patientId;
    }

    public static boolean removePatientById(String p_Id) throws SQLException {
        ps1.setString(1, p_Id);
        return (ps1.executeUpdate() != 0);
    }

    public static HashMap<String, PatientPojo> getPatientDetailsId() throws SQLException {
        ResultSet rs = st1.executeQuery("SELECT * FROM PATIENT");
        HashMap<String, PatientPojo> patientList = new HashMap<>();
        while (rs.next()) {
            PatientPojo patient = new PatientPojo();
            patient.setF_name(rs.getString(2));
            patient.setS_name(rs.getString(3));
            patient.setAge(rs.getInt(4));
            patient.setOpd(rs.getString(5));
            patient.setGender(rs.getString(6));
            patient.setP_date(rs.getDate(8));
            patient.setCity(rs.getString(10));
            patient.setPhone_no(rs.getString(11));
            patient.setDoctor_id(rs.getString(12));

            patientList.put(rs.getString(1), patient);
        }
        return patientList;
    }
    
     public static ArrayList<PatientPojo> getPatientAppointment(String doctname) throws SQLException {
        ResultSet rs = st1.executeQuery("SELECT * FROM PATIENT");
        ArrayList<PatientPojo> patientList = new ArrayList<>();
        while (rs.next()) {
            PatientPojo patient = new PatientPojo();
            patient.setP_id(rs.getString(1));
            patient.setF_name(rs.getString(2));
            patient.setS_name(rs.getString(3));
            patient.setAge(rs.getInt(4));
            patient.setOpd(rs.getString(5));
            patient.setGender(rs.getString(6));
            patient.setP_date(rs.getDate(8));
            patient.setCity(rs.getString(10));
            patient.setPhone_no(rs.getString(11));
            patient.setDoctor_id(rs.getString(12));

            patientList.add(patient);
        }
        return patientList;
    }

    public static ArrayList<PatientPojo> getAllPatientDetails() throws SQLException {
        ResultSet rs = st1.executeQuery("SELECT * FROM PATIENT");
        ArrayList<PatientPojo> patientList = new ArrayList<>();
        while (rs.next()) {
            PatientPojo patient = new PatientPojo();
            patient.setP_id(rs.getString(1));
            patient.setF_name(rs.getString(2));
            patient.setS_name(rs.getString(3));
            patient.setAge(rs.getInt(4));
            patient.setOpd(rs.getString(5));
            patient.setGender(rs.getString(6));
            patient.setP_date(rs.getDate(8));
            patient.setCity(rs.getString(10));
            patient.setPhone_no(rs.getString(11));
            patient.setDoctor_id(rs.getString(12));

            patientList.add(patient);
        }
        return patientList;
    }

    public static boolean addPatient(PatientPojo patient) throws SQLException {
        ps.setString(1, patient.getP_id());
        ps.setString(2, patient.getF_name());
        ps.setString(3, patient.getS_name());
        ps.setInt(4, patient.getAge());
        ps.setString(5, patient.getOpd());
        ps.setString(6, patient.getGender());
        ps.setString(7, patient.getM_status());
        ps.setDate(8, patient.getP_date());
        ps.setString(9, patient.getAddress());
        ps.setString(10, patient.getCity());
        ps.setString(11, patient.getPhone_no());
        ps.setString(12, patient.getDoctor_id());

        return (ps.executeUpdate() != 0);
    }

    public static String getNewPatientId() throws SQLException {
        ResultSet rs = st.executeQuery("select max(P_ID) from PATIENT");
        rs.next();
        String p_id = rs.getString(1);
        if (p_id == null) {
            return "P101";
        }
        int pno = Integer.parseInt(p_id.substring(1));
        return "P" + (pno + 1);
    }
}
