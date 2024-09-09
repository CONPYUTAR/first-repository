package raisetech.Dai22_kai.domain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import raisetech.Dai22_kai.data.Student;
import raisetech.Dai22_kai.data.StudentsCourses;
import raisetech.student.management.data.Student;
import raisetech.student.management.data.StudentCourses;

@Getter
@Setter

public class StudentDetail {

  private Student student;
  private List<StudentsCourses> studentCourses;

  public void add(StudentDetail studentDetail) {
  }

  public void setStudent(Student student) {

  }
}
