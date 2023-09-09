package Models;

public class Bill {
	private int billid;
	private String username;
	private int energy;
	private int bill;
	private String status;
	public Bill(int a,String b,int c,int d,String e)
	{
		this.billid=a;
		this.username=b;
		this.energy=c;
		this.bill=d;
		this.status=e;
	}
	public int getBillid() {
		return billid;
	}
	public void setBillid(int billid) {
		this.billid = billid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	public int getBill() {
		return bill;
	}
	public void setBill(int bill) {
		this.bill = bill;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
