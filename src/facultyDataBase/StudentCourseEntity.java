package facultyDataBase;

/**
 * Created by maximgrozniy on 19.08.15.
 */
public class StudentCourseEntity {

    private int id_StudentCourseEntity;
    private int id_student;
    private int id_course;

    public int getId_StudentCourseEntity() {
        return id_StudentCourseEntity;
    }

    public int getId_student() {
        return id_student;
    }

    public int getId_course() {
        return id_course;
    }

    public void setId_StudentCourseEntity(int id_StudentCourseEntity) {
        this.id_StudentCourseEntity = id_StudentCourseEntity;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public void setId_course(int id_course) {
        this.id_course = id_course;
    }

    private static String tableName = "StudentCourseEntity";

    public static String getTableName() {
        return tableName;
    }

    public final static String STUDENTCOURSE_TABLE_CREATE = "create table if not exists " + tableName + " ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'id_student' int, 'id_course' int);";

}
