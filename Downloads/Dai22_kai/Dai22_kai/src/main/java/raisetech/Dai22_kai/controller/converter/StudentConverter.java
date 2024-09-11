package raisetech.Dai22_kai.controller.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import raisetech.Dai22_kai.data.Student;
import raisetech.Dai22_kai.data.StudentsCourses;
import raisetech.Dai22_kai.domain.StudentDetail;

@Component
public class StudentConverter {

  public List<StudentDetail> convertStudentDetails(List<Student> students,
      List<StudentsCourses> studentsCourses) {
    List<StudentDetail> studentDetails = new ArrayList<>();
    students.forEach(student -> {
      StudentDetail studentDetail = new StudentDetail();
      studentDetail.setStudent(student);

      List<StudentsCourses> convertStudentCourses = studentsCourses.stream()
          .filter(studentCourses -> student.getId().equals(studentCourses.getStudentId()))
          .collect(Collectors.toList());

      studentDetail.setStudentCourses(convertStudentCourses);
      studentDetails.add(studentDetail);
    });
    return studentDetails;
  }
}
