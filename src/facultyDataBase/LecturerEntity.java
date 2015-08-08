package facultyDataBase;

/**
 * Created by maximgrozniy on 22.07.15.
 */
public class LecturerEntity {
    private int id_lecturer;
    private String name;
    private String surname;

    public final static String LECTURER_TABLE_CREATE = "create table if not exists 'LecturerEntity' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'surname' text);";

}
