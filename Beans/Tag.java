package beans;



import java.sql.Time;
import java.sql.Date;



/**

 * @author lh

 *

 */

public class Tag {

	private int tagid;

	private int csid;

	private String text=new String();

	private Time time=null;

		private Date date=null;

	public Date getDate() {

		return date;

	}
	
	public void setDate(Date date) {

		this.date=date;

	}
	

	public int getTagid() {

		return tagid;

	}

	public void setTagid(int tagid) {

		this.tagid = tagid;

	}

	public int getCsid() {

		return csid;

	}

	public void setCsid(int csid) {

		this.csid = csid;

	}

	public String getText() {

		return text;

	}

	public void setText(String text) {

		this.text = text;

	}

	public Time getTime() {

		return time;

	}

	public void setTime(Time time) {

		this.time = time;

	}

	

}