package beans;

import java.sql.Date;
import java.sql.Time;

public class Letter {
	private int letterid;
	private int senderid;
	private int receiverid;
	private Date senddate;
	private Time sendtime;
	private String text;
	public int getLetterid() {
		return letterid;
	}
	public void setLetterid(int letterid) {
		this.letterid = letterid;
	}
	public int getSenderid() {
		return senderid;
	}
	public void setSenderid(int senderid) {
		this.senderid = senderid;
	}
	public int getReceiverid() {
		return receiverid;
	}
	public void setReceiverid(int receiverid) {
		this.receiverid = receiverid;
	}
	public Date getSenddate() {
		return senddate;
	}
	public void setSenddate(Date senddate) {
		this.senddate = senddate;
	}
	public Time getSendtime() {
		return sendtime;
	}
	public void setSendtime(Time sendtime) {
		this.sendtime = sendtime;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
}
