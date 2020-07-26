package com.stefandrei.onlinecatalog;

import com.stefandrei.onlinecatalog.model.Student;
import com.stefandrei.onlinecatalog.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlinecatalogApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;



	public static void main(String[] args) {
		SpringApplication.run(OnlinecatalogApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		// DEMO SALVARE & UPDATE !

		Student student = new Student ();
		student.setFirstName ("Stefanescu");
		student.setLastName ("Andrei");

		Student student2 = new Student ();
		student2.setFirstName ("Stefanescu");
		student2.setLastName ("Andrei");

		studentRepository.save (student);
		studentRepository.save (student2);

		for (Student s: studentRepository.findAll ()
			 ) {
			System.out.println (s.getStudentId () + " . " + student.getFirstName () + " " + student.getLastName ());
		}
		

	}
}
