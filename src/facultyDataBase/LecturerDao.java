package facultyDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by maximgrozniy on 22.07.15.
 */
public class LecturerDao {

    private Connection connection;
    public LecturerDao(Connection connection){
        this.connection = connection;
        initialization();
    }
    private void initialization(){
        try{
            PreparedStatement lecturer = connection.prepareStatement(LecturerEntity.LECTURER_TABLE_CREATE);
            int result = lecturer.executeUpdate();
        }catch (SQLException e){
            System.out.println("Не вірний SQL запит");
            e.printStackTrace();
        }
    }

    public void addLecturer(LecturerEntity lecturerEntity){

    }
}
