package facultyDataBase;

/**
 * Created by maximgrozniy on 22.07.15.
 */
public class StudentEntity {
    private int id_student;
    private String name;
    private String surname;
    private String tableName = "StudentEntity";

    public String getTableName() {
        return tableName;
    }

    public int getId_student() {
        return id_student;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public final static String STUDENT_TABLE_CREATE = "create table if not exists 'StudentEntity' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'surname' text);";
}
