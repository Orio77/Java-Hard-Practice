package dataStructures.exercise7_practicalApplication.scenario1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class ContactBook {
    ArrayList<Contact> contacts;
    HashMap<Integer, Contact> contactBase;

    public ContactBook() {
        contacts = new ArrayList<>();
        contactBase = new HashMap<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        contactBase.put(contact.getName().concat(contact.getSurName()).hashCode(), contact);
    }

    public void addContacts(List<Contact> contactList) {
        this.contacts.addAll(contactList);
        for (Contact contact : contactList) {
            contactBase.put(contact.getName().concat(contact.getSurName()).hashCode(), contact);
        } 
    }

    public void removeContact(Contact contact) {
        contacts.remove(contact);
        contactBase.remove(contact.getName().hashCode());
    }

    public void sortContacts() {
        contacts.sort(Comparator.comparing(c -> c.getName()));
    }

    // Gets linear in some cases
    public boolean binarySearchContacts(Contact targetContact) {

        Contact currentContact;
        int index = contacts.size() / 2;
        int startIndex = 0;
        int endIndex = contacts.size() - 1;

        while (startIndex <= endIndex) {

            currentContact = contacts.get((startIndex + endIndex) / 2);

            if (targetContact.equals(currentContact)) {
                return true;
            }
            
            if (targetContact.getName().compareTo(currentContact.getName()) > 0) {
                startIndex = startIndex + index;

            }

            else if (targetContact.getName().compareTo(currentContact.getName()) < 0) {
                endIndex = endIndex - index;

            }

            index = index / 2;
            if (index == 0) 
                index = 1;
        }
        return false;
    }
}
