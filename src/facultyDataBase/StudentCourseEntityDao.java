package facultyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maximgrozniy on 19.08.15.
 */
public class StudentCourseEntityDao {

    private Connection connection;
    private StudentCourseEntity studentCourseEntity;

    public StudentCourseEntityDao(Connection connection){
        this.connection = connection;
        initialization();
    }
    private void initialization(){
        try{
            PreparedStatement studentCourse = connection.prepareStatement(StudentCourseEntity.STUDENTCOURSE_TABLE_CREATE);
            int result = studentCourse.executeUpdate();
        }catch (SQLException e){
            System.out.println("Не вірний SQL запит");
            e.printStackTrace();
        }
    }


    public List<StudentCourseEntity> getAll() {
        List <StudentCourseEntity> listOfCourseStudent = new ArrayList<StudentCourseEntity>();

        try{
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM StudentCourseEntity");

            while (res.next()) {
                StudentCourseEntity courseStudentEntity = new StudentCourseEntity();
                courseStudentEntity.setId_StudentCourseEntity(res.getInt("id"));
                courseStudentEntity.setId_student(res.getInt("id_student"));
                courseStudentEntity.setId_course(res.getInt("id_course"));

                listOfCourseStudent.add(courseStudentEntity);
            }
            res.close();
            st.close();
        }catch(SQLException e){
            System.out.println("Не вірний SQL запит на вибірку даних");
            e.printStackTrace();
        }

        return listOfCourseStudent;
    }


    public List<StudentCourseEntity> getByStudent(StudentEntity entity) {
        List <StudentCourseEntity> listOfCourseStudent = new ArrayList<StudentCourseEntity>();

        try{
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM " + studentCourseEntity.getTableName() + " WHERE id = " + entity.getId_student() + "");

            StudentCourseEntity studentCourseEntity = new StudentCourseEntity();
            studentCourseEntity.setId_StudentCourseEntity(res.getInt("id"));
            studentCourseEntity.setId_student(res.getInt("id_student"));
            studentCourseEntity.setId_course(res.getInt("id_course"));

            listOfCourseStudent.add(studentCourseEntity);

            res.close();
            st.close();
        }catch(SQLException e){
            System.out.println("Не вірний SQL запит на вибірку даних");
            e.printStackTrace();
        }

        return listOfCourseStudent;
    }

    public List<StudentCourseEntity> getByCourse(CourseEntity entity) {
        List <StudentCourseEntity> listOfCourseStudent = new ArrayList<StudentCourseEntity>();

        try{
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM " + studentCourseEntity.getTableName() + " WHERE id = " + entity.getId_course() + "");

            StudentCourseEntity studentCourseEntity = new StudentCourseEntity();
            studentCourseEntity.setId_StudentCourseEntity(res.getInt("id"));
            studentCourseEntity.setId_student(res.getInt("id_student"));
            studentCourseEntity.setId_course(res.getInt("id_course"));

            listOfCourseStudent.add(studentCourseEntity);

            res.close();
            st.close();
        }catch(SQLException e){
            System.out.println("Не вірний SQL запит на вибірку даних");
            e.printStackTrace();
        }

        return listOfCourseStudent;
    }

    public boolean insert(StudentEntity student, CourseEntity course) {
        boolean isInsert = false;

        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO " + studentCourseEntity.getTableName() + "(id_student, id_course) VALUES (?, ?)");

            statement.setInt(1, student.getId_student());
            statement.setInt(2, course.getId_course());
            int result = statement.executeUpdate();
            statement.close();
            isInsert = true;
        }catch (SQLException e){
            System.out.println("Не вірний SQL запит на вставку");
            e.printStackTrace();
        }


        return isInsert;
    }

    public boolean update(StudentEntity student, CourseEntity course) {
        boolean isUpdated = false;

        try{
            PreparedStatement statement = connection.prepareStatement("UPDATE " + studentCourseEntity.getTableName() + " SET id_course = ? WHERE id_student = ?");

            statement.setInt(1, course.getId_course());

            int result = statement.executeUpdate();
            statement.close();
            isUpdated = true;
        }catch (SQLException e){
            System.out.println("Не вірний SQL запит на видалення");
            e.printStackTrace();
        }


        return isUpdated;
    }

    public boolean delete(StudentEntity entity) {
        boolean isDelete = false;

        try{
            PreparedStatement statement = connection.prepareStatement("DELETE FROM " + studentCourseEntity.getTableName() + " WHERE id_student = ?");

            statement.setInt(1, entity.getId_student());

            int result = statement.executeUpdate();
            statement.close();
            isDelete = true;
        }catch (SQLException e){
            System.out.println("Не вірний SQL запит на видалення");
            e.printStackTrace();
        }


        return isDelete;
    }

    public boolean delete(CourseEntity entity) {
        boolean isDelete = false;

        try{
            PreparedStatement statement = connection.prepareStatement("DELETE FROM " + studentCourseEntity.getTableName() + " WHERE id_course = ?");

            statement.setInt(1, entity.getId_course());

            int result = statement.executeUpdate();
            statement.close();
            isDelete = true;
        }catch (SQLException e){
            System.out.println("Не вірний SQL запит на видалення");
            e.printStackTrace();
        }


        return isDelete;
    }
}
