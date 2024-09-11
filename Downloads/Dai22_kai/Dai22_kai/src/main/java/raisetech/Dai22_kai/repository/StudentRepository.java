package raisetech.Dai22_kai.repository;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import raisetech.Dai22_kai.data.Student;
import raisetech.Dai22_kai.data.StudentsCourses;

@Mapper
public interface StudentRepository {

  // すべての学生を検索
  @Select("SELECT * FROM students")
  List<Student> search();

  // 名前で学生を検索
  @Select("SELECT * FROM students WHERE name = #{name}")
  Student searchByName(@Param("name") String name);

  // 学生を登録
  @Insert("INSERT INTO students (name, age) VALUES (#{name}, #{age})")
  void registerStudent(@Param("name") String name, @Param("age") int age);

  // 学生を更新
  @Update("UPDATE students SET age = #{age} WHERE name = #{name}")
  void updateStudent(@Param("name") String name, @Param("age") int age);

  // 学生を削除
  @Delete("DELETE FROM students WHERE name = #{name}")
  void deleteStudent(@Param("name") String name);

  // すべての学生コース情報を検索
  @Select("SELECT * FROM students_courses")
  List<StudentsCourses> searchStudentsCourses();
}
