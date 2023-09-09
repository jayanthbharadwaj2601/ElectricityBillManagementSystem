package Models;

public class Customer {
	private String NAME;
	private String EMAIL;
	private String MOBILE;
	private String Username;
	private String Password;
	public Customer(String a,String b,String c,String d,String e)
	{
		this.NAME=a;
		this.EMAIL=b;
		this.MOBILE=c;
		this.Username=d;
		this.Password=e;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getMOBILE() {
		return MOBILE;
	}
	public void setMOBILE(String mOBILE) {
		MOBILE = mOBILE;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}

}
