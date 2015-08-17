package facultyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maximgrozniy on 22.07.15.
 */
public class StudentDao implements DAO <StudentEntity>{

    private Connection connection;

    public StudentDao(Connection connection){
        this.connection = connection;
        initialization();
    }
    private void initialization(){
        try{
            PreparedStatement student = connection.prepareStatement(StudentEntity.STUDENT_TABLE_CREATE);
            int result = student.executeUpdate();
        }catch (SQLException e){
            System.out.println("Не вірний SQL запит");
            e.printStackTrace();
        }
    }



    @Override
    public List<StudentEntity> getAll() {
        List <StudentEntity> listOfStudent = new ArrayList<StudentEntity>();

        try{
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM StudentEntity");

            while (res.next()) {
                StudentEntity studentEntity = new StudentEntity();
                studentEntity.setId_student(res.getInt("id"));
                studentEntity.setName(res.getString("name"));
                studentEntity.setSurname(res.getString("surname"));

                listOfStudent.add(studentEntity);
            }
            res.close();
            st.close();
        }catch(SQLException e){
            System.out.println("Не вірний SQL запит на вибірку даних");
            e.printStackTrace();
        }

        return listOfStudent;
    }

    @Override
    public List<StudentEntity> getById(int id) {
        List <StudentEntity> listOfStudent = new ArrayList<StudentEntity>();

        try{
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM StudentEntity WHERE id = " + id + "");

                StudentEntity studentEntity = new StudentEntity();
                studentEntity.setId_student(res.getInt("id"));
                studentEntity.setName(res.getString("name"));
                studentEntity.setSurname(res.getString("surname"));

                listOfStudent.add(studentEntity);

            res.close();
            st.close();
        }catch(SQLException e){
            System.out.println("Не вірний SQL запит на вибірку даних");
            e.printStackTrace();
        }

        return listOfStudent;
    }

    @Override
    public List<StudentEntity> getByName(String surname) {
        List <StudentEntity> listOfStudent = new ArrayList<StudentEntity>();

        try{
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM StudentEntity WHERE surname = " + surname +"");

            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setId_student(res.getInt("id"));
            studentEntity.setName(res.getString("name"));
            studentEntity.setSurname(res.getString("surname"));

            listOfStudent.add(studentEntity);

            res.close();
            st.close();
        }catch(SQLException e){
            System.out.println("Не вірний SQL запит на вибірку даних");
            e.printStackTrace();
        }

        return listOfStudent;
    }

    @Override
    public boolean insert(String name, String surname) {
        boolean isInsert = false;

        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO StudentEntity(name, surname) VALUES (?, ?)");

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
    public boolean update(StudentEntity entity) {
        boolean isUpdated = false;

        try{
            PreparedStatement statement = connection.prepareStatement("UPDATE StudentEntity SET name = ?, surname = ? WHERE id = ?");

            statement.setString(1, entity.getName());
            statement.setString(2, entity.getSurname());
            statement.setInt(3, entity.getId_student());

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
    public boolean delete(StudentEntity entity) {
        boolean isDelete = false;

        try{
            PreparedStatement statement = connection.prepareStatement("DELETE FROM StudentEntity WHERE id = ?");

            statement.setInt(1, entity.getId_student());

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
            PreparedStatement statement = connection.prepareStatement("DELETE FROM StudentEntity WHERE id = ?");

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
            PreparedStatement statement = connection.prepareStatement("DELETE FROM StudentEntity WHERE surname = ?");

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
