package groupProject;

/**
 * Program: ContactsApp
 * Project: Group Project
 * Package: groupProject
 * @author Taizya
 * @since Aug 2, 2015
 * 
 * This class implements all the methods of Contacts and FavoriteContacts classes
 * 
 */
public class ContactsApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Contacts myContact = new Contacts("Taizya", "Namwizye", "801-123-4567", "Classified");
		System.out.println("First Contact: " + myContact);
		System.out.println("Location: " + myContact.locateContact("+1"));
		System.out.println();
		
		FavoriteContacts fav1 = new FavoriteContacts(myContact);
		fav1.addElements(new Contacts("Jane", "Smith", "801-098-7654", "Friend"));
		System.out.println(fav1.getFavs());

	}

}
