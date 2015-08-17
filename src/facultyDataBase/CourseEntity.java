package facultyDataBase;

/**
 * Created by maximgrozniy on 22.07.15.
 */
public class CourseEntity {

    private int id_course;
    private String name;
    private String duration;

    public int getId_course() {
        return id_course;
    }

    public String getName() {
        return name;
    }

    public String getDuration() {
        return duration;
    }

    public void setId_course(int id_course) {
        this.id_course = id_course;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public final static String COURSE_TABLE_CREATE = "create table if not exists 'CourseEntity' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'duration' text);";
}
