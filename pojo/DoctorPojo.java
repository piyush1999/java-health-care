
package sanjeevani.pojo;

public class DoctorPojo {

    private String userId;
    private String password;
    private String userType;
    private String empId;
    private String Empname;
    private String doctorId;
    private String specialist;
    private String qualifications;
    private String isActive;

    @Override
    public String toString() {
        return "DoctorPojo{" + "userId=" + userId + ", password=" + password + ", userType=" + userType + ", empId=" + empId + ", Empname=" + Empname + ", doctorId=" + doctorId + ", specialist=" + specialist + ", qualifications=" + qualifications + ", isActive=" + isActive + '}';
    }

    public DoctorPojo() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpname() {
        return Empname;
    }

    public void setEmpname(String Empname) {
        this.Empname = Empname;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public DoctorPojo(String userId, String password, String userType, String empId, String Empname, String doctorId, String specialist, String qualifications, String isActive) {
        this.userId = userId;
        this.password = password;
        this.userType = userType;
        this.empId = empId;
        this.Empname = Empname;
        this.doctorId = doctorId;
        this.specialist = specialist;
        this.qualifications = qualifications;
        this.isActive = isActive;
    }

}
