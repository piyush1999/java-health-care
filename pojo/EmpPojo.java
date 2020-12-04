package sanjeevani.pojo;

public class EmpPojo {

    public EmpPojo() {
    }
    
    private String empid;
    private String empname;
    private String job;
    private double sal;
    
    @Override
    public String toString() {
        return "EmpPojo{" + "empid=" + empid + ", empname=" + empname + ", job=" + job + ", sal=" + sal + '}';
    }

    public EmpPojo(String empid, String empname, String job, double sal) {
        this.empid = empid;
        this.empname = empname;
        this.job = job;
        this.sal = sal;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }
    
}
