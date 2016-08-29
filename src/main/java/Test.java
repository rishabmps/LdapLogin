

import com.ideas.ActiveDirectoryUserInfo;
import com.ideas.AuthenticationError;
import com.ideas.Employee;

public class Test {

	public static void main(String[] args) throws AuthenticationError {
		// TODO Auto-generated method stub
		
		String REQUESTEDFIELDS = "employeeNumber,displayName,mail,telephoneNumber,employeeType,department,title";
		
	
		Employee retrievedUserInfo = null;
		System.getProperty("user.name");
		retrievedUserInfo = new ActiveDirectoryUserInfo("ROW\\"+"idnaba", REQUESTEDFIELDS).getUserDetails();
		System.out.println(retrievedUserInfo);
		
}
}
