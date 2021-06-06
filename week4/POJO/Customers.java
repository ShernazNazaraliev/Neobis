public class Customers {
    private long CustomersID;
    private String CustomersName;
    private String CustomersAddress;
    private String CustomersEmail;
    private String PhoneNamber;

    public Customers() {
    }

    public Customers(long customersID, String name, String address, String email, String phoneNamber) {
        CustomersID = customersID;
        CustomersName = name;
        CustomersAddress = address;
        CustomersEmail = email;
        PhoneNamber = phoneNamber;
    }

    public void setCustomersID(long customersID) {
        CustomersID = customersID;
    }

    public void setName(String name) {
        CustomersName = name;
    }

    public void setAddress(String address) {
        CustomersAddress = address;
    }

    public void setEmail(String email) {
        CustomersEmail = email;
    }

    public void setPhoneNamber(String phoneNamber) {
        PhoneNamber = phoneNamber;
    }

    public long getCustomersID() {
        return CustomersID;
    }

    public String getName() {
        return CustomersName;
    }

    public String getAddress() {
        return CustomersAddress;
    }

    public String getEmail() {
        return CustomersEmail;
    }

    public String getPhoneNamber() {
        return PhoneNamber;
    }
}
