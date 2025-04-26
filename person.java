package project;



public abstract class person {
    private String username;
    private String password;
    private String dateOfBirth;


    public person() {

    }
    //overload
    public person(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public person(String username, String password, String dateOfBirth) {
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;

    }

    public abstract String Role();


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
