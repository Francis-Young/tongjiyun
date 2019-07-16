package beans;

public class Message {
	private int messageid;
	private int sendid;
	private int recieveid;
	private String text=new String();
	public int getMessageid() {
		return messageid;
	}
	public void setMessageid(int messageid) {
		this.messageid = messageid;
	}
	public int getSendid() {
		return sendid;
	}
	public void setSendid(int sendid) {
		this.sendid = sendid;
	}
	public int getRecieveid() {
		return recieveid;
	}
	public void setRecieveid(int recieveid) {
		this.recieveid = recieveid;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
}
