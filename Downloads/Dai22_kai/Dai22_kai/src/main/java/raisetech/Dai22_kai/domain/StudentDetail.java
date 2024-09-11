package raisetech.Dai22_kai.domain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import raisetech.Dai22_kai.data.Student;
import raisetech.Dai22_kai.data.StudentsCourses;

@Getter
@Setter
public class StudentDetail {

  private Student student;
  private List<StudentsCourses> studentCourses;

}
