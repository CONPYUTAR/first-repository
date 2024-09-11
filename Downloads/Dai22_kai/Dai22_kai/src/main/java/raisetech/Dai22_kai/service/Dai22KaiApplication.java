package raisetech.Dai22_kai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import raisetech.Dai22_kai.data.Student;
import raisetech.Dai22_kai.repository.StudentRepository;

@SpringBootApplication
@RestController
public class Dai22KaiApplication {

	@Autowired
	private StudentRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Dai22KaiApplication.class, args);
	}

	@GetMapping("/student")
	public String getStudent(@RequestParam String name) {
		Student student = repository.searchByName(name);
		if (student != null) {
			return student.getName() + " " + student.getAge() + "歳";
		} else {
			return "Student not found";
		}
	}

	@PostMapping("/student")
	public void registerStudent(@RequestParam String name, @RequestParam int age) {
		repository.registerStudent(name, age);
	}

	@PatchMapping("/student")
	public void updateStudent(@RequestParam String name, @RequestParam int age) {
		repository.updateStudent(name, age);
	}

	@DeleteMapping("/student")
	public void deleteStudent(@RequestParam String name) {
		repository.deleteStudent(name);
	}
}
