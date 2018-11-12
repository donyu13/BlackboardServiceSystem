package com.xinrong.system.student_information_system.datamodel;

public class Material {

	private String materialID;
	private String materialName;
	private String materialContent;
	
	private Lecture lecture;


	public String getMaterialID() {
		return materialID;
	}

	public void setMaterialID(String materialID) {
		this.materialID = materialID;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getMaterialContent() {
		return materialContent;
	}

	public void setMaterialContent(String materialContent) {
		this.materialContent = materialContent;
	}

	public Lecture getLecture() {
		return lecture;
	}

	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}
	
	
}
