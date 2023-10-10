package edu.neu.csye6200;

public class Student extends Person {
	private double gpa;
	private Parent parents;


	/*public Student(int age, String firstName, String lastName, int id, double gpa) {
        super(age, firstName, lastName, id);
        this.gpa = gpa;
    }*/

	public Student(int age, String fName, String lName, int id, double gpa, String father_name, String mother_name) {
	    super(age, fName, lName, id);
	    this.gpa = gpa;
	    this.parents = new Parent(father_name, mother_name);
	}



	public Student(int age, String fname, String lname, int id, double gpa2) {
		// TODO Auto-generated constructor stub
	}



	public double getGpa() {
		return gpa;
	}
	
	
	public Parent getParents() {
		return this.parents;
	}


	

	/*@Override
	public String toString() {
		if(this.parents.father_name != null && this.parents.mother_name != null) {
			return super.toString() + ", GPA = " + gpa +  " ]";
		} else {
			return super.toString() + ", GPA = " + gpa + ", Father Name = " + this.parents.father_name + ", Mother Name = " + this.parents.mother_name + " ]";

		}
	}*/
	
	
	/*@Override
	public String toString() {			
		return super.toString() + ", GPA = " + gpa + ", Father Name = " + this.parents.father_name + ", Mother Name = " + this.parents.mother_name + " ]" ;
	}*/
	
	/*@Override
	public String toString() {
	    return "Student: " + fName + " " + lName + ", Age: " + age + ", ID: " + id + ", GPA: " + gpa +
	           ", Father: " + parents.getFather_name() + ", Mother: " + parents.getMother_name();
	}*/


	
	public static int compareByGPA(Student s1, Student s2) {
	    return Double.compare(s1.gpa , s2.gpa);
	}

	
	
	//inner class
	public static class Parent {
		private String mother_name;
		private String father_name;
		
		public Parent() {
			super();
			// TODO Auto-generated constructor stub
		}


		public Parent(String father_name, String mother_name) {
			super();
			this.father_name = father_name;
			this.mother_name = mother_name;			
		}


		public String getMother_name() {
			return mother_name;
		}


		public String getFather_name() {
			return father_name;
		}


		
		


		
		
		
		
	}
}
