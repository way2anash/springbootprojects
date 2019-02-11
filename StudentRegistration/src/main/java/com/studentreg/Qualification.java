package com.studentreg;

public class Qualification {

	private String qualification;
	private String board;
	private Double percentage;
	private int yearOfPassing;
	
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getBoard() {
		return board;
	}
	public void setBoard(String board) {
		this.board = board;
	}
	public Double getPercentage() {
		return percentage;
	}
	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
	public int getYearOfPassing() {
		return yearOfPassing;
	}
	public void setYearOfPassing(int yearOfPassing) {
		this.yearOfPassing = yearOfPassing;
	}
	
	@Override
	public String toString() {
		return "Qualification [qualification=" + qualification + ", board=" + board + ", percentage=" + percentage
				+ ", yearOfPassing=" + yearOfPassing + "]";
	}
	
	
}
