package com.stefandrei.onlinecatalog;

import com.stefandrei.onlinecatalog.model.Professor;
import com.stefandrei.onlinecatalog.model.Student;
import com.stefandrei.onlinecatalog.repository.StudentRepository;
import com.stefandrei.onlinecatalog.service.ProfessorService;
import com.stefandrei.onlinecatalog.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlinecatalogApplication implements CommandLineRunner {

    @Autowired
    private ProfessorService professorService;


    public static void main(String[] args) {
        SpringApplication.run (OnlinecatalogApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        // DEMO SAVE & UPDATE !

//		Professor professor = new Professor ();
//		professor.setProfessorFirstName ("Don");
//		professor.setProfessorLastName ("John");
//
//		Student student2 = new Student ();
//		student2.setFirstName ("Stephan");
//		student2.setLastName ("Andrei");
//
//		professorService.save (professor);
//		studentRepository.save (student2);
//
//
//		System.out.println ("**************** Before Delete ****************");
//		for (Student s: studentRepository.findAll ()
//			 ) {
//			System.out.println (s.getStudentId () + " . " + student.getFirstName () + " " + student.getLastName ());
//		}
//
//		System.out.println ("**************** After Delete ****************");
//		studentRepository.deleteById (2);
//
//		for (Student s: studentRepository.findAll ()
//		) {
//			System.out.println (s.getStudentId () + " . " + student.getFirstName () + " " + student.getLastName ());
//		}

    }
}
