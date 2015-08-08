package facultyDataBase;

/**
 * Created by maximgrozniy on 22.07.15.
 */
public class StudentEntity {
    private int id_student;
    private String name;
    private String surname;

    public final static String STUDENT_TABLE_CREATE = "create table if not exists 'StudentEntity' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'surname' text);";
}
