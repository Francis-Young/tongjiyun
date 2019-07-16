package beans;

public class Dormitory {
	private int doid;
	private String doname=new String();
	private String dointro=new String();
	private String modeladdr=new String();
	private int balcony;
	private int bathroom;
	private int doprice;
	private String donew=new String();
	public int getDoid() {
		return doid;
	}
	public void setDoid(int doid) {
		this.doid = doid;
	}
	public String getDoname() {
		return doname;
	}
	public void setDoname(String doname) {
		this.doname = doname;
	}
	public String getDointro() {
		return dointro;
	}
	public void setDointro(String dointro) {
		this.dointro = dointro;
	}
	public String getModeladdr() {
		return modeladdr;
	}
	public void setModeladdr(String modeladdr) {
		this.modeladdr = modeladdr;
	}
	public int getBalcony() {
		return balcony;
	}
	public void setBalcony(int balcony) {
		this.balcony = balcony;
	}
	public int getBathroom() {
		return bathroom;
	}
	public void setBathroom(int bathroom) {
		this.bathroom = bathroom;
	}
	public int getDoprice() {
		return doprice;
	}
	public void setDoprice(int doprice) {
		this.doprice = doprice;
	}
	public String getDonew() {
		return donew;
	}
	public void setDonew(String donew) {
		this.donew = donew;
	}
}