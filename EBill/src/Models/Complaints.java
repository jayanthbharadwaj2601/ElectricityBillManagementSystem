package Models;

public class Complaints {
	private int complaintid;
	private String customer;
	private String complaint;
	private String status;
	public Complaints(int a,String b,String c,String d)
	{
		this.complaintid=a;
		this.customer=b;
		this.complaint=c;
		this.status=d;
	}
	public int getComplaintid() {
		return complaintid;
	}
	public void setComplaintid(int complaintid) {
		this.complaintid = complaintid;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getComplaint() {
		return complaint;
	}
	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
