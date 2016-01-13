package groupProject;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Program: FavoriteContacts Project: Group Project Package: groupProject
 * 
 * @author Taizya
 * @since Jul 29, 2015
 * 
 */
public class FavoriteContacts {

	/**
	 * set of contacts
	 */
	private Set<Contacts> favs;

	/**
	 * Parameterized constructor receives arguments of type contact as varargs
	 * @param favs
	 */
	public FavoriteContacts(Contacts... favs) {

		this.favs = new HashSet<Contacts>(Arrays.asList(favs));
	}

	/**
	 * getFavs method returns a String of favorite contacts line by line
	 * @return
	 */
	public String getFavs() {

		StringBuilder sb = new StringBuilder("Favorites: \n");
		for (Contacts c : favs) {

			sb.append(c + "\n");
		}

		return sb.toString();

	}

	/**
	 * addElements adds a new element to the set of Contacts
	 * @param c
	 */
	public void addElements(Contacts c) {

		favs.add(c);
	}

}
