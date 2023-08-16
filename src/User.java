import java.io.ObjectOutputStream;
import java.io.Serializable;

public abstract class User implements Serializable {
	private String username;
	private String realname;
	private transient String password; //not hashed, just plain text :(
	
	public User(String username, String realname, String password) {
		this.username = username;
		this.realname = realname;
		this.password = password;
	}
		
	public String getUsername(){
		return username;
	}
	public String getRealname() {
		return realname;
	} 
}