package com.model;

public class InfoType {

	private int infoTypeId;
	private String typeName;
	
	
	
	public InfoType(String typeName) {
		super();
		this.typeName = typeName;
	}
	public InfoType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getInfoTypeId() {
		return infoTypeId;
	}
	public void setInfoTypeId(int infoTypeId) {
		this.infoTypeId = infoTypeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
}
