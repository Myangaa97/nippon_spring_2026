package com.icode;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	public record Student(int id, String firstName, String lastName, String email, String major, int enrollmentYear,
			boolean isActive, int credits) {
	}

	private List<Student> students;

	public StudentController() {
		students = new ArrayList<>(List.of(
				new Student(1, "Alan", "Turing", "a.Turing@university.com", "Computer Science", 2021, false, 120),
				new Student(2, "Ada", "Lovelace", "a.Lovelace@university.com", "Mathematics", 2022, true, 95),
				new Student(3, "Grace", "Hopper", "g.hopper@university.com", "System Engineering", 2022, true, 110),
				new Student(4, "Margarete", "Hammilton", "m.hammilton@university.com", "Software Enginering", 2023,
						true, 45),
				new Student(5, "John", "Von Neumann", "j.vonneumann@university.com", "Physics", 2019, false, 135)));
	}

	@GetMapping("/search")
	public List<Student> getByName(@RequestParam String firstName) {
		List<Student> matches = new ArrayList<>();

		for (Student student : students) {
			if (student.firstName.equalsIgnoreCase(firstName)) {
				matches.add(student);
			}
		}

		return matches;
	}
	
	@GetMapping("/search/advanced")
	public List<Student> searchByNameAndMajor(@RequestParam String firstName, @RequestParam String major){
		List<Student> matches = new ArrayList<>();
		for (Student student : students) {
			if (student.firstName.equalsIgnoreCase(firstName) && student.major.equalsIgnoreCase(major)) {
				matches.add(student);
			}
		}

		return matches;	
	}
	
	@GetMapping("/greet/{username}")
	public String greetStudent(@PathVariable String username) {
		return "Welcome to the class, " + username + "!"; 
	}
	
	@GetMapping("/profile/{id}")
	public Student searchById(@PathVariable int id){
		for (Student student : students) {
			if (student.id == id) {
				return student;
			}
		}

		return null;	
	}
	
	

}
