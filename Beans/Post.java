package beans;

import java.sql.Time;

public class Post {
	private int poid;
	private int csid;
	private int mid;
	private int type;
	private String title=new String();
	private String text=new String();
	private String popicaddr=new String();
	private String pofileaddr=new String();
	private String polink=new String();
	private int likenum;
	private Time time=null;
	private int deleted;
	public int getPoid() {
		return poid;
	}
	public void setPoid(int poid) {
		this.poid = poid;
	}
	public int getCsid() {
		return csid;
	}
	public void setCsid(int csid) {
		this.csid = csid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getPopicaddr() {
		return popicaddr;
	}
	public void setPopicaddr(String popicaddr) {
		this.popicaddr = popicaddr;
	}
	public String getPofileaddr() {
		return pofileaddr;
	}
	public void setPofileaddr(String pofileaddr) {
		this.pofileaddr = pofileaddr;
	}
	public String getPolink() {
		return polink;
	}
	public void setPolink(String polink) {
		this.polink = polink;
	}
	public int getLikenum() {
		return likenum;
	}
	public void setLikenum(int likenum) {
		this.likenum = likenum;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

}