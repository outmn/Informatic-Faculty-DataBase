package facultyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maximgrozniy on 22.07.15.
 */
public class LecturerDao implements DAO<LecturerEntity>{

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



    @Override
    public List<LecturerEntity> getAll() {
        List <LecturerEntity> listOfLecturers = new ArrayList<LecturerEntity>();

        try{
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM LecturerEntity");

            while (res.next()) {
                LecturerEntity lecturerEntity = new LecturerEntity();
                lecturerEntity.setId_lecturer(res.getInt("id"));
                lecturerEntity.setName(res.getString("name"));
                lecturerEntity.setSurname(res.getString("surname"));

                listOfLecturers.add(lecturerEntity);
            }
            res.close();
            st.close();
        }catch(SQLException e){
            System.out.println("Не вірний SQL запит на вибірку даних");
            e.printStackTrace();
        }

        return listOfLecturers;
    }

    @Override
    public List<LecturerEntity> getById(int id) {
        List <LecturerEntity> listOfLecturer = new ArrayList<LecturerEntity>();

        try{
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM LecturerEntity WHERE id = " + id + "");

            LecturerEntity lecturerEntity = new LecturerEntity();
            lecturerEntity.setId_lecturer(res.getInt("id"));
            lecturerEntity.setName(res.getString("name"));
            lecturerEntity.setSurname(res.getString("surname"));

            listOfLecturer.add(lecturerEntity);

            res.close();
            st.close();
        }catch(SQLException e){
            System.out.println("Не вірний SQL запит на вибірку даних");
            e.printStackTrace();
        }

        return listOfLecturer;
    }

    @Override
    public List<LecturerEntity> getByName(String surname) {
        List <LecturerEntity> listOfLecturer = new ArrayList<LecturerEntity>();

        try{
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM LecturerEntity WHERE surname = " + surname +"");

            LecturerEntity lecturerEntity = new LecturerEntity();
            lecturerEntity.setId_lecturer(res.getInt("id"));
            lecturerEntity.setName(res.getString("name"));
            lecturerEntity.setSurname(res.getString("surname"));

            listOfLecturer.add(lecturerEntity);

            res.close();
            st.close();
        }catch(SQLException e){
            System.out.println("Не вірний SQL запит на вибірку даних");
            e.printStackTrace();
        }

        return listOfLecturer;
    }

    @Override
    public boolean insert(LecturerEntity entity) {
        boolean isInsert = false;

        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO StudentEntity(name, surname) VALUES (?, ?)");

            statement.setString(1, entity.getName());
            statement.setString(2, entity.getSurname());
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
    public boolean insert(String name, String surname) {
        boolean isInsert = false;

        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO LecturerEntity(name, surname) VALUES (?, ?)");

            statement.setString(1, name);
            statement.setString(2, surname);
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
    public boolean update(LecturerEntity entity) {
        boolean isUpdated = false;

        try{
            PreparedStatement statement = connection.prepareStatement("UPDATE LecturerEntity SET name = ?, surname = ? WHERE id = ?");

            statement.setString(1, entity.getName());
            statement.setString(2, entity.getSurname());
            statement.setInt(3, entity.getId_lecturer());

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
    public boolean delete(LecturerEntity entity) {
        boolean isDelete = false;

        try{
            PreparedStatement statement = connection.prepareStatement("DELETE FROM LecturerEntity WHERE id = ?");

            statement.setInt(1, entity.getId_lecturer());

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
            PreparedStatement statement = connection.prepareStatement("DELETE FROM LecturerEntity WHERE id = ?");

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
    public boolean delete(String surname) {
        boolean isDelete = false;

        try{
            PreparedStatement statement = connection.prepareStatement("DELETE FROM LecturerEntity WHERE surname = ?");

            statement.setString(1, surname);

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
