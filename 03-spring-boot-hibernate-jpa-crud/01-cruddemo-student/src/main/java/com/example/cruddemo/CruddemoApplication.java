package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.dao.StudentDAOImpI;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
//			createStudent(studentDAO);
//			createMultipleStudent(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
			deleteAllStudnet(studentDAO);
		};
	}

	private void deleteAllStudnet(StudentDAO studentDAO) {

		System.out.println("Deleting all studnets..");
		int numOfRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted rows count : " + numOfRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 4;
		System.out.println("Deleting student with id " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on id: primary key
		int studentId = 1;
		System.out.println("Getting the student with id" + studentId);
		Student myStudent = studentDAO.findById(studentId);
		System.out.println("Before updating student : " + myStudent);

		//change first name to khatra
		System.out.println("Updating student name...");
		myStudent.setFirstName("Sahin");


		//update the student
		studentDAO.update(myStudent);

		//display the updated student
		System.out.println(myStudent);

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents = studentDAO.findByFirstName("pranim");

		//display students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get List of Students
		List<Student> theStudents = studentDAO.findAll();

		//display that list of Students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create new student
		System.out.println("Creating new student....");
		Student tempStudent = new Student("Shushant", "Chaudary", "Shusantchaudaryzzz@gmail.com");


		//save student
		System.out.println("Saving student....");
		studentDAO.save(tempStudent);

		//display the id of the student
		int studentId = tempStudent.getId();
		System.out.println("Saved student. Generated Id :  " + studentId);

		//retrieve the student based on id

		System.out.println("Retrieving student with id : " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		//display the student
		System.out.println("Found the student" + myStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		//create student
		System.out.println("Creating 3 new student object....");
		Student tempStudent1 = new Student("sahin", "rai", "sahinraizzz@gmail.com");
		Student tempStudent2 = new Student("pranim", "thakuri", "pranimthakurizzz@gmail.com");
		Student tempStudent3 = new Student("ranish", "bartaula", "ranishbartaula@gmail.com");

		//save student
		System.out.println("Saving multiple student....");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {
		//create a student object
		System.out.println("Creating new student object....");
		Student tempStudent = new Student("prajwol", "subedi", "prajwolsubedizzz@gmail.com");

		//save the student object

		System.out.println("Saving the student....");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

}
