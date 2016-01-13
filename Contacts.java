package groupProject;

/**
 * Program: Contacts
 * Project: Group Project
 * Package: groupProject
 * @author Taizya
 * @since Jul 29, 2015
 * 
 */
public class Contacts {
/**
 * first name of contact
 */
	private String fname;
	/**
	 * last name of contact
	 */
	private String lname;
	/**
	 * phone number of contact
	 */
	private String phone;
	/**
	 * relationship to contact
	 */
	private String relationship;
	
	/**
	 * Parameterized constructor 
	 * @param fname first name of contact
	 * @param lname last name of contact
	 * @param phone phone number of contact
	 * @param r relationship to contact
	 */
	public Contacts (String fname, String lname, String phone, String r){
		
		this.fname = fname;
		this.lname = lname;
		this.phone = phone;
		this.relationship = r;
	}
	

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	
	/**
	 * locateContact finds the location of the contact based on the country code
	 * @param countryCode
	 * @return
	 */
public String locateContact (String countryCode){
		
		String location;
		
		if(countryCode == "+1"){
			
			location = "United States";
		}else
		{
			location = "International";
		}
		
		return location;
	}

/**
 * toString method formats a string with fields of the class
 */
@Override
public String toString(){
	
	return getFname() + " " + getLname() + " " + getPhone() + " " + getRelationship();
}
	


}
