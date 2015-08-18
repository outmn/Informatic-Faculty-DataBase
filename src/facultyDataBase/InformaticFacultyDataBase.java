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
    private StudentDao courseDao;


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

    //    Розробити базу даних факультету інформатики.
    //
    //    БД має містити: студентів, викладачів, курси.
    //
    //    Написати заповнення інформації, пошук і видалення.

    public static void main(String[] args){
        InformaticFacultyDataBase studentDataBase = new InformaticFacultyDataBase();

        studentDataBase.initialization("testDB.db");


        StudentDao studentDao = new StudentDao(studentDataBase.connection);
        studentDao.insert("леся", "леся");
        studentDao.insert("петя", "петя");
        studentDao.insert("маша", "маша");



        List <StudentEntity> students =  new ArrayList<StudentEntity>(studentDao.findAll());

        for (StudentEntity student : students) {
            System.out.println(student.getName() + student.getSurname());
        }

        studentDao.delete("петя");



        List <StudentEntity> students1 =  new ArrayList<StudentEntity>(studentDao.findAll());

        for (StudentEntity student : students1) {
            System.out.println(student.getName() + student.getSurname());
        }
    }
}
