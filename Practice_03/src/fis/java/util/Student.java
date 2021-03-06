package fis.java.util;

public class Student implements Comparable<Student>{
	
	private int code;
	
	private String name;
	
	private double gpa;
	
	

	public Student(int code, String name, double gpa) {
		super();
		this.code = code;
		this.name = name;
		this.gpa = gpa;
	}



	public int getCode() {
		return code;
	}



	public void setCode(int code) {
		this.code = code;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public double getGpa() {
		return gpa;
	}



	public void setGpa(double gpa) {
		this.gpa = gpa;
	}


	@Override
	public String toString() {
		return "Student [code=" + code + ", name=" + name + ", gpa=" + gpa + "]";
	}




	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return Double.compare(this.getGpa(), o.getGpa());
	}
	
}
