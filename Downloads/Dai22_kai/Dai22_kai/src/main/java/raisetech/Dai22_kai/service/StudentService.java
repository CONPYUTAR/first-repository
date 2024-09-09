package raisetech.Dai22_kai.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import raisetech.Dai22_kai.data.Student;
import raisetech.Dai22_kai.data.StudentsCourses;
import raisetech.Dai22_kai.repository.StudentRepository;





public class StudentService {

  private StudentRepository repository;

  @Autowired
  public StudentService(StudentRepository repository) {
    this.repository.search();
}

 public List<Student> searchStudentList() {
   return repository.search();
 }

  public List<StudentsCourses> searchStudentsCourseList() {
    return repository.searchStudentsCourses();
  }
}
