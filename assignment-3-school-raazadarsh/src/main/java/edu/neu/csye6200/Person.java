package edu.neu.csye6200;

public class Person implements Comparable<Person>{
	public int age;
	public String lName;
	public String fName;
	public int id;

	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Person(int age, String fName, String lName, int id) {
		super();
		this.age = age;
		this.fName = fName;
		this.lName = lName;
		this.id = id;
	}

	public int getAge() {
		return age;
	}


	public String getfName() {
		return fName;
	}


	public String getlName() {
		return lName;
	}


	/*@Override
	public String toString() {
		// TODO Auto-generated method stub
		//return "Person [ first name = " + fName + ", last name = " + lName + ", Age = " + age + ", id = " + id];
		return "[ First Name = " + fName + ", Last Name = " + lName + ", Age = " + age + ", ID = " + id;

	}*/
	
	@Override
	public int compareTo(Person that) {
		return Integer.compare(this.age, that.age);
	}

	
	/*public static int compareByLastName(Person p1, Person p2) {
		return p1.lName.compareToIgnoreCase(p2.lName);

	}*/
	
	public static int compareByLastName(Person a, Person b) {
	    if (a == null || b == null || a.lName == null || b.lName == null) {
	        return 0; // Handle null values gracefully, you can adjust this logic as needed
	    }
	    return a.lName.compareTo(b.lName);
	}

	
	public static int compareByID(Person s1, Person s2) {
		return Integer.compare(s1.id, s2.id);
	}	
}
