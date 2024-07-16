package ContactManagement;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class ContactManager {
    private List<Contact> contacts;
    private static final String FILE_NAME = "contact.ser";
    public ContactManager() {
        contacts = loadContacts();
    }
    public void addContact(Contact contact) {
        contacts.add(contact);
        saveContacts();
    }
    public List<Contact> getContacts() {
        return contacts;
    }
    public void editContact(int index, Contact newContact) {
        if (index >= 0 && index < contacts.size()) {
            contacts.set(index, newContact);
            saveContacts();
        } else {
            System.out.println("Invalid contact index.");
        }
    }
    public void deleteContact(int index) {
        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
            saveContacts();
        } else {
            System.out.println("Invalid contact index.");
        }
    }
    public void deleteAllContacts() {
        contacts.clear();
        saveContacts();
    }
    private void saveContacts() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(contacts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    private List<Contact> loadContacts() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Contact>) ois.readObject();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
