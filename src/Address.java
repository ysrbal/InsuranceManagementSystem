public interface Address {
    String getAddress();
}

class homeAddress implements Address {
    private String address;

    public homeAddress(String address) {
        this.address = address;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

class businessAddress implements Address {
    private String address;

    public businessAddress(String address) {
        this.address = address;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

class AddressManager {
    public static void addAddress(User user, Address address) {
        user.getAddress().add(address);
    }

    public static void removeAddress(User user, Address address) {
        user.getAddress().remove(address);
    }
}
