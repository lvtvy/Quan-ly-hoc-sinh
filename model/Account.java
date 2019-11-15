package sample.model;

public class Account {

    private String id;
    private String name;
    private String email;
    private String passWord;

    public Account() {
    }

    public Account(String id, String name, String email, String passWord) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passWord = passWord;
    }

    public String getLoginCode() {
        return id;
    }

    public boolean setLoginCode(String id) {

        if (id != null && id.length() == 8) {
            this.id = id;
            return true;
        } else {
            System.err.println("Nhập lại mã số:");
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        if (email != null && email.contains("@") && !email.contains(" ")) {
            this.email = email;
            return true;
        } else {
            System.err.println("Nhập lại email:");
            return false;
        }
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "Account{" +
                "loginCode='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}