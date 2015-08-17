package facultyDataBase;

/**
 * Created by maximgrozniy on 22.07.15.
 */
public class LecturerEntity {
    private int id_lecturer;
    private String name;
    private String surname;

    public void setId_lecturer(int id_lecturer) {
        this.id_lecturer = id_lecturer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId_lecturer() {
        return id_lecturer;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }



    public final static String LECTURER_TABLE_CREATE = "create table if not exists 'LecturerEntity' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'surname' text);";

}
