package facultyDataBase;

/**
 * Created by maximgrozniy on 21.08.15.
 */
public class LecturerCourseEntity {
    private int id_LecturerCourseEntity;
    private int id_lecturer;
    private int id_course;
    private static String tableName = "LecturerCourseEntity";
    public final static String LECTURERCOURSE_TABLE_CREATE = "create table if not exists " + tableName +
            " ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'id_lecturer' int, 'id_course' int);";


    public static String getTableName() {
        return tableName;
    }

    public int getId_lecturer() {
        return id_lecturer;
    }

    public int getId_course() {
        return id_course;
    }

    public void setId_lecturer(int id_lecturer) {
        this.id_lecturer = id_lecturer;
    }

    public void setId_course(int id_course) {
        this.id_course = id_course;
    }
}
