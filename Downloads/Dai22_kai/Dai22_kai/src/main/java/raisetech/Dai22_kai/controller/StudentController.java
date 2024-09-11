package raisetech.Dai22_kai.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import raisetech.Dai22_kai.controller.converter.StudentConverter;
import raisetech.Dai22_kai.data.Student;
import raisetech.Dai22_kai.service.StudentService;
import raisetech.Dai22_kai.data.StudentsCourses;

@Controller
public class StudentController {

  private StudentService service;
  private StudentConverter converter;

  @Autowired
  private StudentController(StudentService service, StudentConverter converter) {
    this.service = service;
    this.converter = converter;
  }

  @GetMapping("/studentList")
  public String getStudentList(Model model) {
    List<Student> students = service.searchStudentList();
    List<StudentsCourses> studentsCourses = service.searchStudentsCourseList();

    model.addAttribute("studentList",converter.convertStudentDetails(students,studentsCourses));
    return "studentList";
  }

  @GetMapping("/studentsCourseList")
  public List<StudentsCourses> getStudentsCourseList() {
    return service.searchStudentsCourseList();
  }

}


