public class Contact {
    private int contactId;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private String birthday;
    private String company;

    public Contact(int contactId, String name, String phoneNumber,
                   String email, String address, String birthday, String company) {
        this.contactId   = contactId;
        this.name        = name;
        this.phoneNumber = phoneNumber;
        this.email       = email;
        this.address     = address;
        this.birthday    = birthday;
        this.company     = company;
    }

    public int    getContactId()   { return contactId; }
    public String getName()        { return name; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail()       { return email; }
    public String getAddress()     { return address; }
    public String getBirthday()    { return birthday; }
    public String getCompany()     { return company; }

    public void setName(String name)               { this.name = name; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setEmail(String email)             { this.email = email; }
    public void setAddress(String address)         { this.address = address; }
    public void setBirthday(String birthday)       { this.birthday = birthday; }
    public void setCompany(String company)         { this.company = company; }

    public String toFileString() {
        return contactId + "," + name + "," + phoneNumber + "," +
                email + "," + address + "," + birthday + "," + company;
    }

    public void display() {
        System.out.println("+------------------------------------------+");
        System.out.printf ("| ID       : %-30d |\n", contactId);
        System.out.printf ("| Name     : %-30s |\n", name);
        System.out.printf ("| Phone    : %-30s |\n", phoneNumber);
        System.out.printf ("| Email    : %-30s |\n", email);
        System.out.printf ("| Address  : %-30s |\n", address);
        System.out.printf ("| Birthday : %-30s |\n", birthday);
        System.out.printf ("| Company  : %-30s |\n", company);
        System.out.println("+------------------------------------------+");
    }

    @Override
    public String toString() {
        return "Contact{ID=" + contactId + ", Name='" + name + "', Phone='" + phoneNumber + "'}";
    }
}
