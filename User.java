package usk.eng.komputer.gotravel.Model;


public class User {

    private String username;
    private String alamat;
    private String nohp;
    private String email;
    private String password;

    public User(){

    }

    public User(String username, String alamat, String nohp, String email, String password) {
        this.username = username;
        this.alamat = alamat;
        this.nohp = nohp;
        this.email = email;
        this.password = password;

    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }


    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNohp() {
        return nohp;
    }
    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
