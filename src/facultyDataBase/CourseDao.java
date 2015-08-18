package facultyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maximgrozniy on 18.08.15.
 */
public class CourseDao implements DAO <CourseEntity> {
    private Connection connection;

    public CourseDao(Connection connection){
        this.connection = connection;
        initialization();
    }
    private void initialization(){
        try{
            PreparedStatement course = connection.prepareStatement(LecturerEntity.LECTURER_TABLE_CREATE);
            int result = course.executeUpdate();
        }catch (SQLException e){
            System.out.println("Не вірний SQL запит");
            e.printStackTrace();
        }
    }

    @Override
    public List<CourseEntity> getAll() {
        List <CourseEntity> listOfCourses = new ArrayList<CourseEntity>();

        try{
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM CourseEntity");

            while (res.next()) {
                CourseEntity courseEntity = new CourseEntity();
                courseEntity.setId_course(res.getInt("id"));
                courseEntity.setName(res.getString("name"));
                courseEntity.setDuration(res.getString("duration"));

                listOfCourses.add(courseEntity);
            }
            res.close();
            st.close();
        }catch(SQLException e){
            System.out.println("Не вірний SQL запит на вибірку даних");
            e.printStackTrace();
        }

        return listOfCourses;
    }

    @Override
    public List<CourseEntity> getById(int id) {
        List <CourseEntity> listOfCourses = new ArrayList<CourseEntity>();

        try{
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM CourseEntity WHERE id = " + id + "");

            CourseEntity courseEntity = new CourseEntity();
            courseEntity.setId_course(res.getInt("id"));
            courseEntity.setName(res.getString("name"));
            courseEntity.setDuration(res.getString("duration"));

            listOfCourses.add(courseEntity);

            res.close();
            st.close();
        }catch(SQLException e){
            System.out.println("Не вірний SQL запит на вибірку даних");
            e.printStackTrace();
        }

        return listOfCourses;
    }

    @Override
    public List<CourseEntity> getByName(String surname) {
        List <CourseEntity> listOfCourses = new ArrayList<CourseEntity>();

        try{
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM CourseEntity WHERE surname = " + surname +"");

            CourseEntity courseEntity = new CourseEntity();
            courseEntity.setId_course(res.getInt("id"));
            courseEntity.setName(res.getString("name"));
            courseEntity.setDuration(res.getString("duration"));

            listOfCourses.add(courseEntity);

            res.close();
            st.close();
        }catch(SQLException e){
            System.out.println("Не вірний SQL запит на вибірку даних");
            e.printStackTrace();
        }

        return listOfCourses;
    }

    @Override
    public boolean insert(CourseEntity entity) {
        boolean isInsert = false;

        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO StudentEntity(name, duration) VALUES (?, ?)");

            statement.setString(1, entity.getName());
            statement.setString(2, entity.getDuration());
            int result = statement.executeUpdate();
            statement.close();
            isInsert = true;
        }catch (SQLException e){
            System.out.println("Не вірний SQL запит на вставку");
            e.printStackTrace();
        }


        return isInsert;
    }

    @Override
    public boolean insert(String name, String duration) {
        boolean isInsert = false;

        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO CourseEntity(name, duration) VALUES (?, ?)");

            statement.setString(1, name);
            statement.setString(2, duration);
            int result = statement.executeUpdate();
            statement.close();
            isInsert = true;
        }catch (SQLException e){
            System.out.println("Не вірний SQL запит на вставку");
            e.printStackTrace();
        }


        return isInsert;
    }

    @Override
    public boolean update(CourseEntity entity) {
        boolean isUpdated = false;

        try{
            PreparedStatement statement = connection.prepareStatement("UPDATE CourseEntity SET name = ?, duration = ? WHERE id = ?");

            statement.setString(1, entity.getName());
            statement.setString(2, entity.getDuration());
            statement.setInt(3, entity.getId_course());

            int result = statement.executeUpdate();
            statement.close();
            isUpdated = true;
        }catch (SQLException e){
            System.out.println("Не вірний SQL запит на видалення");
            e.printStackTrace();
        }


        return isUpdated;
    }

    @Override
    public boolean delete(CourseEntity entity) {
        boolean isDelete = false;

        try{
            PreparedStatement statement = connection.prepareStatement("DELETE FROM CourseEntity WHERE id = ?");

            statement.setInt(1, entity.getId_course());

            int result = statement.executeUpdate();
            statement.close();
            isDelete = true;
        }catch (SQLException e){
            System.out.println("Не вірний SQL запит на видалення");
            e.printStackTrace();
        }


        return isDelete;
    }

    @Override
    public boolean delete(int id) {
        boolean isDelete = false;

        try{
            PreparedStatement statement = connection.prepareStatement("DELETE FROM CourseEntity WHERE id = ?");

            statement.setInt(1, id);

            int result = statement.executeUpdate();
            statement.close();
            isDelete = true;
        }catch (SQLException e){
            System.out.println("Не вірний SQL запит на видалення");
            e.printStackTrace();
        }


        return isDelete;
    }

    @Override
    public boolean delete(String duration) {
        boolean isDelete = false;

        try{
            PreparedStatement statement = connection.prepareStatement("DELETE FROM CourseEntity WHERE duration = ?");

            statement.setString(1, duration);

            int result = statement.executeUpdate();
            statement.close();
            isDelete = true;
        }catch (SQLException e){
            System.out.println("Не вірний SQL запит на видалення");
            e.printStackTrace();
        }


        return isDelete;
    }
}
