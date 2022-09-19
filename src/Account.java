import java.util.*;

public abstract class Account implements Comparable<Account> {
    enum AuthenticationStatus {SUCCESS, FAIL}

    private User user;
    private List<Insurance> insurance;
    private AuthenticationStatus status;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Insurance> getInsurance() {
        return insurance;
    }

    public void setInsurance(List<Insurance> insurance) {
        this.insurance = insurance;
    }

    public AuthenticationStatus getStatus() {
        return status;
    }

    public void setStatus(AuthenticationStatus status) {
        this.status = status;
    }

    public final void showUserInfo() {
        System.out.println("Account Information : " +
                "\nName : " + user.getName() +
                "\nSurname : " + user.getSurName() +
                "\ne-mail : " + user.geteMail() +
                "\nProfession : " + user.getProfession() +
                "\nAge : " + user.getAge() +
                "\nLast Login : " + user.getLastLogin());
        for (Address address : user.getAddress()) {
            System.out.println(address.getAddress());
        }
    }

    public void login(String email, String password) throws InvalidAuthenticationException {
        if (email.equals(getUser().geteMail()) && password.equals(getUser().getPassword())) {
            setStatus(AuthenticationStatus.SUCCESS);
            System.out.println("Login Successful.");
        } else {
            setStatus(AuthenticationStatus.FAIL);
            throw new InvalidAuthenticationException("Wrong User Information !");
        }
    }

    public abstract void addAddress(String address);

    public void addInsurance(Insurance insurance) {
        insurance.calculate();
        this.getInsurance().add(insurance);
    }

    @Override
    public int compareTo(Account o) {
        return this.hashCode() - o.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Account account = (Account) obj;
        return Objects.equals(user, account.user);
    }
}

class Individual extends Account {
    public Individual() {
        this.setStatus(AuthenticationStatus.FAIL);
        this.setInsurance(new ArrayList<>());
    }

    public Individual(User user) {
        this();
        this.setUser(user);
    }

    @Override
    public void addAddress(String address) {
        AddressManager.addAddress(this.getUser(), new homeAddress(address));
    }
}

class Enterprise extends Account {
    public Enterprise() {
        this.setStatus(AuthenticationStatus.FAIL);
        this.setInsurance(new ArrayList<>());
    }

    public Enterprise(User user) {
        this();
        this.setUser(user);
    }

    @Override
    public void addAddress(String address) {
        AddressManager.addAddress(this.getUser(), new businessAddress(address));
    }
}
