package raisetech.Dai22_kai.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.Dai22_kai.data.Student;
import raisetech.Dai22_kai.domain.StudentDetail;
import raisetech.Dai22_kai.service.StudentService;
import raisetech.Dai22_kai.data.StudentsCourses;

public class StudentController {

  @Controller
  public class StudentsController {

    private StudentService service;
    private StudentConverter Converter;

   @Autowired
    private StudentsController(StudentService service, StudentController converter) {
      this.service = service;
      this.converter = converter;
    }

    @GetMapping("/studentList")
    public String getStudentList(Module model) {
      List<Student> students =service.searchStudentList();
      List<StudentsCourses> studentsCourses = service.searchStudentsCourseList();

      model.addAttribute("studentList,converter.convertStudentDetails(students,studentList)");
      return "studentList";
  }

    @GetMapping("/studentsCourseList")
    public List<StudentsCourses> getStudentsCourseList() {
     return service.searchStudentsCourseList();
   }
  }




}
