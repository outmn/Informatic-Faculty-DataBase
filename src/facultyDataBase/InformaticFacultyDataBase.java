package facultyDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maximgrozniy on 22.07.15.
 */
public class InformaticFacultyDataBase {
    private Connection connection;
    private StudentDao studentDao;
    private LecturerDao lecturerDao;
    private CourseDao courseDao;


    private void initialization(String name){
        try{

            connection = null;
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + name);

        }catch(ClassNotFoundException e){
            System.out.println("Не знайшли драйвер JDBC");
            e.printStackTrace();
            System.exit(0);
        }catch (SQLException e){
            System.out.println("Не вірний SQL запит");
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return this.getConnection();
    }

    public void addStudent(StudentEntity studentEntity){
        studentDao.insert(studentEntity);
    }

    public void addLecturer(LecturerEntity lecturerEntity){
        lecturerDao.insert(lecturerEntity);
    }

    public void addCourse(CourseEntity courseEntity){
        courseDao.insert(courseEntity);
    }

    //    Розробити базу даних факультету інформатики.
    //    БД має містити: студентів, викладачів, курси.
    //    Написати заповнення інформації, пошук і видалення.

    public static void main(String[] args){
        InformaticFacultyDataBase informaticFacultyDataBase = new InformaticFacultyDataBase();

        informaticFacultyDataBase.initialization("InformaticFacultyDataBase.db");


        StudentDao studentDao = new StudentDao(informaticFacultyDataBase.connection);
        LecturerDao lecturerDao = new LecturerDao(informaticFacultyDataBase.connection);
        CourseDao courseDao = new CourseDao(informaticFacultyDataBase.connection);
        StudentCourseEntityDao studentCourseEntityDao = new StudentCourseEntityDao(informaticFacultyDataBase.connection);






        System.out.println("Вывод данных таблиц:");

        List <StudentEntity> students =  new ArrayList<StudentEntity>(studentDao.getAll());

        for (StudentEntity student : students) {
            System.out.println(student.getId_student() + " " + student.getName() + " " + student.getSurname());
        }

        System.out.println();


        List <LecturerEntity> lecturers =  new ArrayList<LecturerEntity>(lecturerDao.getAll());

        for (LecturerEntity lecturer : lecturers) {
            System.out.println(lecturer.getId_lecturer() + " " + lecturer.getName() + " " + lecturer.getSurname());
        }

        System.out.println();

        List <CourseEntity> courses =  new ArrayList<CourseEntity>(courseDao.getAll());

        for (CourseEntity course : courses) {
            System.out.println(course.getId_course() + " " + course.getName() + " " + course.getDuration());
        }

//        studentCourseEntityDao.insert(students.get(0), courses.get(0));
//        studentCourseEntityDao.insert(students.get(0), courses.get(1));
//        studentCourseEntityDao.insert(students.get(0), courses.get(2));
//        studentCourseEntityDao.insert(students.get(1), courses.get(0));
//        studentCourseEntityDao.insert(students.get(2), courses.get(0));
//        studentCourseEntityDao.insert(students.get(3), courses.get(3));
//        studentCourseEntityDao.insert(students.get(4), courses.get(0));
//        studentCourseEntityDao.insert(students.get(5), courses.get(1));
//        studentCourseEntityDao.insert(students.get(6), courses.get(0));
//        studentCourseEntityDao.insert(students.get(7), courses.get(2));
//        studentCourseEntityDao.insert(students.get(8), courses.get(3));
//        studentCourseEntityDao.insert(students.get(9), courses.get(0));
//        studentCourseEntityDao.insert(students.get(10), courses.get(2));

        System.out.println();

        List <StudentCourseEntity> courses_students =  new ArrayList<StudentCourseEntity>(studentCourseEntityDao.getAll());

        for (StudentCourseEntity course : courses_students) {
            System.out.println(course.getId_StudentCourseEntity() + " " + course.getId_course() + " " + course.getId_student());
        }

    }
}
