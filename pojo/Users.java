package sanjeevani.pojo;

public class Users {
    
    private String userId;
    private String password;
    private String userType;
    
    public Users(String userId, String password, String userType) {
        this.userId = userId;
        this.password = password;
        this.userType = userType;
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
}
