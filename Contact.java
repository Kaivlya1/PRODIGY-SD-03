package ContactManagement;
import java.io.Serializable;
public class Contact implements Serializable
{
    private String name;
    private String phoneNumber;
    private String emailAddress;

    public Contact (String name, String phoneNumber, String emailAdderess)
    {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAdderess; 
    }
    public String getName()
    {
        return name;
    }
    public String steName()
    {
        return name;
    }
    public void steName(String name)
    {
        this.name = name;
    }
    public String getphoneNumber()
    {
        return phoneNumber;
    }
    public String getemailAddress()
    {
        return emailAddress;
    }
    public void setemailAddress(String emailAddress)
    {
        this.emailAddress =emailAddress;
    }
    @Override
    public String toString()
    {
        return "Contact{name='" + name + "', phoneNumber='" + phoneNumber + "', emailAddress='" + emailAddress + "'}";
    }
}
