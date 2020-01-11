package models;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name=User.GET_ALL_USERS_QUERY_NAME , query="SELECT u FROM User u")
//@NamedQuery(name=User.GET_USER_BY_NAME_QUERY_NAME , query="SELECT u FROM User u WHERE u.name LIKE CONCAT('%', :name, '%') OR u.email LIKE CONCAT('%', :name, '%')")
@NamedQuery(name=User.GET_USER_BY_EMAIL_QUERY_NAME , query="SELECT u FROM User u WHERE u.email LIKE CONCAT('%', :email, '%')")
public class User extends GenericEntity {
	
	private static final long serialVersionUID = 1L;
	
	public static final String GET_ALL_USERS_QUERY_NAME = "User.getAllUsers";
	public static final String GET_USER_BY_EMAIL_QUERY_NAME  = "User.getUserByEmail";
	

	    private String firstName; 
	    private String lastName; 

	    private String email;

//	    private String password;
	    
	    private String hashcode;
	    private String salt;

	    private String role;
	    
	    public User() {
	    	
	    }

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getHashcode() {
			return hashcode;
		}

		public void setHashcode(String hashcode) {
			this.hashcode = hashcode;
		}

		public String getSalt() {
			return salt;
		}

		public void setSalt(String salt) {
			this.salt = salt;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}
	    

		
		

	    
	    
}
