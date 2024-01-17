package model;

public class User {
    private String usermane;
    private String password;
    private String email;
    private UserRole role;

    public enum UserRole{
        ADMIN,SELLER,GUEST
    }

    public User(String usermane, String password, String email) {
        this.usermane = usermane;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public String getUsermane() {
        return usermane;
    }

    public void setUsermane(String usermane) {
        this.usermane = usermane;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
