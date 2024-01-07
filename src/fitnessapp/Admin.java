package fitnessapp;

public class Admin {

    private int adminID;
    private String adminName;
    private String adminSurname;
    private String adminPassword;
    private String adminEmail;
    private String adminAddress;

    public Admin(int adminID, String adminName, String adminSurname, String adminPassword, String adminEmail) {
        this.adminID = adminID;
        this.adminName = adminName;
        this.adminSurname = adminSurname;
        this.adminPassword = adminPassword;
        this.adminEmail = adminEmail;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminSurname() {
        return adminSurname;
    }

    public void setAdminSurname(String adminSurname) {
        this.adminSurname = adminSurname;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminAddress() {
        return adminAddress;
    }

    public void setAdminAddress(String adminAddress) {
        this.adminAddress = adminAddress;
    }

    
}
