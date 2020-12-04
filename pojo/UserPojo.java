package sanjeevani.pojo;

public class UserPojo {

    private String userId;
    private String password;
    private String userType;
    private String empId;
    private String Empname;

    @Override
    public String toString() {
        return "UserPojo{" + "userId=" + userId + ", password=" + password + ", userType=" + userType + ", empId=" + empId + ", Empname=" + Empname + '}';
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

    public UserPojo(String userId, String password, String userType, String empId, String Empname) {
        this.userId = userId;
        this.password = password;
        this.userType = userType;
        this.empId = empId;
        this.Empname = Empname;
    }

}
