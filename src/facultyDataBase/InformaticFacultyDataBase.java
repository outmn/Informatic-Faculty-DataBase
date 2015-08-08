package facultyDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by maximgrozniy on 22.07.15.
 */
public class InformaticFacultyDataBase {
    private Connection connection;
    private StudentDao sDao;

    private void initialization(String name){
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + name);
            sDao = new StudentDao(getConnection());
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
        sDao.addStudent(studentEntity);

}

    public static void main(String[] args){
        InformaticFacultyDataBase studentDataBase = new InformaticFacultyDataBase();

    }
}
