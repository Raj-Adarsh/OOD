package edu.neu.csye6200;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class School {
	
	public School() {
		super();
		// TODO Auto-generated constructor stub
	}

	ArrayList<Person> personRoster = new ArrayList<>();
	ArrayList<Student> studentRoster = new ArrayList<>();
	
	
	public School(ArrayList<Person> personRoster, ArrayList<Student> studentRoster) {
		super();
		this.personRoster = personRoster;
		this.studentRoster = studentRoster;
	}

	public void addStudent(Student student) {
		//persons.add(student);
		studentRoster.add(student);
    }
	
	/*public void addPerson(Person student) {
		personRoster.add(student);
    }*/
	
	public void addPerson(Person person) {
	    personRoster.add(person);
	}
	
	
	
	//Method to read csv file from person
	public static List<Person> readPersonCSVFile() {
		//String filepath = "/Users/adarshraj/Documents/6200_OOD/assignment-school/assignment-3-school-raazadarsh/data/Person.csv";

		String filepath = "data/Person.csv";
		
	    List<Person> personList = new ArrayList<>(); // Create a list to store students


		//System.out.println("I am here");
		try {
			BufferedReader inLine = new BufferedReader(new FileReader(filepath));
			String inputLine = null;
			while((inputLine = inLine.readLine() )!= null) {
				String[] fields = inputLine.split(",");
				//System.out.println("Fields: " + Arrays.toString(fields));
				if (fields.length == 5) {
					String fname = fields[0];  // Last Name
					String lname = fields[1];  // First Name
					int age = Integer.parseInt(fields[2]);  // Age
					int id = Integer.parseInt(fields[3]);  // ID
					double gpa = Double.parseDouble(fields[4]);
					
					Person person = new Student(age, fname, lname, id, gpa);	//ather_name, mother_name
					personList.add((Student)person); // Add the student to the list


					//addPerson(new Student(age, fname, lname, id, gpa, null, null)); //iska kya karna hain
					//addPerson(new Student(age, fname, lname, id, gpa)); //iska kya karna hain
				}
				
			}
			inLine.close();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		return personList;
	}
	
	public  static List<Student> readStudentCSVFile() {
		String filepath = "data/Student.csv";
	    List<Student> studentList = new ArrayList<>(); // Create a list to store students
		
		try {
			BufferedReader inLine = new BufferedReader(new FileReader(filepath));
			String inputLine = null;
			while((inputLine = inLine.readLine() )!= null) {
				String[] fields = inputLine.split(",");
				if (fields.length == 7) {
					//System.out.println("Fields: " + Arrays.toString(fields));
					String fname = fields[0];  // Last Name
					String lname = fields[1];  // First Name
					int age = Integer.parseInt(fields[2]);  // Age
					int id = Integer.parseInt(fields[3]);  // ID
					double gpa = Double.parseDouble(fields[4]);
					String  father_name= fields[5];
					String mother_name = fields[6];
					//studentRoster.add(new Student(age, lname, fname, id, gpa, father_name, mother_name));	
					//addStudent(new Student(age, fname, lname, id, gpa, father_name, mother_name));
					
					Student student = new Student(age, fname, lname, id, gpa, father_name, mother_name);
	                studentList.add(student); // Add the student to the list
				}
				
			}
			inLine.close();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		return studentList;
	}
  	
	public void sort_by_age() {
	    System.out.println("Student List\n");
	    studentRoster.sort(Person::compareTo);
	    System.out.println(this.toString()); // This will call the overridden toString method of the School class

	    System.out.println("Person List\n");
	    personRoster.sort(Person::compareTo);
	    System.out.println(this.toString());
	}

	public void sort_by_last_name() {
	    System.out.println("Student List\n");
	    studentRoster.sort(Person::compareByLastName);
	    System.out.println(this.toString());
	    /*for (Student student : studentRoster) {
	        System.out.println(student.toString());
	    }*/

	    System.out.println("Person List\n");
	    personRoster.sort(Person::compareByLastName);
	    System.out.println(this.toString());
	}

    
    public void sort_by_id() {
		System.out.println("Student List\n");
    	studentRoster.sort(Person :: compareByID);
	    System.out.println(this.toString()); // This will call the overridden toString method of the School class
    	
		System.out.println("Person List\n");
    	personRoster.sort(Person :: compareByID);
	    System.out.println(this.toString()); // This will call the overridden toString method of the School class
    	
    }
    
    public void sort_gpa() {
		System.out.println("Student List\n");
    	studentRoster.sort(Student :: compareByGPA);
	    System.out.println(this.toString()); // This will call the overridden toString method of the School class

    	
		System.out.println("Person List\n");		
		
		
		List<Student> tempStudentList = new ArrayList<>();

	    // Iterate through personRoster and add students to tempStudentList
	    for (Person person : personRoster) {
	        if (person instanceof Student) {
	            tempStudentList.add((Student) person); // Cast Person to Student
	        }
	    }

	    // Sort tempStudentList by GPA using the compareByGPA method
	    tempStudentList.sort(Student::compareByGPA);

	    // Clear personRoster and add sorted students back to it
	    personRoster.clear();
	    personRoster.addAll(tempStudentList);
	    
	    /*for(Person person : personRoster) {
    		System.out.println(person.toString());
    	}*/
	    System.out.println(this.toString());
    }
    
    
   /*@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //sb.append("Student Roster: \n");
        for (Student student : studentRoster) {
            sb.append(student.fName).append(" ").append(student.lName).append(" ").append(student.getGpa()).append(" ").append(student.id).append(" ").append(student.age).append(" Father is ").append(student.getParents().getFather_name()).append(" Mother is ").append(student.getParents().getMother_name()).append("\n");
        }
        
        /*sb.append("Person Roster: \n");
        for (Person person : studentRoster) {
            sb.append(person.fName).append(" ").append(person.lName).append(" ").append(((Student) person).getGpa()).append(" ").append(person.id).append(" ").append(person.age).append("\n");
        //}
        return sb.toString();
    }*/
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Check if it's a studentRoster or personRoster and format accordingly
        if (!studentRoster.isEmpty()) {
            sb.append("Student Roster:\n");
            for (Person person : studentRoster) {
                if (person instanceof Student) {
                    Student student = (Student) person;
                    sb.append(student.fName).append(" ").append(student.lName).append(" ").append(student.getGpa()).append(" ").append(student.id).append(" ").append(student.age);
                    sb.append(" Father is ").append(student.getParents().getFather_name()).append(" Mother is ").append(student.getParents().getMother_name());
                    sb.append("\n");
                }
            }
        } else if (!personRoster.isEmpty()) {
            sb.append("Person Roster:\n");
            for (Person person : personRoster) {
                //sb.append(person.fName).append(" ").append(person.lName).append(" ").append(Student)person.getGpa()).append(" ").append(person.id).append(" ").append(person.age);
                sb.append(person.fName).append(" ").append(person.lName).append(" ").append(((Student) person).getGpa()).append(" ").append(person.id).append(" ").append(person.age);

                sb.append("\n");
            }
        }

        return sb.toString();
    }




        
        
    public static void demo() {
        School school = new School();
        List<Student> students = readStudentCSVFile();
        for (Student student : students) {
            school.addStudent(student);
        }
        List<Person> persons = readPersonCSVFile();
        for (Person person : persons) {
            school.addPerson((Student) person);
        }
        
        // Sort by ID and print
        System.out.println("School sorted by ID");
        school.sort_by_id();
        //System.out.println(school);

        // Sort by Age and print
        System.out.println("School sorted by Age");
        school.sort_by_age();
        //System.out.println(school);

        // Sort by Last Name and print
        System.out.println("School sorted by Last Name");
        school.sort_by_last_name();
        //System.out.println(school);

        // Sort by GPA and print
        System.out.println("School sorted by GPA");
        school.sort_gpa();
        //System.out.println(school);
    }
}
