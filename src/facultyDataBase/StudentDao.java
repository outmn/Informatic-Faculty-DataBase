package facultyDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by maximgrozniy on 22.07.15.
 */
public class StudentDao {

    private Connection connection;
    public StudentDao(Connection connection){
        this.connection = connection;
        initialization();
    }
    private void initialization(){
        try{
            PreparedStatement student = connection.prepareStatement(StudentEntity.STUDENT_TABLE_CREATE);
            int result = student.executeUpdate();
        }catch (SQLException e){
            System.out.println("Не вірний SQL запит");
            e.printStackTrace();
        }
    }

    public void addStudent(StudentEntity studentEntity){

    }

}
