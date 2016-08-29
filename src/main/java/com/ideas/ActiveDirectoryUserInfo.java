package com.ideas;

import com4j.COM4J;
import com4j.ComException;
import com4j.Variant;
import com4j.typelibs.activeDirectory.IADs;
import com4j.typelibs.ado20.ClassFactory;
import com4j.typelibs.ado20.Fields;
import com4j.typelibs.ado20._Command;
import com4j.typelibs.ado20._Connection;
import com4j.typelibs.ado20._Recordset;

public class ActiveDirectoryUserInfo {
	static String defaultNamingContext = null;
	private Fields userData;
	private Employee userDetails;

	public ActiveDirectoryUserInfo(String username, String requestedFields) throws AuthenticationError {
		initNamingContext();
		_Connection connection = ClassFactory.createConnection();
		connection.provider("ADsDSOObject");
		connection.open("Active Directory Provider", "", "", -1);
		_Command command = ClassFactory.createCommand();
		command.activeConnection(connection);
		String searchField = "userPrincipalName";
		int pSlash = username.indexOf('\\');
		if (pSlash > 0) {
			searchField = "sAMAccountName";
			username = username.substring(pSlash + 1);
		}
		command.commandText("<LDAP://" + defaultNamingContext + ">;(" + searchField + "=" + username + ");"
				+ requestedFields + ";subTree");
		_Recordset rs = command.execute(null, Variant.getMissing(), -1);
		if (!rs.eof()) {
			userData = rs.fields();
			if (userData != null)
				userDetails = extractUserInfo();
			else
				try {
					throw new AuthenticationError("User information not found");
				} catch (AuthenticationError e) {
				}
			rs.close();
			connection.close();
		} else

			throw new AuthenticationError("Username cannot be found");

	}

	void initNamingContext() {
		if (defaultNamingContext == null) {
			IADs rootDSE = COM4J.getObject(IADs.class, "LDAP://RootDSE", null);
			defaultNamingContext = (String) rootDSE.get("defaultNamingContext");
		}
	}

	private Employee extractUserInfo() {
		String employeeID;
		String name;
		String telephone ;
		String email;
		Object object;
		String employeeType;
		String department;
		String designation;
		try {
			object = this.userData.item("employeeNumber").value();
			employeeID = object.toString();
		} catch (ComException e) {
			employeeID = "";
		}
		try {
			object = this.userData.item("displayName").value();
			name = object.toString();

		} catch (ComException e) {
			name = "";

		}
		try {
			object = this.userData.item("department").value();
			department = object.toString();

		} catch (ComException e) {
			department = "";

		}
		try {
			object = this.userData.item("title").value();
			designation = object.toString();

		} catch (ComException e) {
			designation = "";

		}
		try {
			object = this.userData.item("mail").value();
			email = object.toString();
		} catch (ComException e) {
			email = "";
		}
		try {
			object = this.userData.item("telephoneNumber").value();
			telephone = object.toString();
		} catch (ComException e) {
			telephone = "";
		}
		try {
			object = this.userData.item("employeeType").value();
			employeeType = object.toString();
		} catch (ComException e) {
			employeeType = "";
		}
		Employee userDTO = new Employee(employeeID, name, email, telephone, employeeType,department,designation);
		return userDTO;
	}

	public Employee getUserDetails() {

		return this.userDetails;

	}
}