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

//        studentDao.insert("Леся", "Украинка");
//        studentDao.insert("Тарас", "Шевченко");
//        studentDao.insert("Иван", "Франко");
//
//        lecturerDao.insert("Петр", "Мазепа");
//        lecturerDao.insert("Петр", "Сагайдачный");
//        lecturerDao.insert("Леонид", "Черновецкий");
//
//        courseDao.insert("Java", "2 месяца");
//        courseDao.insert("Swift", "4 месяца");
//        courseDao.insert("C", "1 месяц");
//        courseDao.insert("Machine learning", "2 месяца");

//        courseDao.delete(5);
//        courseDao.delete(6);
//        courseDao.delete(7);
//        courseDao.delete(8);
//        courseDao.delete(9);
//        courseDao.delete(10);
//        courseDao.delete(11);
//        courseDao.delete(12);
//        courseDao.delete(13);
//        courseDao.delete(14);
//        courseDao.delete(15);
//        courseDao.delete(16);


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
    }
}
