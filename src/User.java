import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class User {
    private String name;
    private String surName;
    private String eMail;
    private String password;
    private String profession;
    private Integer age;
    private ArrayList<Address> address;
    private Date lastLogin = null;

    public User() {
    }

    public User(String name, String surName, String eMail, String password, String profession, Integer age) {
        this.name = name;
        this.surName = surName;
        this.eMail = eMail;
        this.password = password;
        this.profession = profession;
        this.age = age;
        this.address = new ArrayList<>();
        this.lastLogin = lastLogin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public ArrayList<Address> getAddress() {
        return address;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public int hashCode() {
        return Objects.hash(eMail);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return Objects.equals(eMail, user.eMail);
    }
}

