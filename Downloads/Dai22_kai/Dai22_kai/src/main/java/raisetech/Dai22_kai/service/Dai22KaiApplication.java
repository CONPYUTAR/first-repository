package raisetech.Dai22_kai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.Dai22_kai.data.Student;
import raisetech.Dai22_kai.repository.StudentRepository;

@SpringBootApplication
@RestController
public class Dai22KaiApplication {

	@Autowired
	private StudentRepository repository;

	private String name ="Enami Kouji";
	private String age = "37";

	public static void main(String[] args) {
		SpringApplication.run(Dai22KaiApplication.class, args);
	}

	@GetMapping("/studentInfo")
	public String getStudentInfo() {
    Student student = repository.searchByName("TnakaTarou");
		return name + "" + age +"歳";
	}

  @PostMapping("/studentInfo")
  public void setStudentInfo(String name, String age) {
		this.name = name;
		this.age = age;
	}

  @PostMapping("/studentName")
	public void updateStudentName(String name) {
		this.name = name;
	}
}
