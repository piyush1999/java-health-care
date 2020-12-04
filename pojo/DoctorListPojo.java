package sanjeevani.pojo;

public class DoctorListPojo {

    public DoctorListPojo() {
    }

    private String empId;
    private String empName;
    private double sal;
    private String userid;
    private String doctorid;
    private String qualification;
    private String specialist;

    @Override
    public String toString() {
        return "DoctorListPojo{" + "empId=" + empId + ", empName=" + empName + ", sal=" + sal + ", userid=" + userid + ", doctorid=" + doctorid + ", qualification=" + qualification + ", specialist=" + specialist + '}';
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(String doctorid) {
        this.doctorid = doctorid;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    public DoctorListPojo(String empId, String empName, double sal, String userid, String doctorid, String qualification, String specialist) {
        this.empId = empId;
        this.empName = empName;
        this.sal = sal;
        this.userid = userid;
        this.doctorid = doctorid;
        this.qualification = qualification;
        this.specialist = specialist;
    }

}
