package ca.saskshare.web.formbean;

public class RegisterForm {
	private String username;
	private String realname;
	private String password;
	private String repassword;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	
	
	/**
	 * validate only password and repassword
	 * @return boolean
	 */
	public boolean validate() {
		boolean isValid = true;
		if (!password.equals(repassword)) {
			isValid = false;
		}
		return isValid;
	}
}
