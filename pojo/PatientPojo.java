package sanjeevani.pojo;

import java.sql.Date;

public class PatientPojo {

    private String p_id;
    private String f_name;
    private String s_name;
    private int age;
    private String opd;
    private String gender;
    private String m_status;
    private Date p_date;
    private String address;
    private String city;
    private String phone_no;
    private String doctor_id;

    public PatientPojo() {
    }

    @Override
    public String toString() {
        return "PatientPojo{" + "p_id=" + p_id + ", f_name=" + f_name + ", s_name=" + s_name + ", age=" + age + ", opd=" + opd + ", gender=" + gender + ", m_status=" + m_status + ", p_date=" + p_date + ", address=" + address + ", city=" + city + ", phone_no=" + phone_no + ", doctor_id=" + doctor_id + '}';
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOpd() {
        return opd;
    }

    public void setOpd(String opd) {
        this.opd = opd;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getM_status() {
        return m_status;
    }

    public void setM_status(String m_status) {
        this.m_status = m_status;
    }

    public Date getP_date() {
        return p_date;
    }

    public void setP_date(Date p_date) {
        this.p_date = p_date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public PatientPojo(String p_id, String f_name, String s_name, int age, String opd, String gender, String m_status, Date p_date, String address, String city, String phone_no, String doctor_id) {
        this.p_id = p_id;
        this.f_name = f_name;
        this.s_name = s_name;
        this.age = age;
        this.opd = opd;
        this.gender = gender;
        this.m_status = m_status;
        this.p_date = p_date;
        this.address = address;
        this.city = city;
        this.phone_no = phone_no;
        this.doctor_id = doctor_id;
    }

}
